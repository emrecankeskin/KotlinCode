class Q840 {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {

        if (grid.size < 3 || grid[0].size < 3) {
            return 0
        }

        //precomputed set
        val st = mutableSetOf(
            listOf(4, 3, 8, 9, 5, 1, 2, 7, 6),
            listOf(2, 7, 6, 9, 5, 1, 4, 3, 8),
            listOf(8, 3, 4, 1, 5, 9, 6, 7, 2),
            listOf(6, 7, 2, 1, 5, 9, 8, 3, 4),
            listOf(6, 1, 8, 7, 5, 3, 2, 9, 4),
            listOf(8, 1, 6, 3, 5, 7, 4, 9, 2),
            listOf(2, 9, 4, 7, 5, 3, 6, 1, 8),
            listOf(4, 9, 2, 3, 5, 7, 8, 1, 6)
        )


        var ans = 0
        for (i in 0..(grid.size - 3)) {
            for (j in 0..(grid[i].size - 3)) {


                // center one must always be 5 because it is the mean of 3 values
                // (diagonal, row , column) 1+2....+9 = 45 -> 45 / 3 = 15 -> 15/3 = 5
                if (grid[i + 1][j + 1] != 5) {
                    continue
                }
                val arr = listOf(
                    grid[i][j], grid[i][j + 1], grid[i][j + 2],
                    grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                    grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])

                if (st.contains(arr)) {
                    ans += 1
                }
            }
        }
        return ans
    }
}