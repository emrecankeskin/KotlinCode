class Q2976 {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val dist = Array(26){IntArray(26){Int.MAX_VALUE / 2} }
        var ans = 0L
        for(i in 0 until 26){
            dist[i][i] = 0
        }

        for(i in cost.indices){
            dist[original[i]-'a'][changed[i]-'a'] = minOf(dist[original[i] - 'a'][changed[i] - 'a'], cost[i])
        }

        for(k in 0 until 26){
            for(i in 0 until 26){
                for(j in 0 until 26){
                    dist[i][j] = minOf(dist[i][j],dist[i][k] + dist[k][j])
                }
            }
        }

        for(i in source.indices){
            if(dist[source[i]-'a'][target[i]-'a'] == (Int.MAX_VALUE / 2)){
                return -1L
            }else{
                ans += dist[source[i]-'a'][target[i]-'a']
            }
        }

        return ans
    }
}