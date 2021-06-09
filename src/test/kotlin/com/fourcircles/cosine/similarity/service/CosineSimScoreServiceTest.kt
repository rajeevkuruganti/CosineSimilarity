package com.fourcircles.cosine.similarity.service

import com.fourcircles.cosine.similarity.helpers.VectorHelper
import org.junit.jupiter.api.Test

class CosineSimScoreServiceTest {

    var wordsOccurenceSource1: HashMap<String, Int> = HashMap()
    var wordsOccurenceSource2: HashMap<String, Int> = HashMap()
    private var vectorHelper: VectorHelper = VectorHelper()
    @Test
    fun `test score from global and my set`() {
        val globalSource = "fiction avengers Downey action  suspense  logic  hero  tony stark"
        val mySource = "avengers thor action hero fiction"
        wordsOccurenceSource1 = vectorHelper.createVectorFromText(globalSource)
        wordsOccurenceSource2 = vectorHelper.createVectorFromText(mySource)
        val cosineScore = CosineSimScoreService.computeSimilarity(wordsOccurenceSource1,wordsOccurenceSource2)
        assert(cosineScore == 60)
    }

    @Test
    fun `test robert downey jr film picks up from avengers`() {

        wordsOccurenceSource1 =
            vectorHelper.createVectorFromText("Detective Sherlock Holmes and his stalwart partner Watson engage in a battle of wits and brawn with a nemesis whose plot is a threat to all of England. fiction, detective rich robert downey mystery")
        wordsOccurenceSource2 =
            vectorHelper.createVectorFromText("After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil. fiction, robert downey rich mystery ")
        assert(33 == CosineSimScoreService.computeSimilarity(wordsOccurenceSource1,wordsOccurenceSource2) )

    }

    @Test
    fun `test he or she likes avengers' movies`() {
        wordsOccurenceSource1 = vectorHelper.createVectorFromText("He likes Avengers’ movies")
        wordsOccurenceSource2 = vectorHelper.createVectorFromText("She likes Avengers’ movies")
        assert(75 == CosineSimScoreService.computeSimilarity(wordsOccurenceSource1,wordsOccurenceSource2) )
    }

}