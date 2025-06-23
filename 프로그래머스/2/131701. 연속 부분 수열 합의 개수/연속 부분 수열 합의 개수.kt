class Solution {
    fun solution(elements: IntArray): Int {
        val n = elements.size
        val sums = mutableSetOf<Int>()
        
        val doubled = elements + elements
        
        for (length in 1..n) {
            var sum = doubled.sliceArray(0 until length).sum()
            sums.add(sum)
            
            for (i in 1 until n) {
                sum = sum - doubled[i-1] + doubled[i + length - 1]
                sums.add(sum)
            }
        }
       return sums.size
    }
}