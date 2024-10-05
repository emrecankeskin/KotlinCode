class Solution {

    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        val arr1 = IntArray(26)
        val arr2 = IntArray(26)
        for(c in s1){
            arr1[c-'a']++
        }

        //left ptr
        var l = 0

        //sliding window
        //r ptr
        for(r in s2.indices){
            arr2[s2[r]-'a']++
            val range = r-l+1
            if(range > s1.length){
                arr2[s2[l]-'a']--
                l += 1
            }
            if(arr1.contentEquals(arr2)) return true
        }

        return false
    }
}