package com.fanxan.trafficcovid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fanxan.trafficcovid.api.RetrofitClient
import com.fanxan.trafficcovid.model.IndonesiaResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showIndonesia()
        btnProvince.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, ProvinceActivity::class.java)
            startActivity(moveIntent)
        }
    }

    private fun showIndonesia() {
//        TODO("Not yet implemented")
        RetrofitClient.instance.getIndonesia().enqueue(object :Callback<ArrayList<IndonesiaResponse>>{
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
//                TODO("Not yet implemented")
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ArrayList<IndonesiaResponse>>, response: Response<ArrayList<IndonesiaResponse>>) {
//                TODO("Not yet implemented")
                val indonesia = response.body()?.get(0);
                val positive = indonesia?.positif
                val hospitilized = indonesia?.dirawat
                val recover = indonesia?.sembuh
                val death = indonesia?.meninggal

                tvPositive.text = positive
                tvHospitalized.text = hospitilized
                tvRecover.text = recover
                tvDeath.text = death
            }

        })
    }
}