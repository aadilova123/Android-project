package com.example.movieapplication.base
import android.view.View
import androidx.fragment.app.Fragment

abstract class ParentFragment : Fragment() {
    protected abstract fun bindViews(view: View)

    protected abstract fun setData()
}