class Q350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val ans = mutableListOf<Int>()
        val mp = IntArray(1001){0}

        nums1.forEach { mp[it]++ }

        nums2.forEach {
            if(mp[it] > 0){
                ans.add(it)
                mp[it]--
            }
        }
        return ans.toIntArray()
    }
}