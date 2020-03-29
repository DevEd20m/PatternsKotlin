package com.deved.patternskotlin

import androidx.appcompat.app.AppCompatActivity

object OrderCommandProcesor {
    private val queue = HashMap<Int, OrderCommand>()
    private lateinit var activity: AppCompatActivity

    fun setFragmentManager(appCompatActivity: AppCompatActivity) {
        this.activity = appCompatActivity
    }

    fun initFragments() {
        queue[R.id.itemHome] = HomeCommand()
        queue[R.id.itemFavorites] = FavoriteCommand()
    }

    fun processFragment(menu: Int) = apply {
        if (queue.containsKey(menu)) {
            queue[menu]?.execute {
                activity.supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutMain, it)
                    addToBackStack(null)
                }.commit()
            }
        }
    }

    fun clearCommand() {
        queue.clear()
    }
}