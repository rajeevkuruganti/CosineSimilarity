package com.fourcircles.cosine.similarity.helpers

import com.fourcircles.cosine.similarity.service.CosineSimScoreService

class VectorHelper {

    fun splitString(source: String): List<String> {
        val somethingWords = source.split("\\s+".toRegex())
        val words = source.split("\\s+".toRegex()).map { word ->
            word.replace("""^[,\.]|[,\.]$""".toRegex(), "")
        }
        return words
    }

    fun normOfVector(hashMap: HashMap<String, Int>): Double {
        var normValue: Int = 0
        hashMap.keys.map {
            normValue = normValue + hashMap.getValue(it) * hashMap.getValue(it)
        }
        return Math.sqrt(normValue.toDouble())
    }

    fun createVectorFromText(sField: String): HashMap<String, Int> {
        var wordsOccurence: HashMap<String, Int> = HashMap()
        var splitString = splitString(sField)
        splitString.map {
            val theWord = it.toLowerCase()
            if (wordsOccurence.containsKey(theWord)) {
                wordsOccurence.put(theWord, wordsOccurence.getValue(theWord) + 1)
            } else {
                wordsOccurence.put(theWord, 1)
            }
        }
        return wordsOccurence
    }

    fun innerProduct(vector1: HashMap<String, Int>, vector2: HashMap<String, Int>): Double {
        val sortedVec1 = vector1.toSortedMap()
        val sortedVec2 = vector2.toSortedMap()
        var sum = 0.0
        vector1.keys.map {
            if (vector2.containsKey(it)) {
                sum = sum + vector1.get(it)?.times(vector2.get(it)!!)!! ?: 0.00
            }
        }
        return sum
    }

}


