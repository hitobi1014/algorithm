class Solution {
    fun solution(n: Int): Int {
        var answer = fibonacci(n)
        return answer
    }
    
    fun fibonacci(n: Int):Int {
        
        var prev2 = 0
        var prev1 = 1
        
        for (i in 2..n) {
            val current = (prev1 + prev2) % 1234567
            prev2 = prev1
            prev1 = current
        }
        
        return prev1
    }
}