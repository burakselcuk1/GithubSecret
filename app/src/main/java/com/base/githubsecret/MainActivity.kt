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
import com.base.githubsecret.BuildConfig

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById<Button>(R.id.button)
        val baseUrlTextView: TextView = findViewById<TextView>(R.id.basee)

        button.setOnClickListener {
            baseUrlTextView.text = getString(R.string.CLIENT_ID)
        }
    }

}
