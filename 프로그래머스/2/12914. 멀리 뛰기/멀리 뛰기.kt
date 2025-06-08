class Solution {
    private val memo = mutableMapOf<Int, Long>()
    fun solution(n: Int): Long {
        return countWay(n) % 1234567
    }
    
    fun countWay(n: Int): Long {
        if (n<=0) return 0
        if (n<=1) return 1
        if (n<=2) return 2
        
        if (memo.containsKey(n)) {
            return memo[n]!!
        }
        
        val result = (countWay(n-1) + countWay(n-2)) % 1234567
        memo[n] = result
        return result
    }
}