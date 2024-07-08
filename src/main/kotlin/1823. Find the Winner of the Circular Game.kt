class Q1823 {
    fun findTheWinner(n: Int, k: Int): Int {
        var ans: Int = 0
        for(i in 2..n){
            ans = (ans+k) % i
        }

        return ans + 1
    }
}