class Q1530 {
    var ans: Int = 0

    private fun dfs(node: TreeNode?, distance: Int): List<Int>?{
        if(node == null) return null

        val l = dfs(node.left,distance)
        val r = dfs(node.right,distance)
        val arr = arrayListOf<Int>()

        if(l != null && r != null){
            for(i in l){
                for(j in r){
                    if((i + j) <= distance){
                        ans++
                    }
                }
            }
        }
        if(l == null && r == null){
            arr.add(1)
        }
        if(l != null){
            for(i in l){
                arr.add(i+1)
            }
        }
        if(r != null){
            for(i in r){
                arr.add(i+1)
            }
        }

        return arr

    }
    fun countPairs(root: TreeNode?, distance: Int): Int {

        dfs(root,distance)
        return ans

    }
}