class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        // 1. 각 크기별 개수 count
        val countMap = mutableMapOf<Int, Int>()
        for (size in tangerine) {
            countMap[size] = countMap.getOrDefault(size, 0) + 1
        }
        
        // 2. 개수 기준 내림차순 정렬
        val sortedCounts = countMap.values.sortedDescending()
        
        // 3. 개수가 많은것부터 선택
        var selected = 0 // 선택한 귤 개수
        var types = 0 // 사용한 크기 종류 수
        
        for (count in sortedCounts) {
            selected += count
            types++
            
            // k개 이상 선택했으면 종료
            if (selected >= k) {
                break
            }
        }
        
        return types
    }
}