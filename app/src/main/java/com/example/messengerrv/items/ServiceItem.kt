package com.example.messengerrv.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messengerrv.R
import com.example.messengerrv.data.model.Services

@Composable
fun ServiceItem(
    services: Services,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(
                start = dimensionResource(id = R.dimen.padding_start),
                top = dimensionResource(id = R.dimen.padding_start)
            )
            .size(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(id = R.color.brown))
            .clickable {  }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(
                start = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            Image(
                painter = painterResource(id = services.imageId), contentDescription = null
            )

            Text(
                text = stringResource(id = services.title), style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.semibold)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF171717),
                )
            )
            Text(
                text = stringResource(id = services.description), style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.semibold)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF616161),
                )
            )
        }
    }
}

