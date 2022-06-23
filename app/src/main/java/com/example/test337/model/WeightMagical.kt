package com.example.test337.model

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.test337.R

sealed class WeightMagical(val name: WeightStringId, @IdRes val buttonId: Int) {
    sealed class ConeWeight(name: WeightStringId, buttonId: Int) : WeightMagical(name, buttonId) {
        object OneCone : ConeWeight(WeightStringId.WeightOneCone, R.id.third_weight_one)
        object TwoCone : ConeWeight(WeightStringId.WeightTwoCone, R.id.third_weight_two)
        object ThreeCone : ConeWeight(WeightStringId.WeightThreeCone, R.id.third_weight_three)
    }

    sealed class CigaretteQuantity(name: WeightStringId, buttonId: Int) : WeightMagical(name, buttonId) {
        object OneCigarette : CigaretteQuantity(WeightStringId.WeightOneCigarette, R.id.fourth_quantity_one)
        object TwoCigarette : CigaretteQuantity(WeightStringId.WeightTwoCigarette, R.id.fourth_quantity_two)
        object ThreeCigarette : CigaretteQuantity(WeightStringId.WeightThreeCigarette, R.id.fourth_quantity_three)
    }

    sealed class MedicalWeight(name: WeightStringId, buttonId: Int) : WeightMagical(name, buttonId) {
        object OneTherapeutic : MedicalWeight(WeightStringId.WeightOneTherapeutic, R.id.fifth_one)
        object TwoTherapeutic : MedicalWeight(WeightStringId.WeightTwoTherapeutic, R.id.fifth_two)
        object ThreeTherapeutic : MedicalWeight(WeightStringId.WeightThreeTherapeutic, R.id.fifth_three)
    }

}

val сoneWeight = listOf(
    WeightMagical.ConeWeight.OneCone,
    WeightMagical.ConeWeight.TwoCone,
    WeightMagical.ConeWeight.ThreeCone
)

val сigaretteWeight = listOf(
    WeightMagical.CigaretteQuantity.OneCigarette,
    WeightMagical.CigaretteQuantity.TwoCigarette,
    WeightMagical.CigaretteQuantity.ThreeCigarette
)

val medicalWeight = listOf(
        WeightMagical.MedicalWeight.OneTherapeutic,
        WeightMagical.MedicalWeight.TwoTherapeutic,
        WeightMagical.MedicalWeight.ThreeTherapeutic
)

enum class WeightStringId(@StringRes val TextId: Int, val price: Int) {
    WeightOneCone(R.string.third_weight_one, 1),
    WeightTwoCone(R.string.third_weight_two, 2),
    WeightThreeCone(R.string.third_weight_three, 3),
    WeightOneCigarette(R.string.one, 1),
    WeightTwoCigarette(R.string.two,2),
    WeightThreeCigarette(R.string.three,3),
    WeightOneTherapeutic(R.string.third_weight_one,1),
    WeightTwoTherapeutic(R.string.third_weight_two,2),
    WeightThreeTherapeutic(R.string.third_weight_three,3),
}