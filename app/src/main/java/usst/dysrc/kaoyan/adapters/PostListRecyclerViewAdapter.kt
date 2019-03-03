package usst.dysrc.kaoyan.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import usst.dysrc.kaoyan.PostDetailActivity
import usst.dysrc.kaoyan.R
import usst.dysrc.kaoyan.entities.Post
import java.text.SimpleDateFormat

class PostListRecyclerViewAdapter(private val context:Context, private val postList:List<Post>):RecyclerView.Adapter<PostListRecyclerViewAdapter.PostItemViewHolder>(){
    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holderPostItem: PostItemViewHolder, position: Int) {
        holderPostItem.createDate_textView.text= SimpleDateFormat("yyyy-MM-dd").format(postList[position].createDate)
        holderPostItem.userName_textView.text=postList[position].userName
        holderPostItem.title_textView.text=postList[position].title
        holderPostItem.admireNum_textView.text= postList[position].admireNum.toString()
        holderPostItem.view.setOnClickListener {
            it.context.startActivity(Intent().putExtra("postId",postList[position].postId).setClass(it.context,PostDetailActivity::class.java))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListRecyclerViewAdapter.PostItemViewHolder {
        return PostItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_post,parent,false))
    }


    inner class PostItemViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var userName_textView=view.findViewById<TextView>(R.id.item_post_userName_textView)
        var createDate_textView=view.findViewById<TextView>(R.id.item_post_createDate_textView)
        var title_textView=view.findViewById<TextView>(R.id.item_post_title_textView)
        var admireNum_textView=view.findViewById<TextView>(R.id.item_post_admireNum_textView)

    }
}