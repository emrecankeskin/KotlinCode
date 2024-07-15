
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Q2196 {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val mp = HashMap<Int,TreeNode>()
        val set = HashSet<Int>()

        for((parent,child,left) in descriptions){
            val childNode = mp.getOrPut(child) { TreeNode(child) }
            val parentNode = mp.getOrPut(parent){ TreeNode(parent) }
            when(left){
                1 -> parentNode.left = childNode
                else -> parentNode.right = childNode
            }
            //keep track of the children
            set.add(child)
        }

        // if a value is not spotted as child return that value
        for((_,v) in  mp){
            if(!set.contains(v.`val`)){
                return v
            }
        }

        return null
    }
}