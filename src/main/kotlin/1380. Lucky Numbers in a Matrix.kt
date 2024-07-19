class Q1380 {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val ans = mutableListOf<Int>()
        var row = IntArray(matrix.size){ Int.MAX_VALUE}
        var col = IntArray(matrix[0].size){ Int.MIN_VALUE }

        for(i in matrix.indices){
            for(j in matrix[0].indices){
                if(matrix[i][j] < row[i]){
                    row[i] = matrix[i][j]
                }
                if(matrix[i][j] > col[j]){
                    col[j] = matrix[i][j]
                }
            }
        }

        for(i in col){
            for(j in row){
                if(i == j){
                    ans.add(i)
                }
            }
        }

        return ans
    }
}