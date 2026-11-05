package com.djsunilsonu.player

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class MusicPlayerViewModel : ViewModel() {
    
    var player: ExoPlayer? = null
    var songList: List<AudioModel> = emptyList()

    // Player ko start karna aur gaane scan karna
    fun initializePlayer(context: Context) {
        if (player == null) {
            player = ExoPlayer.Builder(context).build()
            songList = fetchLocalMusic(context)
            
            // Saare gaane playlist mein add karna
            songList.forEach { song ->
                val mediaItem = MediaItem.fromUri(song.uri)
                player?.addMediaItem(mediaItem)
            }
            player?.prepare()
        }
    }

    fun playSong() {
        player?.play()
    }

    fun pauseSong() {
        player?.pause()
    }
    
    fun nextSong() {
        player?.seekToNext()
        player?.play()
    }
    
    fun previousSong() {
        player?.seekToPrevious()
        player?.play()
    }

    override fun onCleared() {
        super.onCleared()
        player?.release()
    }
}
