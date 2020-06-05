package uz.khorezm.standupdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import uz.khorezm.standupdemo.R
import uz.khorezm.standupdemo.databinding.FragmentViewBinding
import uz.khorezm.standupdemo.ui.base.BaseFragment

/**
 * A placeholder fragment containing a simple view.
 */
class ViewBindingFragment : BaseFragment<MainViewModel>() {

    companion object {
        @JvmStatic
        fun newInstance(): ViewBindingFragment {
            return ViewBindingFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewBinding.inflate(inflater, container, false)
        binding.sectionLabel.text = getString(R.string.view_binding_sample_text)

        return binding.root
    }
}