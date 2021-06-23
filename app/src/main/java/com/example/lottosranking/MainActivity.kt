package com.example.lottosranking

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers1: ArrayList<Int> = arrayListOf(44, 1, 0, 0, 31, 25)     // lottos
        val numbers11: ArrayList<Int> =
            arrayListOf(31, 10, 45, 1, 6, 19)   // win_nums, result: [3, 5]

        val numbers2: ArrayList<Int> = arrayListOf(0, 0, 0, 0, 0, 0)        // lottos
        val numbers22: ArrayList<Int> =
            arrayListOf(38, 19, 20, 40, 15, 25) // win_nums, result: [1, 6]

        val numbers3: ArrayList<Int> = arrayListOf(45, 4, 35, 20, 3, 9)     // lottos
        val numbers33: ArrayList<Int> =
            arrayListOf(20, 9, 3, 45, 4, 35)    // win_nums, result: [1, 1]

        solution(numbers1, numbers11)
    }

    private fun solution(lottos: ArrayList<Int>, win_nums: ArrayList<Int>): IntArray {
        Log.v(TAG, "solution, lottos:$lottos\n win_nums:$win_nums")

        // 최저 순위, 랭킹
        val lowList = arrayListOf<Int>()
        lottos.forEach { l -> win_nums.forEach { w -> if (l == w) lowList.add(l) } }
        val lowRanking = checkRanking(lowList.size)
        Log.e(TAG, "lowList:$lowList\n ranking:$lowRanking")

        // 최고 순위, 0 체크 랭킹
        val zeroList = arrayListOf<Int>()
        lottos.forEach { z ->
            if (z == 0) {
                zeroList.add(z)
                Log.e(TAG, "z:$z\n, zeroList:$zeroList")
            }
        }

        val topRanking = checkRanking(zeroList.size+lowList.size)
        Log.e(TAG, "top ranking:$topRanking")

        return intArrayOf(topRanking, lowRanking)
    }

    private fun checkRanking(n: Int): Int {
        Log.v(TAG, "checkRanking")
        return when (n) {
            2 -> 5
            3 -> 4
            4 -> 3
            5 -> 2
            6 -> 1
            else -> 6
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}