package com.example.rcviewsample.ui.diffutils_rc_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rcviewsample.R
import com.example.rcviewsample.databinding.CellTweetImageBinding
import com.example.rcviewsample.databinding.CellTweetQuoteBinding
import com.example.rcviewsample.databinding.CellTweetTextBinding
import com.example.rcviewsample.model.Tweet
import com.example.rcviewsample.model.TweetImage
import com.example.rcviewsample.model.TweetQuote
import com.example.rcviewsample.model.TweetSimple
import com.squareup.picasso.Picasso

interface TwitterDelegate {
    fun openProfile(profile: String)
    fun openImage(url: String)
}

class TwitterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val mDataList: MutableList<Tweet> = ArrayList()
    private var delegate: TwitterDelegate? = null

    fun attachDelegate(delegate: TwitterDelegate) {
        this.delegate = delegate
    }

    fun setData(data: List<Tweet>) {
        mDataList.clear()
        mDataList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            1 -> ImageViewHolder(
                inflater.inflate(R.layout.cell_tweet_image, parent, false),
                delegate
            )
            2 -> QuoteViewHolder(
                inflater.inflate(R.layout.cell_tweet_quote, parent, false),
                delegate
            )
            else -> TextViewHolder(
                inflater.inflate(R.layout.cell_tweet_text, parent, false),
                delegate
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mDataList[position]
        when (holder) {
            is TextViewHolder -> holder.bind(item as TweetSimple)
            is ImageViewHolder -> holder.bind(item as TweetImage)
            is QuoteViewHolder -> holder.bind(item as TweetQuote)
        }
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (mDataList[position]) {
            is TweetSimple -> 0
            is TweetImage -> 1
            is TweetQuote -> 2
        }
    }

    class TextViewHolder(private val view: View, private val delegate: TwitterDelegate?) :
        RecyclerView.ViewHolder(view) {
        private val binding: CellTweetTextBinding = CellTweetTextBinding.bind(view)
        fun bind(model: TweetSimple) = with(binding) {
            nameUser.text = model.username
            tweetName.text = model.displayName
            txtTweetText.text = model.text
            Picasso.get().load(model.avatar).fit().into(avatar)
            nameUser.setOnClickListener {
                delegate?.openProfile(model.username)
            }

            tweetName.setOnClickListener {
                delegate?.openProfile(model.username)
            }

            avatar.setOnClickListener {
                delegate?.openImage(model.avatar ?: "EmptyURL")
            }
        }
    }

    class QuoteViewHolder(private val view: View, val delegate: TwitterDelegate?) :
        RecyclerView.ViewHolder(view) {
        private val binding: CellTweetQuoteBinding = CellTweetQuoteBinding.bind(view)
        fun bind(model: TweetQuote) = with(binding) {
            nameUser.text = model.username
            tweetName.text = model.displayName
            txtTweetText.text = model.text
            textTweetQuoteText.text = model.quote?.text ?: ""
            textTweetQuoteUsername.text = model.quote?.username ?: ""
            Picasso.get().load(model.avatar).fit().into(avatar)

            nameUser.setOnClickListener {
                delegate?.openProfile(model.username)
            }

            tweetName.setOnClickListener {
                delegate?.openProfile(model.username)
            }

            avatar.setOnClickListener {
                delegate?.openImage(model.avatar)
            }

            textTweetQuoteText.setOnClickListener {
                delegate?.openProfile(model.quote?.username ?: "EmptyURL")
            }
        }
    }

    class ImageViewHolder(private val view: View, val delegate: TwitterDelegate?) :
        RecyclerView.ViewHolder(view) {
        private val binding: CellTweetImageBinding = CellTweetImageBinding.bind(view)
        fun bind(model: TweetImage) = with(binding) {
            nameUser.text = model.username
            tweetName.text = model.displayName
            txtTweetText.text = model.text
            Picasso.get().load(model.avatar).fit().into(avatar)
            Picasso.get().load(model.image).into(imageTweetContent)

            nameUser.setOnClickListener {
                delegate?.openProfile(model.username)
            }

            tweetName.setOnClickListener {
                delegate?.openProfile(model.username)
            }

            avatar.setOnClickListener {
                delegate?.openImage(model.avatar)
            }

            imageTweetContent.setOnClickListener {
                delegate?.openImage(model.image)
            }
        }
    }
}