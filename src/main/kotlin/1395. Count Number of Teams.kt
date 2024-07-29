class Q1395 {
    fun numTeams(rating: IntArray): Int {
        var ans: Int = 0
        for( i in 1 until rating.size-1){
            val left = IntArray(2){0}
            val right = IntArray(2){0}

            for(j in 0 until i){

                //left less and bigger
                if(rating[j] < rating[i]){
                    left[1]++
                }else{
                    left[0]++
                }
            }
            for(k in (i+1) until rating.size){

                //right less and bigger
                if(rating[k] < rating[i]){
                    right[1]++ // less
                }else{
                    right[0]++ // right
                }
            }

            ans += left[0]*right[1] + left[1]*right[0]
        }

        return ans
    }
}