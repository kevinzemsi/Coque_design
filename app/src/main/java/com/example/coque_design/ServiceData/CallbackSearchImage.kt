package com.example.coque_design.ServiceData

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException


abstract class CallbackSearchImage : javax.security.auth.callback.Callback {
    companion object{
        private const val TAG = "CallSearchImage"
    }
    abstract  fun fireOnResponseOk(data:DataSearchImage)

    fun onFailure(call:Call, e: IOException) {
        TODO("Not yet implemented")
        Log.d(TAG,">>onFailure",e)
    }

    fun onResponse(call: Call, response: Response) {
        TODO("Not yet implemented")
        Log.d(TAG,">>onResponse")

        val responseData=response.body!!.string()
        Log.d(TAG,">>onResponse: $response")

        val gson = Gson();
        val data:DataSearchImage = gson.fromJson(responseData,
            DataSearchImage::class.java)

        runUiThread(Runnable{fireOnResponseOk(data)})
    }


    private fun runUiThread(runnable: Runnable){
        Handler(Looper.getMainLooper())
    }

}
