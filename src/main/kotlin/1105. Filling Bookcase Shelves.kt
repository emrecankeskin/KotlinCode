class Q1105 {
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {

        val dp = IntArray(books.size+1){Int.MAX_VALUE / 2}
        dp[0] = 0

        for(i in 1 until books.size+1){
            var w = 0
            var h = 0

            for( j in i downTo 1){

                w += books[j-1][0]

                if(w > shelfWidth){
                    break
                }

                h = maxOf(h,books[j-1][1])

                dp[i] = minOf(dp[i],dp[j-1]+h)

            }
        }

        return dp[books.size]

    }
}