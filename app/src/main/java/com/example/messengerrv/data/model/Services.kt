package com.example.messengerrv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.messengerrv.R

data class Services(
    @DrawableRes val imageId: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    var isSelected: Boolean = false
)

val servicesList = listOf(
    Services(R.drawable.ic_add, R.string.subs, R.string.add_subs),
    Services(R.drawable.ic_heart, R.string.like, R.string.add_like),
    Services(R.drawable.ic_watch, R.string.view_count, R.string.add_viewers_count),
    Services(R.drawable.ic_comment, R.string.comment, R.string.add_comment),
    Services(R.drawable.ic_watch, R.string.view_min, R.string.add_viewers_min)
)
