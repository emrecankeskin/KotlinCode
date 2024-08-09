class Q885 {
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        val ans = Array(rows*cols){ IntArray(2) }
        var ptr = 0
        var r = rStart
        var c = cStart
        ans[ptr++] = intArrayOf(r,c)
        var k = 2
        while(ptr < rows*cols){
            c++
            if(r in 0 until rows && c in 0 until cols){
                ans[ptr++] = intArrayOf(r,c)
            }
            repeat(k-1){
                r++
                if(r in 0 until rows && c in 0 until cols){
                    ans[ptr++] = intArrayOf(r,c)
                }
            }
            repeat(k){
                c--
                if(r in 0 until rows && c in 0 until cols){
                    ans[ptr++] =intArrayOf(r,c)
                }
            }
            repeat(k){
                r--
                if(r in 0 until rows && c in 0 until cols){
                    ans[ptr++] = intArrayOf(r,c)
                }
            }
            repeat(k){
                c++
                if(r in 0 until rows && c in 0 until cols){
                    ans[ptr++] = intArrayOf(r,c)
                }
            }
            k += 2
        }

        return ans
    }

}