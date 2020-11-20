package com.fanxan.trafficcovid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.fanxan.trafficcovid.adapter.ProvinceAdapter
import com.fanxan.trafficcovid.api.RetrofitClient
import com.fanxan.trafficcovid.model.ProvinceResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_province.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_province)

        showProvince()
    }

    private fun showProvince() {
//        TODO("Not yet implemented")
        rvProvince.setHasFixedSize(true)
        rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvinsi().enqueue(object :Callback<ArrayList<ProvinceResponse>>{
            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
//                TODO("Not yet implemented")
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<ProvinceResponse>>,
                response: Response<ArrayList<ProvinceResponse>>
            ) {
//                TODO("Not yet implemented")
                val list = response.body()
                val adapter = list?.let { ProvinceAdapter(it) }
                rvProvince.adapter = adapter
            }

        })
    }
}