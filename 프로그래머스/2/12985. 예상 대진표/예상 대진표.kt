class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        
        var a1 = a
        var b1 = b
        
        while (a1 != b1) {
            answer++
            if (a1 % 2 == 0) {
                a1 = a1/2
            } else {
                a1 = a1/2+1
            }
            
            if (b1%2==0) {
                b1 = b1/2
            } else {
                b1 = b1/2+1
            }
        }

        return answer
    }
}