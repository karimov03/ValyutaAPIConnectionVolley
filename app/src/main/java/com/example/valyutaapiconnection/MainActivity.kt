package com.example.valyutaapiconnection

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.valyutaapiconnection.Adapters.RvAdapter
import com.example.valyutaapiconnection.databinding.ActivityMainBinding
import com.example.valyutaapiconnection.models.Valyuta
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.reflect.TypeToken
import java.net.URL
import java.util.Queue

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val url = URL("http://cbu.uz/uzc/arkhiv-kursov-valyut/json/")

        val sorov: RequestQueue = Volley.newRequestQueue(this)

        var ArrayList = ArrayList<Valyuta>()

        val stringRequest = StringRequest(Method.GET, url.toString(),
            { response ->
                val gson = Gson()
                ArrayList = (gson.fromJson(response, object : TypeToken<ArrayList<Valyuta>>() {}))
                adapter=RvAdapter(ArrayList)
                binding.rv.adapter=adapter
            },
            { error ->
                Toast.makeText(this, "No Internet", Toast.LENGTH_SHORT).show()
            }
        )
        sorov.add(stringRequest)

    }
}

