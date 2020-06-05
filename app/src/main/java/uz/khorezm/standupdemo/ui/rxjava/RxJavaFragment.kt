package uz.khorezm.standupdemo.ui.rxjava

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import uz.khorezm.standupdemo.databinding.FragmentRxJavaBinding
import uz.khorezm.standupdemo.ui.base.BaseFragment

class RxJavaFragment: BaseFragment<RxJavaViewModel>() {

    companion object {
        @JvmStatic
        fun newInstance(): RxJavaFragment {
            return RxJavaFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRxJavaBinding.inflate(inflater, container, false)
        binding.viewModel = mViewModel

        mViewModel.currentTimeData.observe(viewLifecycleOwner, Observer { time ->
            binding.timeTV.text = time
        })

        return binding.root
    }
}