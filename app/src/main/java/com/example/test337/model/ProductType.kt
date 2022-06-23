package com.example.test337.model

import androidx.annotation.StringRes
import com.example.test337.R

sealed class ProductType(@StringRes val name: Int, val number: Int) {
    object Cigarette : ProductType(R.string.radiobuttonChoiceWeed3, number = 2)
    object Cone : ProductType(R.string.radiobuttonChoiceWeed, number = 0)
    object Therapeutic : ProductType(R.string.radiobuttonChoiceWeed2, number = 1)
}

