package com.deved.patternskotlin

import androidx.fragment.app.Fragment
import com.deved.patternskotlin.fragments.FavoritFragment

class FavoriteCommand:OrderCommand {
    override fun execute(changeFragment: (Fragment) -> Unit) {
        changeFragment(FavoritFragment())
    }
}