package com.youtubeembedinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.youtubeembedinapp.databinding.ActivityMultipleVideoWithAutoPlayBinding

class MultipleVideoWithAutoPlayActivity : YouTubeBaseActivity() {

    val videoList = listOf("o-ins1nvbDg", "KUk6k865Vgg")

    lateinit var binding: ActivityMultipleVideoWithAutoPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultipleVideoWithAutoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.youtubeViewMultipleVideosAutoPlay.initialize("AIzaSyADXwxojM3_FtQkbvBdAt_b8mBcbcXsrBE",
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
                        player.loadVideos(videoList)
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
