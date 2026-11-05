package com.djsunilsonu.player

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class MusicPlayerViewModel : ViewModel() {
    
    var player: ExoPlayer? = null
    var songList: List<AudioModel> = emptyList()

    fun initializePlayer(context: Context) {
        try {
            if (player == null) {
                player = ExoPlayer.Builder(context).build()
                songList = fetchLocalMusic(context)
                
                songList.forEach { song ->
                    try {
                        val mediaItem = MediaItem.fromUri(song.uri)
                        player?.addMediaItem(mediaItem)
                    } catch (e: Exception) {
                        // Ignore corrupt files
                    }
                }
                player?.prepare()
            }
        } catch (e: Exception) {
            // Player fail hone par crash na ho
        }
    }

    fun playSong() { try { player?.play() } catch(e: Exception){} }
    fun pauseSong() { try { player?.pause() } catch(e: Exception){} }
    
    fun nextSong() { 
        try { 
            player?.seekToNext()
            player?.play() 
        } catch(e: Exception){} 
    }
    
    fun previousSong() { 
        try { 
            player?.seekToPrevious()
            player?.play() 
        } catch(e: Exception){} 
    }

    override fun onCleared() {
        super.onCleared()
        try { player?.release() } catch(e: Exception){}
    }
}
