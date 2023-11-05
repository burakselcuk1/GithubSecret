package com.base.githubsecret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var BASE_URL = "Buraya Github Actions ile alınan BASE_URL gelecek"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var baseUrlTextView:TextView = findViewById<TextView>(R.id.basee)

        // GitHub Actions tarafından oluşturulan dosyayı okuyun
        try {
            val file = File(filesDir, "base_url.txt")
            val bufferedReader = BufferedReader(FileReader(file))
            val stringBuilder = StringBuilder()
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                stringBuilder.append(line)
            }
            BASE_URL = stringBuilder.toString()
            bufferedReader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        baseUrlTextView.text = BASE_URL
    }
}
