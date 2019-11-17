package com.ikerfah.junction2019.kitchen

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.ikerfah.junction2019.R
import kotlinx.android.synthetic.main.item_expandable_group.view.*
import android.widget.LinearLayout
import android.util.TypedValue
import android.view.ViewGroup.MarginLayoutParams
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide


class CustomExpandableListAdapter(
    private val context: Context, private val expandableListTitle: List<MyChickenGroup>,
    private val expandableListDetail: HashMap<String, List<MyChickenChild>>
) : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): MyChickenChild {
        return this.expandableListDetail[this.expandableListTitle[listPosition].name]!![expandedListPosition]
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int, expandedListPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition)
        if (convertView == null) {
            val layoutInflater = this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_expandable_child, null)
        }
        val title = convertView!!
            .findViewById(R.id.text_title) as TextView

        val weight = convertView!!
            .findViewById(R.id.text_weight) as TextView

        val img = convertView!!
            .findViewById(R.id.img) as AppCompatImageView
        title.text = expandedListText.name
        weight.text = expandedListText.weight
        Glide.with(context).load("http://192.168.43.15:8001/${expandedListText.imgUrl}")
            .into(img)




        return convertView
    }

    fun convertDBToPx():Int{
        val r = context.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            50f,
            r.displayMetrics
        ).toInt()
    }
    override fun getChildrenCount(listPosition: Int): Int {
        return this.expandableListDetail[this.expandableListTitle[listPosition].name]!!.size
    }

    override fun getGroup(listPosition: Int): MyChickenGroup {
        return this.expandableListTitle[listPosition]
    }

    override fun getGroupCount(): Int {
        return this.expandableListTitle.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int, isExpanded: Boolean,
        convertView: View?, parent: ViewGroup
    ): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition)
        if (convertView == null) {
            val layoutInflater =
                this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.item_expandable_group, null)
        }
        val title = convertView!!
            .findViewById(R.id.text_title) as TextView

        val items = convertView!!
            .findViewById(R.id.text_items) as TextView
        title.setTypeface(null, Typeface.BOLD)
        val img = convertView!!
            .findViewById(R.id.img) as AppCompatImageView
        title.text = listTitle.name
        items.text = listTitle.nbItems.toString()
        Glide.with(context).load("http://192.168.43.15:8001/${listTitle.imgUrl}")
            .error(R.drawable.meal1)
            .into(img);


        if (isExpanded) {
            convertView.img_arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            convertView.img_arrow.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        }


        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}