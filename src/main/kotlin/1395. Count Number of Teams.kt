class Q1395 {
    fun numTeams(rating: IntArray): Int {
        var ans: Int = 0


        for( i in 1 until rating.size-1){
            val left = IntArray(2){0}
            val right = IntArray(2){0}


            // search before i
            for(j in 0 until i){

                //left less and bigger
                if(rating[j] < rating[i]){
                    left[1]++ //less
                }else{
                    left[0]++ // bigger
                }
            }
            // search after i
            for(k in (i+1) until rating.size){

                //right less and bigger
                if(rating[k] < rating[i]){
                    right[1]++ // less
                }else{
                    right[0]++ // bigger
                }
            }
            // ascending                   descending
            // left less * right bigger + left bigger * right less
            ans += left[0]*right[1] + left[1]*right[0]
        }

        return ans
    }
}