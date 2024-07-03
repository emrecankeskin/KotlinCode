class Q1509 {
    fun minDifference(nums: IntArray): Int {
        if(nums.size <= 4){
            return 0
        }
        nums.sort()
        return minOf(
            nums[nums.size-4]-nums[0],
            nums[nums.size-3]-nums[1],
            nums[nums.size-2]-nums[2],
            nums[nums.size-1]-nums[3]
        )

    }
}