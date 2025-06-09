class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0

        val stack = ArrayDeque<Char>()
        for (c in s) {
            stack.addLast(c)
        }

        repeat(s.length-1) {
            if (sol(stack)) {
                answer += 1
            }
            val removeFirst = stack.removeFirst()
            stack.addLast(removeFirst)
        }
        return answer
    }

    fun sol(stack: ArrayDeque<Char>): Boolean {
        val str = stack.joinToString("")
        val tmpStack = ArrayDeque<Char>()
        for (c in str) {
            when (c) {
                ')' -> {
                    if (!tmpStack.isEmpty() && tmpStack.removeLast() == '(' ) continue
                    else return false
                }
                '}' -> {
                    if (!tmpStack.isEmpty() && tmpStack.removeLast() == '{' ) continue
                    else return false
                }
                ']' -> {
                    if (!tmpStack.isEmpty() && tmpStack.removeLast() == '[' ) continue
                    else return false
                }
                else -> {
                    tmpStack.addLast(c)
                }
            }
        }
        return tmpStack.isEmpty()
    }

}