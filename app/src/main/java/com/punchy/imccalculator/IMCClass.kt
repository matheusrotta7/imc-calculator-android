package com.punchy.imccalculator

enum class IMCClass(private val upperLimit: Double, val portugueseText: String){
    UNDERWEIGHT(18.5, "Baixo"), NORMAL(24.9, "Normal"), OVERWEIGHT(29.9, "Sobrepeso"), OBESE(Double.MAX_VALUE, "Obesidade");

    companion object {
        fun givenValueReturnClassification(imcValue: Float): IMCClass {
            for (curClass in IMCClass.values()) {
                if (imcValue < curClass.upperLimit) {
                    return curClass
                }
            }
            return OBESE //code shouldn't get this far since OBESE's upperlimit is Double.MAX_VALUE
        }
    }
}