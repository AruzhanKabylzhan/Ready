package kz.rdd.busket.data.network

import kz.rdd.busket.data.model.BusketListDto
import kz.rdd.busket.data.model.BusketProductsDto
import kz.rdd.core.utils.outcome.Outcome
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BusketApi {
    @GET("basket/list/")
    suspend fun getBusketPending(
        @Query("status") status: Int = 1,
    ) : Outcome<List<BusketListDto>>

    @GET("basket/{id}/products-list/")
    suspend fun getBusketProducts(
        @Path("id") id: Int,
    ) : Outcome<List<BusketProductsDto>>

    @DELETE("basket/{id}/food-remove/")
    suspend fun removeFood(
        @Path("id") id: Int,
    ) : Outcome<Unit>

    @PATCH("basket/{id}/change-status/")
    suspend fun changeStatus(
        @Path("id") id: Int,
        @Body request: RequestBody,
    ) : Outcome<Unit>

    @POST("basket/food-add/")
    suspend fun foodAdd(
        @Body profile: RequestBody
    ) : Outcome<Unit>
}