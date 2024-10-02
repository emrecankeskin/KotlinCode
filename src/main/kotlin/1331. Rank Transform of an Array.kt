class Solution {
    fun arrayRankTransform(arr: IntArray): IntArray {
        if(arr.isEmpty()){
            return IntArray(0)
        }
        val idxArr = arr.withIndex().sortedBy { it.value }

        val ans = IntArray(arr.size)
        var rank = 1
        ans[idxArr[0].index] = 1
        for(i in 1 until idxArr.size){
            if(idxArr[i].value != idxArr[i-1].value){
                rank += 1
            }
            ans[idxArr[i].index] = rank
        }

        return ans
    }
}