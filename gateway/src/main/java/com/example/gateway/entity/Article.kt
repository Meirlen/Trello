package com.shopapp.gateway.entity

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Article(var id: String,
                   var title: String,
                   var content: String,
                   var contentHTML: String,

                   var tags: List<String>,
                   var blogId: String,
                   var blogTitle: String,
                   var publishedAt: Date,
                   var url: String,
                   var paginationValue: String? = null) : Parcelable {

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),

        source.createStringArrayList(),
        source.readString(),
        source.readString(),
        source.readSerializable() as Date,
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(id)
        writeString(title)
        writeString(content)
        writeString(contentHTML)

        writeStringList(tags)
        writeString(blogId)
        writeString(blogTitle)
        writeSerializable(publishedAt)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article = Article(source)
            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)
        }
    }
}

