package com.example.islme.home.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islme.databinding.RadioFragmentBinding

class radioFragment : Fragment(){
    lateinit var viewBinding : RadioFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = RadioFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }


}