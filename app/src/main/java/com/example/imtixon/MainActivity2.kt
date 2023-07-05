package com.example.imtixon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import com.example.imtixon.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

            var aa = intent.getStringExtra("url")

            var websiteUrl = aa.toString()

            if (websiteUrl.isNotEmpty()) {
                if (!websiteUrl.startsWith("https://") && !websiteUrl.startsWith("https://")) {
                    websiteUrl = "https://$websiteUrl"
                }
            }
            binding.apply {
                webView.settings.javaScriptEnabled = true
                webView.loadUrl(websiteUrl)
                webView.webViewClient = object : WebViewClient(){
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        view?.loadUrl(websiteUrl)
                        return true
                    }
                }
                webView.loadUrl(websiteUrl)
            }
    }
}