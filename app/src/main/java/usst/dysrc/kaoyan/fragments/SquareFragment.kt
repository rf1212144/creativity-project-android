package usst.dysrc.kaoyan.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.fastjson.JSON
import kotlinx.android.synthetic.main.fragment_square.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import usst.dysrc.kaoyan.R
import usst.dysrc.kaoyan.adapters.PostListRecyclerViewAdapter
import usst.dysrc.kaoyan.entities.Post
import usst.dysrc.kaoyan.utils.OKHTTPUtils
import usst.dysrc.kaoyan.utils.ServerUtil

class SquareFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_square, null)
        view.postList_recyclerView!!.layoutManager=LinearLayoutManager(activity)
        doAsync {
            val response=OKHTTPUtils.getData(ServerUtil.SERVER_HOST_URL+ServerUtil.SERVER_POST_SEARCH_POST_URL+"/-1")
            val postList: List<Post> = JSON.parseArray(response.body()!!.string(), Post::class.java)
            uiThread {
                view.postList_recyclerView.adapter=PostListRecyclerViewAdapter(it.context!!,postList)
            }
        }
        view.postList_swipeRefreshLayout!!.setOnRefreshListener {
            doAsync {
                val response=OKHTTPUtils.getData(ServerUtil.SERVER_HOST_URL+ServerUtil.SERVER_POST_SEARCH_POST_URL+"/-1")
                val postList: List<Post> = JSON.parseArray(response.body()!!.string(), Post::class.java)
                uiThread {
                    view.postList_recyclerView!!.adapter=PostListRecyclerViewAdapter(it.context!!,postList)
                }
            }
        }
        return view
    }
}