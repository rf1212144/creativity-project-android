package usst.dysrc.kaoyan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.alibaba.fastjson.JSON
import kotlinx.android.synthetic.main.activity_mine_collections.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import usst.dysrc.kaoyan.adapters.PostListRecyclerViewAdapter
import usst.dysrc.kaoyan.entities.Post
import usst.dysrc.kaoyan.utils.OKHTTPUtils
import usst.dysrc.kaoyan.utils.ServerUtil

class MineCollectionListActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine_collections)
        val applicationData:ApplicationData=application as ApplicationData
        mine_collections_recyclerView.layoutManager=LinearLayoutManager(this)
        doAsync {
            val response=OKHTTPUtils.getData(ServerUtil.SERVER_HOST_URL
                    +ServerUtil.SERVER_POST_SEARCH_COLLECTIONS_URL+'/'+applicationData.userId)
            val postList: List<Post> = JSON.parseArray(response.body()!!.string(), Post::class.java)
            uiThread {
                mine_collections_recyclerView.adapter = PostListRecyclerViewAdapter(it, postList)
            }
        }
    }
}