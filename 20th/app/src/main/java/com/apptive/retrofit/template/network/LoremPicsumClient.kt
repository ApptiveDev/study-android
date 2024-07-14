package com.apptive.retrofit.template.network

import retrofit2.Retrofit

const val BASE_URL = ""

object RetrofitClient {
    val service: LoremPicsumService = Retrofit.Builder()
        .baseUrl()

}