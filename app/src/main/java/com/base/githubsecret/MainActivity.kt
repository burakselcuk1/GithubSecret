package com.base.githubsecret

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private var BASE_URL = "Buraya Github Actions ile alınan BASE_URL gelecek"
    private var runId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.button)
        val baseUrlTextView: TextView = findViewById<TextView>(R.id.basee)

        button.setOnClickListener {
            // Arka plan iş parçacığında ağ isteği yap
            GlobalScope.launch(Dispatchers.IO) {
                // "run_id" değerini al
                runId = getRunId()
                val base_url = getBaseUrl()
                runOnUiThread {
                    baseUrlTextView.text = base_url
                }
            }
        }
    }

    private fun getBaseUrl(): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/repos/burakselcuk1/GithubSecret/actions/artifacts/runs/$runId/artifacts/base_url")
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                return response.body()?.string() ?: "Buraya Github Actions ile alınan BASE_URL gelecek"
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return "Ağ isteği başarısız oldu."
    }

    private fun getRunId(): String? {
        // "github.run_id" değerini döndürerek "run_id" değerini alabilirsiniz
        return "github.run_id" // Gerçek değeri bu şekilde almalısınız
    }
}

