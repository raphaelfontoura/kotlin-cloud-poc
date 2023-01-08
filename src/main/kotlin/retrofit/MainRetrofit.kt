package retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

fun main(args: Array<String>) {
    fun buildRetrofit() = Retrofit.Builder()
        .baseUrl("http://ec2-18-215-156-13.compute-1.amazonaws.com:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun carHttpService(): CarService = buildRetrofit().create(CarService::class.java)

    val car = carHttpService().getByModel("gol")

    println(car.execute().body())
}

interface CarService {
    @GET("cars-inventory")
    fun getByModel(@Query("model") model: String): Call<List<Car>>
}

data class Car(
    val make: String,
    val model: String,
    val year: Long
)



