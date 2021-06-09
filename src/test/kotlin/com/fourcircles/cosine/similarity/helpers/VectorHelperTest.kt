package com.fourcircles.cosine.similarity.helpers

import com.fourcircles.cosine.similarity.service.CosineSimScoreService
import org.junit.jupiter.api.Test

class VectorHelperTest {
   private var vectorHelper: VectorHelper = VectorHelper()

    var wordsOccurenceSource1: HashMap<String, Int> = HashMap()
    var wordsOccurenceSource2: HashMap<String, Int> = HashMap()

    @Test
    fun `split string sentence into  vector  of words`() {
        val source = "chef who made his early rep creating adventurous that pushes the same expert meals each evening "
        val wordVector = vectorHelper.splitString(source)
        assert(wordVector.first() == "chef")
    }

    @Test
    fun `test norm of a vector`() {
        val source = "thor is a funny character. This character is in avengers movies"
        wordsOccurenceSource1 = vectorHelper.createVectorFromText(source)
        val normValue = "%.4f".format(vectorHelper.normOfVector(wordsOccurenceSource1))
        assert((normValue.toDouble()) == 3.8730)
    }

    @Test
    fun `inner product of two vectors test`() {
        val source = "thor is a funny character. This character is in avengers movies"
        wordsOccurenceSource1 = vectorHelper.createVectorFromText(source)
        val normValue = "%.4f".format(vectorHelper.normOfVector(wordsOccurenceSource1))
        assert((normValue.toDouble()) == 3.8730)
    }
    @Test
    fun `create vector from text`() {
        val source = "Thor is a funny character from avenger movies. Inigo Montoya is another funny character from movies."
        wordsOccurenceSource1 = vectorHelper.createVectorFromText(source)
        val wordVectorKeys = wordsOccurenceSource1.keys
//        wordVectorKeys.forEach(){
//            println(it + " = "  + wordsOccurenceSource1.get(it))
//        }
        assert(wordsOccurenceSource1.get("movies") == 2)
    }


}