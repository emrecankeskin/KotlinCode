class Q273 {
    val mp = mapOf(
        Pair(0,""),
        Pair(1,"One"),
        Pair(2,"Two"),
        Pair(3,"Three"),
        Pair(4,"Four"),
        Pair(5,"Five"),
        Pair(6,"Six"),
        Pair(7,"Seven"),
        Pair(8,"Eight"),
        Pair(9,"Nine"),
        Pair(10,"Ten"),
        Pair(11,"Eleven"),
        Pair(12,"Twelve"),
        Pair(13,"Thirteen"),
        Pair(14,"Fourteen"),
        Pair(15,"Fifteen"),
        Pair(16,"Sixteen"),
        Pair(17,"Seventeen"),
        Pair(18,"Eighteen"),
        Pair(19,"Nineteen"),
        Pair(20,"Twenty"),
        Pair(30,"Thirty"),
        Pair(40,"Forty"),
        Pair(50,"Fifty"),
        Pair(60,"Sixty"),
        Pair(70,"Seventy"),
        Pair(80,"Eighty"),
        Pair(90,"Ninety"),
    )
    val nums = intArrayOf(100,1_000,1_000_000,1_000_000_000)

    fun numberToWords(num: Int): String {
        if(num == 0) return "Zero"

        return convert(num).trim()

    }

    private fun convert(num: Int): String{
        var ans = ""
        val sb = StringBuilder()
        ans = if(num >= 1_000_000_000){
            sb
                .append(convert(num / nums[3]))
                .append(" Billions ")
                .append(convert(num % nums[3]))
                .toString()
        }else if(num >= 1_000_000){
            sb
                .append(convert(num / nums[2]))
                .append(" Millions ")
                .append(convert(num % nums[2]))
                .toString()
        }else if(num >= 1_000){
            sb
                .append(convert(num / nums[1]))
                .append(" Thousand ")
                .append(convert(num % nums[1]))
                .toString()
        }else if(num >= 100){
            sb
                .append(convert(num / nums[0]))
                .append(" Hundred ")
                .append(convert(num % nums[0]))
                .toString()
        }else if(num >= 20){
            sb
                .append(mp[(num / 10)*10] ?: "")
                .append(" ")
                .append(convert(num % 10))
                .toString()
        }else{
            mp[num] ?: ""
        }

        return ans.trim()
    }
}