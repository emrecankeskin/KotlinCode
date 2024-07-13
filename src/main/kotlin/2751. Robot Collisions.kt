import java.util.Stack


/**
 * Similar to solving parentheses problem
 *
 * */
class Q2751 {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val arr = positions.indices.sortedBy { positions[it] }
        val st = Stack<Int>()
        val ans = ArrayList<Int>()
        for(i in arr){
            if(directions[i] == 'R'){
                st.push(i)
            }else{
                while (st.isNotEmpty() && healths[i] > 0){
                    val top = st.pop()
                    if(healths[top] > healths[i]){
                        healths[i] = 0
                        healths[top] -= 1
                        st.push(top)
                    }else if(healths[top] < healths[i]){
                        healths[i] -= 1
                    }else{
                        healths[i] = 0
                    }
                }
                if(healths[i] > 0 ){
                    ans.add(i)
                }
            }
        }
        ans.addAll(st)
        return ans.sorted().map{ healths[it] }
    }
}