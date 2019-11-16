package com.ikerfah.junction2019

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.TextureView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.ikerfah.junction2019.databinding.ActivityScanBinding
import java.util.concurrent.Executors

class ScanActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 10
    }

    private lateinit var textureView: TextureView
    private lateinit var mBinding:ActivityScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_scan)

        textureView = findViewById(R.id.texture_view)

        // Request camera permissions
        if (isCameraPermissionGranted()) {
            textureView.post { startCamera() }
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        }

        mBinding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun startCamera() {
        val previewConfig = PreviewConfig.Builder()
            // We want to show input from back camera of the device
            .setLensFacing(CameraX.LensFacing.BACK)
            .build()

        val preview = Preview(previewConfig)

        preview.setOnPreviewOutputUpdateListener { previewOutput ->
            textureView.surfaceTexture = previewOutput.surfaceTexture
        }

        val imageAnalysisConfig = ImageAnalysisConfig.Builder()
            .build()
        var imageAnalysis = ImageAnalysis(imageAnalysisConfig)

        val qrCodeAnalyzer = QrCodeAnalyzer {
            CameraX.unbindAll()
            Log.d("QrCodeAnalyzer", "QR Code detected: ${it.rawValue}.")
//            Toast.makeText(this, "Code Scanned ${it.rawValue}", Toast.LENGTH_LONG).show()
//            setResult(Activity.RESULT_OK)
            startActivity(Intent(this, SubmitDataActivity::class.java))
            finish()
        }

//        imageAnalysis.analyzer = qrCodeAnalyzer

        imageAnalysis.setAnalyzer(Executors.newSingleThreadExecutor(), qrCodeAnalyzer)

        // We need to bind preview and imageAnalysis use cases
        CameraX.bindToLifecycle(this as LifecycleOwner, preview, imageAnalysis)
    }

    private fun isCameraPermissionGranted(): Boolean {
        val selfPermission =
            ContextCompat.checkSelfPermission(baseContext, Manifest.permission.CAMERA)
        return selfPermission == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (isCameraPermissionGranted()) {
                textureView.post { startCamera() }
            } else {
                Toast.makeText(this, "Camera permission is required.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

}

