package com.example.messengerrv.subscribers

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.messengerrv.R
import com.example.messengerrv.subscribers.components.Spinner
import com.example.messengerrv.subscribers.components.SpinnerProperties
import com.example.messengerrv.ui.theme.black
import com.example.messengerrv.ui.theme.blue
import com.example.messengerrv.ui.theme.gray
import com.example.messengerrv.ui.theme.spinner
import com.example.messengerrv.ui.theme.white1

@Composable
fun Subscribers() {
    Column(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.padding_start))
            .verticalScroll(rememberScrollState())
    ) {
        TopBar()
        TitleAndDescPage()
        ServiceType()
        MessengersLink()
        HowManySubscribersToAdd()
        Total()

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = blue,
            )
        ) {
            Text(
                text = "Savatga qo‘shish",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFFFFFFFF)
                )
            )
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.height(72.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back",
            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_start))
        )
        Text(
            text = stringResource(id = R.string.subs),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(500),
                color = Color(0xFF171717),
            )
        )
    }
}

@Composable
fun TitleAndDescPage(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(top = 30.dp)) {
        Text(
            text = stringResource(id = R.string.order_info),
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 30.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(500),
                color = Color(0xFF171717)
            )
        )

        Text(
            text = stringResource(id = R.string.order_info_fill),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight(300),
                color = Color(0xFF616161)
            ),
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}

@Composable
fun ServiceType(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_start),
                    vertical = dimensionResource(id = R.dimen.padding_start)
                )
        ) {
            Text(
                text = stringResource(id = R.string.service_type_title),
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF171717),
                )
            )
            Text(
                text = stringResource(id = R.string.service_type_description),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF616161),
                ),
                modifier = Modifier.padding(top = 12.dp)
            )
            val (selectedItem0, setSelectedItem0) = remember { mutableStateOf("YouTube") }
            Spinner<String>(
                text = selectedItem0,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(spinner)
                    .align(Alignment.CenterHorizontally),
                itemListRes = R.array.list_spinner,
                properties = SpinnerProperties(
                    color = black,
                    textAlign = TextAlign.Start,
                    itemHeight = 50.dp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    spinnerPadding = 16.dp,
                    spinnerBackgroundColor = gray
                ),
                onSpinnerItemSelected = { _, item ->
                    setSelectedItem0(item)
                }
            )
            val serviceList = remember {
                listOf(
                    "Obunachilar yig‘ish",
                    "Layk",
                    "Koment",
                    "Ko‘rishlar soni",
                    "Ko‘rilish daqiqasi"
                )
            }
            val (selectedItem1, setSelectedItem1) = remember { mutableStateOf(serviceList[0]) }
            Spinner(
                text = selectedItem1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(spinner)
                    .align(Alignment.CenterHorizontally),
                itemList = serviceList,
                properties = SpinnerProperties(
                    color = black,
                    textAlign = TextAlign.Start,
                    itemHeight = 50.dp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    spinnerPadding = 16.dp,
                    spinnerBackgroundColor = gray
                ),
                onSpinnerItemSelected = { _, item ->
                    setSelectedItem1(item)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessengersLink(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.padding_start))
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_start),
                    vertical = dimensionResource(id = R.dimen.padding_start)
                )
        ) {
            Text(
                text = "Ijtimoiy tarmoq havolasi",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF171717)
                )
            )
            Text(
                text = "O‘z ijtimoiy tarmoq havolangizni yuklang",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF616161)
                ),
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "Indentifikator",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF171717)
                ),
                modifier = Modifier.padding(top = 24.dp)
            )
            var text by remember { mutableStateOf("") }
            TextField(
                value = text,
                onValueChange = { newText -> text = newText },
                placeholder = {
                    Text(
                        text = "Youtube kanal indentifikator",
                        color = colorResource(id = R.color.black61)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .clip(RoundedCornerShape(8.dp)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = colorResource(id = R.color.white2)
                )
            )
            Text(
                text = "Youtube kanal indentifikatorini olish bo‘yicha",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF616161),
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
            val handler = LocalUriHandler.current
            Text(
                text = "video dars",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(300),
                    color = blue,
                ),
                modifier = Modifier
                    .clickable {
                        handler.openUri("https://youtu.be/3mrKjzrIiq4?si=n9D1iUoi0Xj6BDK3")
                    }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HowManySubscribersToAdd(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_start),
                    vertical = dimensionResource(id = R.dimen.padding_start)
                )
        ) {
            Text(
                text = "Qancha obunachi qo‘shish kerak",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF171717),
                )
            )
            Text(
                text = "Qancha obunachi qo‘shish kerak va har biriga qancha pul bermoqchisiz",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF616161)
                ),
                modifier = Modifier.padding(top = 12.dp)
            )
            Text(
                text = "Obunachilar soni",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF171717)
                ),
                modifier = Modifier.padding(top = 24.dp)
            )
            var subsCount by remember { mutableStateOf("") }
            TextField(
                value = subsCount,
                onValueChange = { newText -> subsCount = newText },
                placeholder = {
                    Text(
                        text = "5000",
                        color = colorResource(id = R.color.black61)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .clip(RoundedCornerShape(8.dp)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.textFieldColors(
                    disabledIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = colorResource(id = R.color.white2)
                )
            )
            Text(
                text = "Obunachiga to‘lov",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF171717)
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
            var payment by remember { mutableStateOf("") }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color = colorResource(id = R.color.white2)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var byHints by remember { mutableStateOf("So'm") }

                TextField(
                    value = payment,
                    onValueChange = { newText -> payment = newText },
                    placeholder = {
                        Text(
                            text = "500",
                            color = colorResource(id = R.color.black61)
                        )
                    },
                    modifier = Modifier
                        .weight(1f),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        disabledIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        containerColor = colorResource(id = R.color.white2)
                    )
                )

                Text(
                    text = byHints,
                    modifier = Modifier.padding(end = 16.dp),
                    color = colorResource(id = R.color.black61)
                )
            }
        }
    }
}

@Composable
fun Total(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(size = 8.dp)
            )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_medium)
                    )
            ) {
                Text(
                    text = "Obunachilar soni:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(300),
                        color = Color(0xFF616161)
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "5 000",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF171717),
                        textAlign = TextAlign.Right,
                    ),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            Canvas(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            ) {

                drawLine(
                    color = white1,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    pathEffect = pathEffect
                )
            }

            Row(
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(id = R.dimen.padding_medium),
                        vertical = dimensionResource(id = R.dimen.padding_medium)
                    )
            ) {
                Text(
                    text = "Obunachiga to‘lov:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(300),
                        color = Color(0xFF616161)
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "500 UZS",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF171717),
                        textAlign = TextAlign.Right
                    )
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFFE0E0E0),
                        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.padding_medium),
                            vertical = dimensionResource(id = R.dimen.padding_medium)
                        )
                ) {
                    Text(
                        text = "Jami:",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(300),
                            color = Color(0xFF616161),
                        ),
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "2 500 000 UZS",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF171717),
                            textAlign = TextAlign.Right
                        )
                    )
                }
            }
        }
    }
}
