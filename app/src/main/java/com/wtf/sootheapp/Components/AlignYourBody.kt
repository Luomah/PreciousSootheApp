package com.wtf.sootheapp.Components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wtf.sootheapp.alignYourBodyData


@Composable
fun AlignYourBody(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier

){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .paddingFromBaseline(top = 20.dp)
    ){
        Image(painter = painterResource(
            drawable),
            contentDescription ="null",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
//                .paddingFromBaseline(top = 18.dp, bottom = 6.dp)
        )

        Text(text = stringResource(text),
            modifier = Modifier
                .paddingFromBaseline(top = 22.dp, bottom = 6.dp),
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier
){
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        //contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(alignYourBodyData) {
                item ->
            AlignYourBody(item.drawable, item.text)
        }
    }
}

@Composable
fun AlignYourBodySection(@StringRes title: Int,
                         modifier: Modifier = Modifier,
                         content: @Composable () -> Unit
){
    Column(modifier){
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium
        )
        content()
    }
}