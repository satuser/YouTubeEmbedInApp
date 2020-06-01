package com.youtubeembedinapp

import android.os.Bundle
import com.google.android.youtube.player.*
import com.youtubeembedinapp.databinding.ActivityMultipleVideoWithNoAutoPlayBinding

class MultipleVideoWithNoAutoPlayActivity : YouTubeBaseActivity() {

    val videoList = listOf("o-ins1nvbDg", "KUk6k865Vgg")

    lateinit var binding: ActivityMultipleVideoWithNoAutoPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleVideoWithNoAutoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.youtubeViewMultipleVideosNoAutoPlay.initialize(
            "AIzaSyADXwxojM3_FtQkbvBdAt_b8mBcbcXsrBE",
            object : YouTubePlayer.OnInitializedListener {

                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    player: YouTubePlayer?,
                    wasRestored: Boolean
                ) {
                    if (player == null) return
                    if (wasRestored)
                        player.play()
                    else {
                        player.cueVideos(videoList) //replace 0 with milliseconds for delay in autoplay
                        player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                    }
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {

                }
            }
        )
    }

}
