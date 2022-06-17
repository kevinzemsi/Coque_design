package com.example.coque_design

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coque_design.ServiceData.CallbackSearchImage
import com.example.coque_design.ServiceData.CoqueService
import com.example.coque_design.ServiceData.DataSearchImage
import com.example.coque_design.UI.Image_adaptateur
import com.example.coque_design.databinding.FragmentImageBinding

class ImageFragment : Fragment() {
    private var _binding: FragmentImageBinding? = null
    companion object {
        var fragmentContext: Context?=null!!}

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentImageBinding.inflate(inflater, container, false)
        fragmentContext = this.requireContext();
        val image:String? = arguments?.getString("image")
        val thisFragment = this
        if(image != null){
            CoqueService.searchImage(image,object:CallbackSearchImage(){
                override fun fireOnResponseOk(data: DataSearchImage) {
                    _binding!!.pageImage.layoutManager = LinearLayoutManager(thisFragment.context)
                    _binding!!.pageImage.adapter = Image_adaptateur(data.data,thisFragment)
                }
            })

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}