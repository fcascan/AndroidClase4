package com.fcascan.clase4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fcascan.clase4.R

class SplashFragment : Fragment() {
    private lateinit var v: View
    private lateinit var imgSplash: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_splash, container, false)
        imgSplash = v.findViewById(R.id.imgSplash)
        return v
    }

    override fun onStart() {
        super.onStart()

        Glide.with(this)
            .load("https://avatars.githubusercontent.com/u/64813436?v=4")
            .circleCrop()
            .into(imgSplash)
    }

}