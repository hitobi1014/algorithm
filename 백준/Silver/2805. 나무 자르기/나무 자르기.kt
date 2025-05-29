import java.io.*

fun main() {
    /*
     * 1. 0부터 최대 높이 H
     * 2. 중간값 구하기 -> mid = s + e / 2
     * 3. 나무 수 만큼 반복돌면서
     * 		mid > 나무 높이
     * 			totalLen += (mid - 높이)
     * 4. if (max < totalLen)
     * 		max = totalLen
     * 		res = mid
     * 5. 마지막 res 출력
*/
    // N: 나무수, M: 필요 나무길이
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val trees = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val result = findOptimalHeight(trees, M)
    println(result)
}

fun findOptimalHeight(trees: IntArray, M: Int):Int {
    var left = 0
    var right = trees.maxOrNull() ?: 0
    var answer = 0

    while (left <= right) {
        val mid = (left + right) / 2
        val totalWood = calcWood(trees, mid)

        if (totalWood >= M) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return answer
}

fun calcWood(trees: IntArray, height: Int): Long {
    var total = 0L
    for (tree in trees) {
        if (tree > height) {
            total += (tree- height)
        }
    }
    return total
}

