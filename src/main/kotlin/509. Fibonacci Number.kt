class Q509 {
    //solution with coroutines
    private val fibonacci: Sequence<Int> = sequence {
        var first = 0
        var second = 1
        while(true){
            yield(first)
            val temp = first
            first += second
            second = temp
        }
    }
    fun fib(n: Int): Int {
        return fibonacci.take(n+1).last()
    }
}