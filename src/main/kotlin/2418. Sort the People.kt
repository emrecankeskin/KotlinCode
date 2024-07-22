import java.util.TreeMap

class Q2418 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val mp = TreeMap<Int,String>()
        heights.forEachIndexed { index, i ->
            mp[i] = names[index]
        }

        return mp.values.reversed().toTypedArray()
    }
}