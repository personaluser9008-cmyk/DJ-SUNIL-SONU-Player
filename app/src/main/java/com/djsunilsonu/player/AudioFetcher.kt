package com.djsunilsonu.player

import android.content.Context
import android.net.Uri
import android.provider.MediaStore

data class AudioModel(
    val id: Long,
    val title: String,
    val artist: String,
    val uri: Uri,
    val duration: Int
)

fun fetchLocalMusic(context: Context): List<AudioModel> {
    val audioList = mutableListOf<AudioModel>()
    try {
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.DURATION
        )
        val selection = "${MediaStore.Audio.Media.IS_MUSIC} != 0"
        val cursor = context.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            projection,
            selection, null, "${MediaStore.Audio.Media.TITLE} ASC"
        )
        
        cursor?.use {
            // Get columns safely
            val idCol = it.getColumnIndex(MediaStore.Audio.Media._ID)
            val titleCol = it.getColumnIndex(MediaStore.Audio.Media.TITLE)
            val artistCol = it.getColumnIndex(MediaStore.Audio.Media.ARTIST)
            val durationCol = it.getColumnIndex(MediaStore.Audio.Media.DURATION)
            
            while (it.moveToNext()) {
                try {
                    val id = if (idCol != -1) it.getLong(idCol) else 0L
                    val title = if (titleCol != -1) it.getString(titleCol) ?: "Unknown" else "Unknown"
                    val artist = if (artistCol != -1) it.getString(artistCol) ?: "Unknown" else "Unknown"
                    val duration = if (durationCol != -1) it.getInt(durationCol) else 0
                    
                    val uri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id.toString())
                    audioList.add(AudioModel(id, title, artist, uri, duration))
                } catch (e: Exception) {
                    // Agar ek gaana kharab hai, toh crash mat karo, agle par jao
                }
            }
        }
    } catch (e: Exception) {
        // Agar storage scan fail ho jaye toh app band na ho
    }
    return audioList
}
