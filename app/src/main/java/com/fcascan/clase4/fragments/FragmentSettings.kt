package com.fcascan.clase4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.fcascan.clase4.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FragmentSettings : Fragment() {
    lateinit var v : View
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_settings, container, false)
        tabLayout = v.findViewById(R.id.tabLayout)
        viewPager = v.findViewById(R.id.viewPager)
        return v
    }

    override fun onStart() {
        super.onStart()

        viewPager.adapter = ViewPagerAdapter(requireActivity())

        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when(position) {
                0 -> tab.text = "Tab 1"
                1 -> tab.text = "Tab 2"
                2 -> tab.text = "Tab 3"
                else -> tab.text = "undefined"
            }
        }).attach()
    }

    class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
        companion object {
            const val TAB_COUNT = 3
        }

        override fun getItemCount(): Int {
            return TAB_COUNT
        }

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> FragmentTab1()
                1 -> FragmentTab2()
                2 -> FragmentTab3()
                else -> FragmentTab1()
            }
        }
    }
}