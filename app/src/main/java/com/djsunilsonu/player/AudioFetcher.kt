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
        val idCol = it.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
        val titleCol = it.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
        val artistCol = it.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
        val durationCol = it.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)
        while (it.moveToNext()) {
            val id = it.getLong(idCol)
            val title = it.getString(titleCol)
            val artist = it.getString(artistCol)
            val duration = it.getInt(durationCol)
            val uri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id.toString())
            audioList.add(AudioModel(id, title, artist, uri, duration))
        }
    }
    return audioList
}
