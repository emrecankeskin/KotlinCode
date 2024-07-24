class Q2191{

    private fun transform(num: Int,mapping: IntArray): Int{
        if(num == 0){
            return mapping[0]
        }
        var number = num
        var mul = 1
        var ans = 0

        while(number > 0) {
            ans += mul * mapping[number % 10]
            mul *= 10
            number /= 10
        }

        return ans
    }
    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        return nums.sortedBy { transform(it,mapping) }.toIntArray()
    }
}