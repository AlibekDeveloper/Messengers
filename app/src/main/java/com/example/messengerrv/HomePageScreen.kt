package com.example.messengerrv

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messengerrv.data.model.Messengers
import com.example.messengerrv.data.model.messengersIsSelectedList
import com.example.messengerrv.data.model.messengersList
import com.example.messengerrv.data.model.servicesList
import com.example.messengerrv.items.ServiceItem

@Composable
fun HomePageScreen() {
    var selectedMessenger by remember { mutableStateOf(messengersList.first()) }
    var hideServices by remember { mutableStateOf(false) }
    Column {
        MessengerTopAppBar()
        TitleAndDesc(
            stringResource(id = R.string.title),
            stringResource(id = R.string.description),
            modifier = Modifier.padding(
                top = 120.dp,
                bottom = 60.dp
            )
        )
        MessengersList(modifier = Modifier.padding(
            horizontal = dimensionResource(R.dimen.padding_start)
        ),
            onMessengerSelected = { messenger ->
                selectedMessenger = messenger
                hideServices = messenger != messengersList.first()
            })
        ServicesList(
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_start)),
            hideServices = hideServices
        )
        BottomNavigationScreen()
    }
}

@Composable
fun MessengersList(modifier: Modifier = Modifier, onMessengerSelected: (Messengers) -> Unit) {
    var selectedMessenger by remember { mutableStateOf(messengersList.first()) }

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = dimensionResource(id = R.dimen.padding_start)),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messengersList) { messenger ->
            val index = messengersList.indexOf(messenger)
            MessengerItem(
                messengers = messenger,
                isSelected = selectedMessenger == messenger,
                onItemClick = {
                    if (index < messengersList.size - 2) {
                        selectedMessenger = messenger
                        onMessengerSelected(messenger)
                    }
                }
            )
        }
    }
}


@Composable
fun ServicesList(modifier: Modifier = Modifier, hideServices: Boolean) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        LazyRow {
            items(servicesList) { service ->
                if (service == servicesList.first() || !hideServices) {
                    ServiceItem(services = service)
                }
            }
        }
    }
}


@Composable
fun MessengerTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_megalike),
            contentDescription = "MegaLike",
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_start), top = 24.dp, bottom = 24.dp
            )
        )
    }
}

@Composable
fun TitleAndDesc(title: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(R.dimen.padding_start))
    ) {
        Text(
            text = title, style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 40.sp,
                fontFamily = FontFamily(Font(R.font.semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF171717),
                textAlign = TextAlign.Center,
            ), modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )
        Text(
            text = description, style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.semibold)),
                fontWeight = FontWeight(300),
                color = Color(0xFF616161),
                textAlign = TextAlign.Center,
            ), modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 24.dp)
        )
    }
}

@Composable
fun MessengerItem(
    messengers: Messengers,
    isSelected: Boolean,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedList = if (isSelected) messengersIsSelectedList else messengersList
    val selectedMessenger = selectedList.first { it.messenger == messengers.messenger }

    Row(
        modifier = modifier
            .pointerInput(Unit) {
                if (selectedList.indexOf(selectedMessenger) < selectedList.size - 2) {
                    detectTapGestures { onItemClick() }
                }
            }
            .border(
                1.dp,
                if (isSelected) colorResource(id = R.color.border) else Color.Transparent,
                CircleShape
            )
            .padding(horizontal = 14.dp, vertical = 8.dp)
            .clip(CircleShape),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        MessengerImage(
            imageId = selectedMessenger.imageId,
        )
        Text(
            text = stringResource(id = selectedMessenger.messenger), style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )
        )
    }
}



@Composable
fun MessengerImage(
    @DrawableRes imageId: Int, modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.padding(end = 8.dp),
        painter = painterResource(id = imageId),
        contentDescription = null
    )
}
