class Q1605 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {

        val ans = Array(rowSum.size){IntArray(colSum.size){0}}

        var i = 0
        var j = 0

        while(i < rowSum.size &&
              j < colSum.size  ){
            val tmp = minOf(rowSum[i],colSum[j])
            ans[i][j] = tmp
            rowSum[i] -= tmp
            colSum[j] -= tmp

            if(rowSum[i] > 0){
                j += 1
                continue
            }
            if(colSum[j] > 0){
                i += 1
                continue
            }

            i++
            j++
        }

        return ans
    }
}