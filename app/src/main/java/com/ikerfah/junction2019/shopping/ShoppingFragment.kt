package com.ikerfah.junction2019.shopping


import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ikerfah.junction2019.Faker
import com.ikerfah.junction2019.MainViewModel
import com.ikerfah.junction2019.Utils
import com.ikerfah.junction2019.databinding.FragmentMyKitchenBinding
import com.ikerfah.junction2019.kitchen.CustomExpandableListAdapter
import com.ikerfah.junction2019.kitchen.MyChickenChild
import com.ikerfah.junction2019.kitchen.MyChickenGroup
import com.ikerfah.junction2019.models.ProductResponse
import com.ikerfah.junction2019.retro.Ressource


/**
 * A simple [Fragment] subclass.
 */
class ShoppingFragment : Fragment() {
    private lateinit var mBinding: FragmentMyKitchenBinding


    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: List<MyChickenGroup>? = null
    var expandableListDetail: HashMap<String, List<MyChickenChild>>? = null

    private lateinit var mainViewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentMyKitchenBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    private var mContext: Context? = null
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
    }

    fun GetPixelFromDips(pixels: Float): Int {
        // Get the screen's density scale
        val scale = resources.displayMetrics.density
        // Convert the dps to pixels, based on density scale
        return (pixels * scale + 0.5f).toInt()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        mBinding.expandableListview.setOnGroupExpandListener { groupPosition ->
            /*Toast.makeText(
                mContext,
                expandableListTitle!![groupPosition] + " List Expanded.",
                Toast.LENGTH_SHORT
            ).show()*/
        }

        mBinding.expandableListview.setOnGroupCollapseListener { groupPosition ->
            /*Toast.makeText(
                mContext,
                expandableListTitle!![groupPosition] + " List Collapsed.",
                Toast.LENGTH_SHORT
            ).show()*/
        }

        mBinding.expandableListview.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            /*Toast.makeText(
                mContext,
                expandableListTitle!![groupPosition]
                        + " -> "
                        + expandableListDetail!![expandableListTitle!![groupPosition]]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()*/
            false
        }



        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.getMissedProduct().observe(this, Observer {

            if (it.state == Ressource.SUCCES) {
                expandableListDetail = Utils.getDataFromProductResponse(it.data!!)

                val tmp = expandableListDetail!!.keys.map {
                    MyChickenGroup(name = it, nbItems = expandableListDetail!![it]!!.size)
                }
                expandableListTitle = tmp


                expandableListAdapter =CustomExpandableListAdapter(
                    mContext!!,
                    expandableListTitle!!,
                    expandableListDetail!!
                )

                mBinding.expandableListview.setAdapter(expandableListAdapter)


            }
        })

    }


}
