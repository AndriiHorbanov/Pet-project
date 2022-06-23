package com.example.test337.model

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.example.test337.R

sealed class VarietyWeed(val name:VarietyStringId, @IdRes val buttonId: Int) {
    sealed class ConeVariety(name: VarietyStringId, buttonId: Int) : VarietyWeed(name, buttonId) {
        object AmnesiaCone : ConeVariety(VarietyStringId.VarietyAmnesiaCone, R.id.third_amnesia)
        object BlackWidowCone : ConeVariety(VarietyStringId.VarietyBlackButterflyCone, R.id.third_black_widow)
        object SkunkCone : ConeVariety(VarietyStringId.VarietySkunkCone, R.id.third_skunk)
        object PabloEscobarCone : ConeVariety(VarietyStringId.VarietyPabloEscobarCone, R.id.third_pablo_escobar)
        object MontrealCone : ConeVariety(VarietyStringId.VarietyMontrealCone, R.id.third_montreal)
    }

    sealed class TherapeuticVariety(name: VarietyStringId, buttonId: Int) : VarietyWeed(name, buttonId) {
        object JuicyFruit : TherapeuticVariety(VarietyStringId.VarietyJuicyFruit, R.id.fifth_juicy_fruit)
        object AmnesiaHaze : TherapeuticVariety(VarietyStringId.VarietyAmnesiaHaze, R.id.fifth_amnesia_haze)
        object BubbleGun : TherapeuticVariety(VarietyStringId.VarietyBubbleGun, R.id.fifth_bubble_gum)
        object Strawberry : TherapeuticVariety(VarietyStringId.VarietyStrawberry, R.id.fifth_strawberry)
    }

    sealed class CigaretteVariety(name: VarietyStringId, buttonId: Int) : VarietyWeed(name, buttonId) {
        object AmnesiaCigarette : CigaretteVariety(VarietyStringId.VarietyAmnesiaCigarette, R.id.fourth_amnesia_spliff)
        object BlackWidowCigarette :
            CigaretteVariety(VarietyStringId.VarietyBlackButterflyCigarette, R.id.fourth_black_widow_spliff)

        object SkunkCigarette : CigaretteVariety(VarietyStringId.VarietySkunkCigarette, R.id.fourth_skunk_spliff)
        object PabloEscobarCigarette :
            CigaretteVariety(VarietyStringId.VarietyPabloEscobarCigarette, R.id.fourth_pablo_escobar_spliff)

        object MontrealCigarette : CigaretteVariety(VarietyStringId.VarietyMontrealCigarette, R.id.fourth_montreal_spliff)
    }
}

val coneVariety = listOf(
    VarietyWeed.ConeVariety.AmnesiaCone,
    VarietyWeed.ConeVariety.BlackWidowCone,
    VarietyWeed.ConeVariety.SkunkCone,
    VarietyWeed.ConeVariety.PabloEscobarCone,
    VarietyWeed.ConeVariety.MontrealCone
)

val therapeuticVariety = listOf(
    VarietyWeed.TherapeuticVariety.JuicyFruit,
    VarietyWeed.TherapeuticVariety.AmnesiaHaze,
    VarietyWeed.TherapeuticVariety.BubbleGun,
    VarietyWeed.TherapeuticVariety.Strawberry
)

val сigaretteVariety = listOf(
    VarietyWeed.CigaretteVariety.AmnesiaCigarette,
    VarietyWeed.CigaretteVariety.BlackWidowCigarette,
    VarietyWeed.CigaretteVariety.SkunkCigarette,
    VarietyWeed.CigaretteVariety.PabloEscobarCigarette,
    VarietyWeed.CigaretteVariety.MontrealCigarette
)

enum class VarietyStringId(@StringRes val TextId: Int, val price: Double) {
    VarietyAmnesiaCone(R.string.amnesia, 13.48),
    VarietyBlackButterflyCone(R.string.black_widow, 14.50),
    VarietySkunkCone(R.string.skunk, 14.00),
    VarietyPabloEscobarCone(R.string.pablo_escobar, 15.2),
    VarietyMontrealCone(R.string.montreal, 13.11),
    VarietyJuicyFruit(R.string.juicy_fruit, 12.59),
    VarietyAmnesiaHaze(R.string.amnesia_haze, 13.48),
    VarietyBubbleGun(R.string.bubble_gum, 14.56),
    VarietyStrawberry(R.string.strawberry, 13.54),
    VarietyAmnesiaCigarette(R.string.amnesia, 12.48),
    VarietyBlackButterflyCigarette(R.string.black_widow, 13.50),
    VarietySkunkCigarette(R.string.skunk, 13.00),
    VarietyPabloEscobarCigarette(R.string.pablo_escobar, 15.2),
    VarietyMontrealCigarette(R.string.montreal, 12.11)
}