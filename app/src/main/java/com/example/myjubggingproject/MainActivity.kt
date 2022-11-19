package com.example.myjubggingproject
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myjubggingproject.databinding.ActivityMainBinding
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



class MainActivity : AppCompatActivity() {

    companion object{
        var BaseUrl = "http://api.openweathermap.org/" // 주소
        var AppId = "9c6aa2d9071c3490f722cb006f3ca706" // api key
        var lat = "37.445293"
        var lon = "126.785823"
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //그릴 xml 뷰 파일을 연결 시켜준다.

        // intent main -> flogging
        binding.btnFloging.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }


        // 기록 이미지 -> recordActivity
        binding.btnTimeImg.setOnClickListener {
            val intent = Intent(this, RecordPageActivity::class.java)
            startActivity(intent)
        }





        // 날씨 구현

        //Create Retrofit Builder
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(WeatherService::class.java)
        val call = service.getCurrentWeatherData(lat, lon, AppId)
        call.enqueue(object : Callback<WeatherResponse> {
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("MainActivity", "result :" + t.message)
            }

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if(response.code() == 200){
                    val weatherResponse = response.body()
                    Log.d("MainActivity", "result: " + weatherResponse.toString())

                    val name = weatherResponse!!.sys!!.name
                    var icon = weatherResponse!!.weather!!.get(0).icon
                    binding.tvName.text = name

                    val country = weatherResponse!!.sys!!.country
                    binding.tvCountry.text = country

                    var mainWeather = weatherResponse!!.weather!!.get(0).main
                    binding.tvMain.text = mainWeather


                    var subWeather = weatherResponse!!.weather!!.get(0).description
                    binding.tvDescription.text = subWeather

                    var temp = weatherResponse!!.main!!.temp - 273.15
                    binding.tvTemp.text = String.format("%.1f °C", temp)


                    Glide.with(this@MainActivity)
                        .load(
                            resources.getDrawable(
                                resources.getIdentifier(
                                    "icon_" + icon,
                                    "drawable",
                                    packageName
                                )
                            )
                        )
                        .placeholder(R.drawable.weather)
                        .error(R.drawable.weather)
                        .fallback(R.drawable.weather)
                        .into(binding.ivWeather)

                }
            }
        })
    }
}
interface WeatherService{

    @GET("data/2.5/weather")
    fun getCurrentWeatherData(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String) :
            Call<WeatherResponse>
}

class WeatherResponse(){
    @SerializedName("weather") var weather = ArrayList<Weather>()
    @SerializedName("main") var main: Main? = null
    @SerializedName("sys") var sys: Sys? = null
}

class Weather {
    @SerializedName("id") var id: Int = 0
    @SerializedName("main") var main : String? = null // 날씨
    @SerializedName("description") var description: String? = null // 상세정보
    @SerializedName("icon") var icon : String? = null // 날씨 아이콘
}

class Main {
    @SerializedName("temp")
    var temp: Float = 0.toFloat()
}

class Sys {
    @SerializedName("country")
    var country: String? = null

    @SerializedName("name") // 도시이름
    var name: String? = null

}









