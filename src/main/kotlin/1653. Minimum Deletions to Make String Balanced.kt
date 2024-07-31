class Q1653 {
    fun minimumDeletions(s: String): Int {
        var count = 0 // a count
        var exchange = 0 // b count
        var mn = Int.MAX_VALUE
        var ptr = 0


        //count 'a' to calculate 'a's to the right of index
        for( c in s ){
            if(c == 'a') count++
        }


        while (count != 0) {
            //decrement because we only want right side of it
            if (s[ptr++] == 'a'){
                count--
            } else{
              mn = minOf(mn,exchange+count)
              exchange++
            }
        }

        return minOf(exchange,mn)

    }
}