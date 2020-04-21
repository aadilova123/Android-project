package com.example.movieapplication.presentation.movie.cinema.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movieapplication.main.cinema.list.CinemaListFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    private val fragmentList: ArrayList<Fragment> = arrayListOf()
    private val fragmentListTitle: ArrayList<String> = arrayListOf()

    fun addFragment(fragment: CinemaListFragment, title: String) {
        fragmentList.add(fragment)
        fragmentListTitle.add(title)
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = fragmentListTitle[position]

}

