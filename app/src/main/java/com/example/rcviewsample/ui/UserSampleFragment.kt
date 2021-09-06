package com.example.rcviewsample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcviewsample.databinding.FragmentUserSampleBinding
import com.example.rcviewsample.model.User

class UserSampleFragment : Fragment() {

   private val adapter = UserAdapter()
    private  lateinit var binding : FragmentUserSampleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserSampleBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            adapter.setData(generateSampleData())
        }
        adapter.setHasStableIds(true)
        binding.rcView.adapter = adapter
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setData(generateSampleData())
    }

    private fun generateSampleData() : List<Pair<User, Boolean>> = listOf(Pair(User(name  = "User1", age = 13,active = true), false),
                                                            Pair(User(name  = "User1", age = 15,active = true), false),
                                                            Pair(User(name  = "User2", age = 25,active = true), false),
                                                            Pair(User(name  = "User2", age = 15, active = false), false),
                                                            Pair(User(name  = "User3", age = 17, active =  false), false),
                                                            Pair(User(name  = "User4", age = 32,active = true), false),
                                                            Pair(User(name  = "User5", age = 32,active = true), false),
                                                            Pair(User(name  = "User6", age = 43,active = false), false),
                                                            Pair(User(name  = "User7", age = 55,active = false), false),
    )

    companion object {

        fun newInstance() = UserSampleFragment()
    }
}