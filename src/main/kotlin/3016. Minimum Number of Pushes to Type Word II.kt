class Q3016 {
    fun minimumPushes(word: String): Int {
        val mp = IntArray(26){0}
        val total = 8
        var ans = 0
        for(ch in word){
            mp[ch-'a']++
        }
        mp.sortDescending()

        for((push, i) in (0 until 26).withIndex()){
            ans += mp[i]*((push / total) +1)
        }

        return ans
    }
}