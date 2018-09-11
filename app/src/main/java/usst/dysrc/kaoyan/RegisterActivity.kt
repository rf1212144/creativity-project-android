package usst.dysrc.kaoyan

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.alibaba.fastjson.JSON
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import usst.dysrc.kaoyan.entities.User
import usst.dysrc.kaoyan.utils.OKHTTPUtils
import usst.dysrc.kaoyan.utils.ServerUtil

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerButton.setOnClickListener{ _ ->
            if (!register_confirm_password_editText.text.toString()
                            .equals(register_password_editText.text.toString(),false)) {
                Toast.makeText(this, "确认密码错误", Toast.LENGTH_SHORT).show()
            } else {
                val registerUser= User()
                registerUser.userName= register_userName_editText.text.toString()
                registerUser.password=register_password_editText.text.toString()
                registerUser.email=register_email_editText.text.toString()
                doAsync {
                    val registerResponse =
                            OKHTTPUtils
                                    .postData(ServerUtil.SERVER_HOST_URL+ServerUtil.SERVER_USER_REGISTER_URL,
                                            JSON.toJSONString(registerUser))
                    uiThread {
                        Toast.makeText(it,registerResponse.body()!!.string(),Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        transLoginButton.setOnClickListener {
            startActivity(Intent().setClass(this,LoginActivity::class.java))
        }
    }
}