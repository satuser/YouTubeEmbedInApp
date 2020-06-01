package com.youtubeembedinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.*
import com.youtubeembedinapp.databinding.ActivitySingleVideoWithNoAutoPlayBinding

class SingleVideoWithNoAutoPlayActivity : YouTubeBaseActivity() {

    lateinit var binding: ActivitySingleVideoWithNoAutoPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleVideoWithNoAutoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.youtubeViewSingleVideoNoAutoPlay
            .initialize("DEVELOPER_API_KEY",
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
                            player.cueVideo("o-ins1nvbDg")
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
