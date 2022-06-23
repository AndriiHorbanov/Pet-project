package com.example.test337.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class OrderViewModel:ViewModel() {
    private val _productType = MutableLiveData<ProductType>()
    val productType: LiveData<ProductType> = _productType
    private val _varietyWeed = MutableLiveData<Int>()
    val varietyWeed: LiveData<Int> = _varietyWeed
    private val _weightWeed = MutableLiveData<Int>()
    val weightWeed: LiveData<Int> = _weightWeed
    private val _giftWrap = MutableLiveData<Int>()
    val giftWrap: LiveData<Int> = _giftWrap
    private  val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price
    private val _amount = MutableLiveData<Int>()
    val amount: LiveData<Int> = _amount



    fun setAmount(valueAmount:WeightStringId){
        _amount.value = valueAmount.price
    }

    fun setPrice(valuePrice:VarietyStringId){
        _price.value = valuePrice.price*amount.value!!
    }

    fun setType(productType:ProductType) {
        _productType.value = productType
    }

    fun setVariety(varietyStringVarietyResId:VarietyStringId){
        _varietyWeed.value=varietyStringVarietyResId.TextId
    }


    fun setWeight(WeightStringResId: WeightStringId){
        _weightWeed.value=WeightStringResId.TextId
    }


    fun setWarp(warpStringId: GiftWrap){
        _giftWrap.value=warpStringId.TextId
    }


}


