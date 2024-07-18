/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Q1110 {
    fun delNodes(root: TreeNode?, toDelete: IntArray): List<TreeNode?> {
        if(root == null){
            return listOf()
        }
        val st = toDelete.toSet()
        val ans = mutableListOf<TreeNode?>()
        val q = mutableListOf<TreeNode?>()
        if(!st.contains(root?.`val`)){
            ans.add(root)
        }

        q.add(root)

        //BFS
        while(q.isNotEmpty()){
            val front = q.removeFirst()
            if(front?.left != null){
                q.add(front.left)
            }
            if(front?.right != null){
                q.add(front.right)
            }

            // make null if elements are in delete set
            if(front?.left != null && st.contains(front.left?.`val`)){
                front.left = null
            }
            if(front?.right != null && st.contains(front.right?.`val`)){
                front.right = null
            }
            // if current one is in delete set divide left and right
            if(st.contains(front?.`val`)){
                if(front?.left != null){
                    ans.add(front.left)
                }
                if(front?.right != null){
                    ans.add(front.right)
                }
            }
        }
        return ans

    }

}