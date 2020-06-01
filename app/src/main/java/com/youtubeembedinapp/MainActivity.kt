package com.youtubeembedinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.youtubeembedinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSingleLinkNoAutoPlay.setOnClickListener(this)
        binding.buttonMultipleLinkNoAutoPlay.setOnClickListener(this)
        binding.buttonSingleLinkAutoPlay.setOnClickListener(this)
        binding.buttonMultipleLinkAutoPlay.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            binding.buttonSingleLinkNoAutoPlay.id -> startActivity(
                Intent(
                    this,
                    SingleVideoWithNoAutoPlayActivity::class.java
                )
            )

            binding.buttonMultipleLinkNoAutoPlay.id -> startActivity(
                Intent(
                    this,
                    MultipleVideoWithNoAutoPlayActivity::class.java
                )
            )

            binding.buttonSingleLinkAutoPlay.id -> startActivity(
                Intent(
                    this,
                    SingleVideoWithAutoPlayActivity::class.java
                )
            )

            binding.buttonMultipleLinkAutoPlay.id -> startActivity(
                Intent(
                    this,
                    MultipleVideoWithAutoPlayActivity::class.java
                )
            )

            else -> {
            }
        }
    }
}
