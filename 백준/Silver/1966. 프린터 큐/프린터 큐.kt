import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    /*
     * T: 테스트케이스
     * N: 문서 개수
     * M: 궁금한 문서 순서 (맨 왼쪽은 0)
     * N개의 문서 중요도가 차례로 주어짐
     **/

    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val arr = br.readLine().split(" ").map { it.toInt() }

        println(findDoc(arr, M))
    }
}

fun findDoc(arr: List<Int>, M:Int):Int {
    val queue = LinkedList<Pair<Int, Int>>()
    val pq = PriorityQueue<Int>(reverseOrder())

    for (i in arr.indices) {
        queue.offer(Pair(arr[i],i))
        pq.offer(arr[i])
    }

    var printOrder = 0
    while (queue.isNotEmpty()) {
        val current = queue.peek()
        val currentPriority = current.first
        val currentIndex = current.second

        val maxPriority = pq.peek()

        if (currentPriority == maxPriority) {
            queue.poll()
            pq.poll()
            printOrder++

            if (currentIndex == M) {
                return printOrder
            }
        } else {
            queue.poll()
            queue.offer(current)
        }
    }

    return -1
}
