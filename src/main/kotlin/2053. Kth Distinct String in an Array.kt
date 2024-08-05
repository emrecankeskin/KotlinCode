class Q2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val ans = HashMap<String,Int>()
        var count = k
        for(str in arr){
            ans[str] = ans.getOrDefault(str,0) + 1
        }

        for(str in arr){
            if(ans[str] == 1){
                count--
            }
            if(count == 0){
                return str
            }
        }



        return ""
    }
}