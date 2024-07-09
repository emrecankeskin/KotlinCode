class Q1701 {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var start: Long = customers[0][0].toLong()+customers[0][1]
        var ans: Long = customers[0][1].toLong()

        for(i in 1..<customers.size){
            if(customers[i][0] > start){
                println(customers[i][0])
                start = customers[i][0].toLong() + customers[i][1].toLong()

            }else{
                start += customers[i][1].toLong()
            }
            ans += start - customers[i][0]

        }

        return ans / customers.size*1.0
    }
}