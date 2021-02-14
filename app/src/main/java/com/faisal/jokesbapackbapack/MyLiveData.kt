package com.faisal.jokesbapackbapack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyLiveData: ViewModel() {

    private val data = MutableLiveData<String>()
    val getData: LiveData<String> get() = data
    var currentIndexQuestion = 0
    var qnaDataa =ArrayList<QuestionAndAnswer>()
    var point = 0


    fun data(item: String) {
        data.value = item
    }

    fun question(qna: QuestionAndAnswer) {
        qnaDataa.add(qna)
    }

    fun getQnaData(): ArrayList<QuestionAndAnswer> {
        return qnaDataa
    }

    fun currentQuestionIndex() {
        if (currentIndexQuestion > qnaDataa.size) {
            currentIndexQuestion = qnaDataa. size
        } else {
            currentIndexQuestion += 1
        }
    }

    fun callQnA() {
        qnaDataa.add(QuestionAndAnswer(1, "Hewan apa yang kaki dan tangannya ada dikepala ?", "kutu"))
        qnaDataa.add(QuestionAndAnswer(2, "Kalo sapi jadi ayam, domba jadi ayam, manusia jadi ayam, ayam jadi apa?", "banyak"))
        qnaDataa.add(QuestionAndAnswer(3, "Huruf depan K huruf belakang L, bisa di telan. Apakah itu ?", "kapsul"))
        qnaDataa.add(QuestionAndAnswer(5, "Ada dipagi, ada disiang, gk ada di malam. Apa hayo ?", "huruf i"))
        qnaDataa.add(QuestionAndAnswer(6, "Dia bersembunyi di belakang kastil, berada di tengah malam dan muncul di depan lilin. Apakah dia ?", "huruf L"))
        qnaDataa.add(QuestionAndAnswer(7, "Limbad kalo tobat jadi apa ?", "limgood"))
        qnaDataa.add(QuestionAndAnswer(8, "Di gunting makin tinggi, apa ?", "celana"))
        qnaDataa.add(QuestionAndAnswer(9, "Kalo kita tidur dia bangun, kalo kit bangun dia tidur, apakah itu ?", "kaki"))
        qnaDataa.add(QuestionAndAnswer(10, "Burung apa yang suka melanggar lalu lintas ?", "kutilang"))
        qnaDataa.add(QuestionAndAnswer(11, "Ayam apa yang paling luas ?", "ayamsemesta"))




    }

    fun qnaData(int: Int): QuestionAndAnswer {
        return qnaDataa[int]
    }

    fun point() {
        point += 1
    }
}