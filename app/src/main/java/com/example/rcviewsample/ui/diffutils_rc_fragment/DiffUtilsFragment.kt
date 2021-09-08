package com.example.rcviewsample.ui.diffutils_rc_fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcviewsample.ImageActivity
import com.example.rcviewsample.databinding.FragmentDiffUtilsBinding
import com.example.rcviewsample.model.TweetMapper
import com.example.rcviewsample.model.Twitter

class DiffUtilsFragment : Fragment() {
    lateinit var binding: FragmentDiffUtilsBinding
    private val mAdapter = TwitterAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter.attachDelegate(object : TwitterDelegate {
            override fun openProfile(profile: String) {
                navigateProfileActivity(profile)
            }

            override fun openImage(url: String) {
                navigateImageActivity(url)
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiffUtilsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = mAdapter

        pupulateData()

        Handler().postDelayed({
            Toast.makeText(requireContext(), "DATA IS GET", Toast.LENGTH_SHORT).show()
            val tweets = Twitter.generateTweets().map { TweetMapper().mapApiToUi(it) }
            val utils = TwitterDiffUtils(mAdapter.mDataList, tweets)
            val diffResult = DiffUtil.calculateDiff(utils)
            mAdapter.setData(tweets)
            diffResult.dispatchUpdatesTo(mAdapter)
        }, 9000)
    }

    fun navigateProfileActivity(twitterName: String) {
        val intent = Intent(requireContext(), ProfileActivity::class.java)
        intent.putExtra("UserName", twitterName)
        startActivity(intent)
    }

    fun navigateImageActivity(url: String) {
        val intent = Intent(requireContext(), ImageActivity::class.java)
        intent.putExtra("Url", url)
        startActivity(intent)
    }

    private fun pupulateData() {
        val tweets = Twitter.generateTweets()
        mAdapter.setData(tweets.map { TweetMapper().mapApiToUi(it) })
    }

    companion object {

        fun newInstance() = DiffUtilsFragment()
    }
}