package com.example.rcviewsample.ui.retrofit_fragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.rcviewsample.data.remote.quest.QuestApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RetrofitViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchQuestList(questApi: QuestApi?) {
        questApi?.let {
            compositeDisposable.add(questApi.getQuest("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.e("TAG", it)
                }, {

                })
            )
        }

    }
}