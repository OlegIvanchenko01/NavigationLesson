package com.example.data.models

data class DayModel (
    val maxtempC : Double? = null,
    val mintempC : Double? = null,
    val condition : ConditionModel,
){
    companion object{
        fun empty() = DayModel(
            15.5,
            9.6,
            ConditionModel.empty()
        )
    }
}