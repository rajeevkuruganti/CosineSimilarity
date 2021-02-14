package com.fourcircles.cosine.similarity.helpers

import org.junit.jupiter.api.Test

class VectorHelperTest {
   private var wordHelper: WordHelper = WordHelper()

    @Test
    fun `create vector from source`(){
        val source = "chef who made his early rep creating adventurous that pushes the same expert meals each evening "
        val wordVector = wordHelper.splitString(source)
//        println(wordVector)
    }
}