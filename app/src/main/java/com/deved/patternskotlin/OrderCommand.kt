package com.deved.patternskotlin

import androidx.fragment.app.Fragment

interface OrderCommand {
    fun execute(changeFragment: (Fragment) -> Unit)
}