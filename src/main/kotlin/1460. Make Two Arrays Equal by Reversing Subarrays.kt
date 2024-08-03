class Q1460 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val mp1 = IntArray(1001){0}
        val mp2 = IntArray(1001){0}

        for(i in target.indices){
            mp1[target[i]] += 1
            mp2[arr[i]] += 1
        }

        for(i in mp1.indices){
            if(mp1[i] != mp2[i]){
                return false
            }
        }
        return true
    }
}