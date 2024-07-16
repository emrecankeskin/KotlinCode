


class Q2096 {
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val adj = mutableMapOf<Int,MutableList<Pair<Int,Char>>>()

        //building graph from root node
        makeAdj(root,null,adj)
        //check if it is visited or not
        val vis = mutableSetOf<Int>()

        //we can use mutableList for queue
        val q = mutableListOf(Pair(startValue,""))

        //basic bfs
        while(q.isNotEmpty()){
            val (nodeVal,path) = q.removeFirst()
            if(nodeVal == destValue){
                return path
            }
            vis.add(nodeVal)
            adj.getValue(nodeVal).forEach{(connVal,dir) ->
                if(!vis.contains(connVal)){
                    q.add(Pair(connVal,path+dir))
                }
            }
        }
        return ""
    }

    private fun makeAdj(node: TreeNode?,prev: TreeNode?,adj: MutableMap<Int, MutableList<Pair<Int, Char>>>){

        if(node == null){
            return
        }

        val conn = adj.getOrPut(node.`val`,::mutableListOf)

        if(prev != null){
            conn.add(Pair(prev.`val`,'U'))
        }

        if(node.left != null){
            conn.add(Pair(node.left!!.`val`,'L'))
            makeAdj(node.left,node,adj)
        }

        if(node.right != null){
            conn.add(Pair(node.right!!.`val`,'R'))
            makeAdj(node.right,node,adj)
        }
    }
}