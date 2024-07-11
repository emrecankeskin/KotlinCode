import java.util.Stack


//(ed(et(oc))el)
//(ed(etco)el)
//(edocteel)
class Q1190 {
    fun reverseParentheses(s: String): String {
        val st: Stack<Int> = Stack()
        val sb = StringBuilder()

        for(c in s){
            when(c){
                '(' -> st.push(sb.length)
                ')' ->{
                    val a = st.pop()
                    sb.reverseStr(a,sb.length-1)
                }
                else -> {
                    sb.append(c)
                }
            }
        }
        return sb.toString()
    }
    private fun StringBuilder.reverseStr(start:Int, end: Int){
        var a = start
        var b = end
        while(a < b){
            val temp = this[b]
            this.setCharAt(b--,this[a])
            this.setCharAt(a++,temp)
        }
    }
}