package com.example.rcviewsample.ui.retrofit_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rcviewsample.QuestApp
import com.example.rcviewsample.R


class RetfrofitFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_retfrofit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questListModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        questListModel.fetchQuestList((activity?.application as? QuestApp)?.questApi)
    }

    companion object {

        fun newInstance() =
            RetfrofitFragment()
    }
}