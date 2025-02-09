package com.example.islme.home.sapha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islme.R
import com.example.islme.databinding.SaphaFragmentBinding

class SaphaFragment : Fragment() {
    lateinit var viewBinding : SaphaFragmentBinding
    lateinit var azkarList: MutableList<String>
    private var currentIndex = 0
    private var counter=0

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azKarList).toMutableList()
        initView()
        onSaphaClick()
    }
    fun initView(){
        viewBinding.tvtasbeeh.text = azkarList[currentIndex]
        viewBinding.tvCounter.text = "$counter"
    }
    fun onSaphaClick(){
        viewBinding.imvSaphaBody.setOnClickListener {
            viewBinding.imvSaphaBody.rotation += (360/33).toFloat()

            if (counter <33){
                counter++
            }else{
                counter = 0
                val lastIndex = azkarList.size-1
                currentIndex = if (currentIndex<lastIndex) ++currentIndex  else 0
                viewBinding.tvtasbeeh.text = azkarList[currentIndex]
            }
            viewBinding.tvCounter.text = "$counter"
        }
    }
}