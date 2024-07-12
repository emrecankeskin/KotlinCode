import java.util.*

class Q1717{
    fun maximumGain(s: String, x: Int, y: Int): Int {
        val st1 = Stack<Char>()
        val st2 = Stack<Char>()
        val first = if (x > y) 'a' else 'b'
        val second = if (x > y) 'b' else 'a'
        val mx = maxOf(x,y)
        val mn = minOf(x,y)
        var ans = 0

        for(c in s){
            if (st1.isNotEmpty() && st1.peek() == first && c == second){
                st1.pop()
                ans += mx
            }else{
                st1.push(c)
            }
        }
        while(st1.isNotEmpty()){
            val ch = st1.pop()

            // we do the same thing because in stack it is reversed
            // for searching "ba" we should check for "ab" again
            if(st2.isNotEmpty() && st2.peek() == first && ch == second){
                st2.pop()
                ans += mn
            }else{
                st2.push(ch)
            }
        }

        return ans
    }
}