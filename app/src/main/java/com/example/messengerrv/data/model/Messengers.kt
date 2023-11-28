package com.example.messengerrv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.messengerrv.R

data class Messengers(
    @DrawableRes val imageId: Int,
    @StringRes val messenger: Int,
)

val messengersList = listOf(
    Messengers(R.drawable.ic_youtube, R.string.youtube),
    Messengers(R.drawable.ic_telegram, R.string.telegram),
    Messengers(R.drawable.ic_instagram, R.string.instagram),
    Messengers(R.drawable.ic_facebook, R.string.facebook)
)

val messengersIsSelectedList = listOf(
    Messengers(R.drawable.ic_youtube_is_selected, R.string.youtube),
    Messengers(R.drawable.ic_telegram_is_selected, R.string.telegram),
    Messengers(R.drawable.ic_instagram_is_selected, R.string.instagram),
    Messengers(R.drawable.ic_facebook_is_selected, R.string.facebook)
)
