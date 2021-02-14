package com.fourcircles.cosine.similarity.helpers

class WordHelper {

    fun splitString(source: String): List<String> {

//        val separatorChar = Regex.escape(" ")
        val somethingWords = source.split("\\s+".toRegex())

//        println(put)
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
    fun createVectorFromText(sField: String): HashMap<String, Int>{
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
    fun innnerProduct(vector1: HashMap<String,Int>,vector2: HashMap<String,Int>) : Double {
        val sortedVec1 = vector1.toSortedMap()
        val sortedVec2 = vector2.toSortedMap()
        println("sorted vec1 "+ sortedVec1.toString())
        println("sorted vec2 "+ sortedVec2.toString())
        var sum = 0.0
         vector1.keys.map{
             if (vector2.containsKey(it)) {
                 sum = sum + vector1.get(it)?.times(vector2.get(it)!!)!! ?: 0.00
             }
         }
        return sum
    }

    fun computeSimilarity(
        wordsOccurence: HashMap<String, Int>,
        wordsOccurence1: HashMap<String, Int>
    ): Int {
        var rawSimScore = innnerProduct(wordsOccurence,wordsOccurence1)/(normOfVector(wordsOccurence)*normOfVector(wordsOccurence1))
        return Math.round(rawSimScore.toFloat()*100)
    }

}

fun main(args: Array<String>) {
    val wordHelper = WordHelper()

    var wordsOccurence: HashMap<String, Int> = HashMap()
    var wordsOccurence1: HashMap<String, Int> = HashMap()
//    wordsOccurence = wordHelper.createVectorFromText("this is my string and a short string for this")
     wordsOccurence = wordHelper.createVectorFromText("The beans Cow jumped Over The moon. Good Morning. Jumped Beans")
     wordsOccurence1 = wordHelper.createVectorFromText("The cow jumped over the moon. beans Good morning. Jumped Beans")
//    println(wordsOccurence.toString())
//    println(wordsOccurence1.toString())
//    println(wordHelper.normOfVector(wordsOccurence))
//    println(wordHelper.normOfVector(wordsOccurence1))

    print(" cosine similarity = " + wordHelper.computeSimilarity(wordsOccurence,wordsOccurence1) )

}

