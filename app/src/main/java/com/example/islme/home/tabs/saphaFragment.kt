package com.example.islme.home.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islme.databinding.SaphaFragmentBinding

class saphaFragment : Fragment() {
    lateinit var viewBinding : SaphaFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = SaphaFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return viewBinding.root
    }
}