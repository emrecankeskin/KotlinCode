class Q2582{
    fun passThePillow(n: Int, time: Int): Int {
        if(n >= time){
            return time+1
        }
        var direction = -1
        var count = 0
        var idx = 1
        while(count <= time){
            if(count == n || count == 1){
                direction *= -1
            }
            count++
            idx += direction
        }

        return idx
    }
}