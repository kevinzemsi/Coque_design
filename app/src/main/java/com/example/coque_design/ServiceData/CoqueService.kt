package com.example.coque_design.ServiceData

import android.util.Log
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URLEncoder

class CoqueService {
    companion object{
        private const val TAG ="CoqueService"
        fun searchImage(name:String, callback: CallbackSearchImage){
            Log.d(TAG,">>searchImage $name")

            val surl= "https://api.pexels.com/v1/search?query=nature" + URLEncoder.encode(name)
            Log.d(TAG,"surl $surl")

            val request: Request = Request.Builder()
                .url(surl)
                .build()
            val client = OkHttpClient()
            client.newCall(request).enqueue(callback)
            Log.d(TAG,"<<searchImage $name")

        }

    }
}

private fun Any.enqueue(responseCallback: CallbackSearchImage) {
    TODO("Not yet implemented")
}


