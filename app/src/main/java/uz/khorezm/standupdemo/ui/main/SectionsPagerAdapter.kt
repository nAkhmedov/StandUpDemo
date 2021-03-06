package uz.khorezm.standupdemo.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.khorezm.standupdemo.R
import uz.khorezm.standupdemo.ui.databinding.DataBindingFragment
import uz.khorezm.standupdemo.ui.livedata.LiveDataFragment
import uz.khorezm.standupdemo.ui.rxjava.RxJavaFragment

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3,
        R.string.tab_text_4
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when(position) {
            0    -> ViewBindingFragment.newInstance()
            1    -> DataBindingFragment.newInstance()
            2    -> LiveDataFragment.newInstance()
            3    -> RxJavaFragment.newInstance()
            else -> ViewBindingFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}