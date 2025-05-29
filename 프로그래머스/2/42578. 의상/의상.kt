class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        
        val clothesMap = mutableMapOf<String, Int>()
        
        for (cloth in clothes) {
            val type = cloth[1]
            clothesMap[type] = clothesMap.getOrDefault(type, 0) + 1
        }
        
        for (count in clothesMap.values) {
            answer *= (count+1)
        }
        
        return answer - 1
    }
}