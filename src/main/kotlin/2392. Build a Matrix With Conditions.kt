class Q2392 {

    private fun topoSort(arr: Array<IntArray>,n: Int): List<Int>{
        val adj = mutableMapOf<Int,MutableList<Int>>()
        val degree = IntArray(n+1)
        val order = mutableListOf<Int>()

        for((i,j) in arr){
            adj[i] = adj.getOrDefault(i, mutableListOf())
            adj[i]?.add(j)
            degree[j] += 1
        }
        val vis = ArrayDeque((1..n).filter { degree[it] == 0 })
        while (vis.isNotEmpty()){
            val node = vis.removeFirst()
            order.add(node)
            for(next in adj.getOrDefault(node, emptyList())){
                degree[next] -= 1
                if(degree[next] == 0){
                    vis.add(next)
                }
            }
        }
        if(order.size != n){
            return emptyList()
        }

        return order
    }

    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        val row = topoSort(rowConditions,k)
        val col = topoSort(colConditions,k)
        if(row.isEmpty() || col.isEmpty()){
            return emptyArray()
        }
        val mat = Array(k){IntArray(k){0}}
        val colMp = col.mapIndexed{index, num -> num to index}.toMap()
        for((r, num) in row.withIndex()){
            mat[r][colMp[num]!!] = num
        }

        return mat
    }
}