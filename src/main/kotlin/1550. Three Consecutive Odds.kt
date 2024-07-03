class Q1550 {
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        return arr
            .asSequence()
            .windowed(3)
            .any{it[0] % 2 == 1 && it[1] % 2 == 1 && it[2] % 2 == 1}
    }
}