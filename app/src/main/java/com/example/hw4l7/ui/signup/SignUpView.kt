package com.example.hw4l7.ui.signup

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface SignUpView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun checkForm()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showSignUpError()

    @StateStrategyType(SkipStrategy::class)
    fun finishSignUp()
}