package com.task.fileexhibitsloader

import android.content.Context
import com.google.gson.Gson
import com.task.model.entities.ExhibitList
import com.task.model.loader.ExhibitsLoader
import java.io.IOException
import java.io.InputStream

class ExhibitsLoaderImpl(private val context: Context) : ExhibitsLoader {
    override suspend fun getExhibitList() =
        loadJSONFromAsset()?.let {
            Gson().fromJson(it, ExhibitList::class.java).list
        } ?: emptyList()

    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val inputStream: InputStream = context.assets.open("data/challenge.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}