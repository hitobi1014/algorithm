class Solution {
    fun solution(arr: IntArray): Int {
        var answer = lcm(arr[0], arr[1])
        for (i in 2 until arr.size) {
            answer = lcm(answer, arr[i])
        }
        return answer
    }
    
    fun lcm(a:Int, b:Int):Int {
        val max = maxOf(a,b)
        val min = minOf(a,b)
        return a*b/gcd(max, min)
    }
    
    fun gcd(max:Int, min:Int):Int {
        return max.takeIf {min == 0} ?: gcd(min, max % min)
    }
}