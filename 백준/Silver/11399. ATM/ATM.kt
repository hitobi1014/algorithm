import java.io.*
import java.util.*

fun main() {
    /*
     * line1 N: 사람 수
     * line2 Pi: 인출 시간
     **/

    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map{ it.toInt() }.sorted()

    var res = 0
    var sum = 0
    for (i in arr.indices) {
        sum += arr[i]
        res += sum
    }

    print(res)
}

