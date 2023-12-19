package uz.frodo.viewpager.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import uz.frodo.viewpager.model.ComingResult

interface RetrofitService {

    @GET("search/photos")
    fun getPhotos(
        @Query("query") query: String,
        @Query("page") page:Int,
        @Query("per_page") pageLimit:Int,
        @Query("order_by") order:String="relevant",
        @Query("orientation") orientation:String="portrait"
    ):Call<ComingResult>

}