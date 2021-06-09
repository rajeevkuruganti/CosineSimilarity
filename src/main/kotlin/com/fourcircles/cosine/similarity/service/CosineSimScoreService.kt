package com.fourcircles.cosine.similarity.service

import com.fourcircles.cosine.similarity.helpers.VectorHelper

class CosineSimScoreService {companion object  {
    fun computeSimilarity (
        wordsOccurence: HashMap<String, Int>,
        wordsOccurence1: HashMap<String, Int>
    ): Int {
          val vectorHelper:VectorHelper = VectorHelper()
        var rawSimScore = vectorHelper.innerProduct(wordsOccurence,wordsOccurence1)/(vectorHelper.normOfVector(wordsOccurence)*vectorHelper.normOfVector(wordsOccurence1))
        return Math.round(rawSimScore.toFloat()*100)
    }
}
}