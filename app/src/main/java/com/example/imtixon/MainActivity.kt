package com.example.imtixon

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Browser
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import com.example.imtixon.Models.Adapter
import com.example.imtixon.databinding.ActivityMainBinding
import com.example.imtixon.utils.MyData

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var urlEditText: EditText
    private lateinit var openButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sp1.adapter = Adapter(MyData.list)

        binding.sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val i = binding.sp1.selectedItemPosition
                i + 1
                if (i == 1) {
                    binding.lvAnimation.setAnimationFromUrl("https://assets8.lottiefiles.com/packages/lf20_06pnxqia.json")
                    binding.lvAnimation.playAnimation()
                } else {
                    binding.lvAnimation.setAnimationFromUrl("https://assets4.lottiefiles.com/packages/lf20_xsicerbj.json")
                    binding.lvAnimation.playAnimation()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        binding.btn1.setOnClickListener {
            val i = binding.sp1.selectedItemPosition
            if (i == 0) {

                var websiteUrl = binding.edtWeb.text.toString()

                if (websiteUrl.isNotEmpty()) {
                    if (!websiteUrl.startsWith("https://") && !websiteUrl.startsWith("https://")) {
                        websiteUrl = "https://$websiteUrl"
                    }
                }

                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(websiteUrl)
                startActivity(intent)
            }else{
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("url", binding.edtWeb.text.toString())
                startActivity(intent)
            }

        }
    }
}