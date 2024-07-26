class Q1334 {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val mat = Array(n){IntArray(n){Int.MAX_VALUE / 2}}
        var ans = -1
        var value = Int.MAX_VALUE

        for(i in 0 until n){
            mat[i][i] = 0
        }

        for(edge in edges){
            mat[edge[0]][edge[1]] = edge[2]
            mat[edge[1]][edge[0]] = edge[2]
        }

        for(k in 0 until n){
            for(i in 0 until n){
                for(j in 0 until n){
                    val a = mat[i][k]
                    val b = mat[k][j]
                    if(a + b < mat[i][j]){
                        mat[i][j] = a + b
                    }
                }
            }
        }
        for(i in 0 until n){
            val a = mat[i].count { it <= distanceThreshold }
            if(value >= a){
                value = a
                ans = i
            }
        }


        return ans
    }
}