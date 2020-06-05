package uz.khorezm.standupdemo.ui.livedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import uz.khorezm.standupdemo.databinding.FragmentLiveDataBinding
import uz.khorezm.standupdemo.ui.base.BaseFragment

class LiveDataFragment : BaseFragment<LiveDataViewModel>() {

    companion object {
        @JvmStatic
        fun newInstance(): LiveDataFragment {
            return LiveDataFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLiveDataBinding.inflate(inflater, container, false)

        mViewModel.fishNames.observe(viewLifecycleOwner, Observer { fishName ->
            binding.fishNameTV.text = fishName
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel.start()
    }
}