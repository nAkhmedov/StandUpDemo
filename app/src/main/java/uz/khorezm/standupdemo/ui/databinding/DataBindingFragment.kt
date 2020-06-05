package uz.khorezm.standupdemo.ui.databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.khorezm.standupdemo.databinding.FragmentDataBinding
import uz.khorezm.standupdemo.ui.base.BaseFragment

class DataBindingFragment : BaseFragment<DataBindingViewModel>() {
    companion object {
        @JvmStatic
        fun newInstance(): DataBindingFragment {
            return DataBindingFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDataBinding.inflate(inflater, container, false)
        binding.viewModel = mViewModel

        return binding.root
    }
}