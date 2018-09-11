package usst.dysrc.kaoyan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.alibaba.fastjson.JSON
import kotlinx.android.synthetic.main.activity_create_new_post.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import usst.dysrc.kaoyan.entities.Post
import usst.dysrc.kaoyan.utils.OKHTTPUtils
import usst.dysrc.kaoyan.utils.ResultEnum
import usst.dysrc.kaoyan.utils.ServerUtil

class CreateNewPost: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_post)
        val applicationData=application as ApplicationData
        confirm_create_new_post_button.setOnClickListener { _ ->
            val newPost=Post()
            newPost.userId=applicationData.userId
            newPost.title=newPost_title_editView.text.toString()
            newPost.content=newPost_content_editView.text.toString()
            doAsync {
                val response=OKHTTPUtils.postData(
                        ServerUtil.SERVER_HOST_URL+ServerUtil.SERVER_POST_CREATE_POST_URL,
                        JSON.toJSONString(newPost))
                uiThread {
                    if (response.body()!!.string().equals(ResultEnum.CREATE_POST_FAILED.message,false))
                        Toast.makeText(it,ResultEnum.CREATE_POST_FAILED.message,Toast.LENGTH_SHORT).show()
                    else{
//                        Toast.makeText(it,ResultEnum.CREATE_POST_SUCCESS.message,Toast.LENGTH_SHORT).show()
                        startActivity(
                                Intent().putExtra("postId",JSON.parseObject(response.body()!!.string(),Long::class.java))
                                        .setClass(it,PostDetailActivity::class.java))
                    }
                }
            }
        }
    }
}