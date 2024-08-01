class Q2678 {
    fun countSeniors(details: Array<String>): Int {
        var ans = 0

        for(str in details){
            val age = (str[11]-'0')*10 + (str[12]-'0')
            if(age > 60){
                ans++
            }
        }


        return ans

    }
}