package com.example.test337.model

import androidx.annotation.StringRes
import com.example.test337.R

sealed class GiftWrap(val result: Boolean, @StringRes val TextId: Int){
    class SwitchWrap(result: Boolean, Text: Int):GiftWrap(result, Text){
       object True:GiftWrap(true, R.string.gift_warp_true)
        object False:GiftWrap(false, R.string.gift_warp_false)
    }
}

val giftWrap = listOf(GiftWrap.SwitchWrap.False, GiftWrap.SwitchWrap.True)
