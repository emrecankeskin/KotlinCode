class Q1598 {
    fun minOperations(logs: Array<String>): Int {
        var ans: Int = 0
        for(str in logs){
            if(str == "../"){
                ans = maxOf(ans-1,0)
            }else if(str == "./"){
                continue
            }else{
                ans++
            }
        }

        return ans
    }
}