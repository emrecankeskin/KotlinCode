class Q1518 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var total = numBottles
        var cur = numBottles
        while(cur >= numExchange){
            total += cur / numExchange
            cur = (cur / numExchange) + (cur % numExchange)
        }

        return total
    }

}