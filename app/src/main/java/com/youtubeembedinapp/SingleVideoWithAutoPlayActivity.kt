package com.youtubeembedinapp

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.youtubeembedinapp.databinding.ActivitySingleVideoWithAutoPlayBinding

class SingleVideoWithAutoPlayActivity : YouTubeBaseActivity() {

    lateinit var binding: ActivitySingleVideoWithAutoPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingleVideoWithAutoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.youtubeViewSingleVideoAutoPlay.initialize(
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
                        player.loadVideo("o-ins1nvbDg") //replace 0 with milliseconds for delay in autoplay
                        player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                    }

                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {

                }

            })
    }
}
