import java.util.Stack

class Q726 {
    fun countOfAtoms(formula: String): String {
        val mp = HashMap<String,Int>()
        val st = Stack<Int>()
        var atom = ""
        var count = ""
        var multiplier = 1

        for( i in formula.lastIndex downTo 0){
            val ch = formula[i]
            when{
                ch.isDigit() -> count = "$ch"+count
                ch.isLowerCase() -> atom = "$ch" + atom
                ch == ')' -> {
                    if(count.isNotEmpty()){
                        val next = count.toInt()
                        st.push(next)
                        multiplier *= next
                        count = ""
                    }
                }
                ch == '(' -> {
                    // finished to parse parenthesis so divide multiplier by prev
                    if(st.isNotEmpty()){
                        val prev = st.pop()
                        multiplier /= prev
                    }
                }
                ch.isUpperCase() -> {
                    atom = "$ch" + atom
                    var next = 0
                    next = if(count.isEmpty()){
                        1
                    }else{
                        count.toInt()
                    }
                    mp[atom] = mp.getOrDefault(atom,0) + next*multiplier
                    count = ""
                    atom = ""
                }
            }
        }
        val sb = StringBuilder()
        for(a in mp.toSortedMap().keys){
            sb.append(a)
            val k = mp[a]
            if (k != null) {
                if(k > 1){
                    sb.append(""+k)
                }
            }
        }

        return sb.toString()
    }
}