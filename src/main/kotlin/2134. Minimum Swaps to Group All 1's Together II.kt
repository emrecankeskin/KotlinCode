class Q2134 {

    private fun IntArray.circular(i: Int) = this[i % this.size]
    fun minSwaps(nums: IntArray): Int {
        var wSz = 0
        var ans = 0
        var wNx = 0 // next

        for( i in nums){
            wSz += i
        }
        ans = wSz


        // calculate current window's 1's
        for(i in 0 until wSz){
            wNx += nums[i]
        }

        for(i in 0 until nums.size){
            ans = minOf(ans,wSz-wNx)

            wNx += nums.circular(i+wSz) // to right
            wNx -= nums.circular(i) // dec left of the window
        }

        return ans

    }
}