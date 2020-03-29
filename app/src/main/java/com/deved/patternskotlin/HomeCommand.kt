package com.deved.patternskotlin

import androidx.fragment.app.Fragment
import com.deved.patternskotlin.fragments.HomeFragment

class HomeCommand :OrderCommand{
    override fun execute(changeFragment: (Fragment) -> Unit) {
        changeFragment(HomeFragment())
    }
}