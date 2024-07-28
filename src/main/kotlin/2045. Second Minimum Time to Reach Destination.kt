
class Q2045 {
    fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {

        val adj = Array<MutableList<Int>>(n+1){mutableListOf()}
        val dq = ArrayDeque<MutableList<Int>>()

        val vis = IntArray(n+1)
        val timeArr = IntArray(n+1){-1}

        dq.add(mutableListOf(1,0))
        timeArr[0] = 0

        for(e in edges){
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        while (dq.isNotEmpty()){
            val sz = dq.size
            for(i in 0 until sz){

                val cur = dq.removeFirst()
                val light = cur[1] / change

                //check if green or red
                val next = if(light % 2 == 0){
                    cur[1] + time
                }else{
                    (light+1)*change + time
                }

                for(node in adj[cur[0]]){
                    if(vis[node] < 2 && timeArr[node] < next){

                        dq.add(mutableListOf(node,next))
                        vis[node]++
                        timeArr[node] = next

                        // we are searching for 2nd minimum
                        if(node == n && vis[node] == 2) return next

                    }
                }
            }
        }


        return -1
    }
}