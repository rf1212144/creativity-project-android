package usst.dysrc.kaoyan.utils

import okhttp3.*

object OKHTTPUtils{
    private val OKHTTPCLIENT:OkHttpClient=OkHttpClient()
    private val OKHTTPJSON=MediaType.parse("application/json; charset=utf-8")

    fun postData(url:String,requestData:String):Response{
        val requestBody=RequestBody.create(OKHTTPJSON,requestData)
        val request=Request.Builder()
                .url(url)
                .post(requestBody)
                .build()
        return OKHTTPCLIENT.newCall(request).execute()
    }

    fun getData(url: String): Response = OKHTTPCLIENT.newCall(Request.Builder().url(url).build()).execute()

}