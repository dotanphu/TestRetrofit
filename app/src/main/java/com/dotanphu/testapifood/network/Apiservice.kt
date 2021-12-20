package com.dotanphu.testapifood.network

import com.dotanphu.testapifood.model.CategoryRespone
import retrofit2.Call
import retrofit2.http.GET

interface Apiservice {
    @GET("categories.php/")
    fun getFoodVersion(): Call<CategoryRespone>
}