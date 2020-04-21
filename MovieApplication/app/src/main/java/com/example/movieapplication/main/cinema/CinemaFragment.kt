package com.example.movieapplication.main.cinema

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.movieapplication.R
import com.example.movieapplication.main.cinema.list.CinemaListFragment
import com.example.movieapplication.presentation.movie.cinema.adapters.ViewPagerAdapter
import com.example.movieapplication.main.cinema.map.CinemaMapFragment


import com.google.android.material.tabs.TabLayout


class CinemaFragment : Fragment() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.kinoteatr_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupViewPager()
    }

    private fun initViews(view: View) = with(view) {
        tabs = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.viewPager)
    }

    private fun setupViewPager() {
        val adapter = childFragmentManager.let { fragmentManager ->
            ViewPagerAdapter(
                fragmentManager
            )
        }
        val cinemaListFragment: CinemaListFragment = CinemaListFragment.newInstance()
        adapter.addFragment(cinemaListFragment, "Cinemas")
        val cinemaMapFragment: CinemaMapFragment = CinemaMapFragment.newInstance()
//        adapter.addFragment(cinemaMapFragment, "Map")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

}
