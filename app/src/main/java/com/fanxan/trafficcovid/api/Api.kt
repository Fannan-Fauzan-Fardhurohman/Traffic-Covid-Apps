package com.fanxan.trafficcovid.api

import com.fanxan.trafficcovid.model.IndonesiaResponse
import com.fanxan.trafficcovid.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvinsi():Call<ArrayList<ProvinceResponse>>
}