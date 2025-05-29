import java.io.BufferedReader
import java.io.InputStreamReader

val dx = intArrayOf(-1,1,0,0)
val dy = intArrayOf(0,0,-1,1)

fun main() {
    // 입력 받기
    // 테스트케이스 T
    // 가로 M 세로 N 개수 K
    //
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val (M, N, K) = br.readLine().split(" ").map { it.toInt() }

        // 배열 생성 => int[M][N]
        val grid = Array(M) { IntArray(N) }

        // 배추 심긴 곳
        repeat(K) {
            val (x, y) = br.readLine().split(" ").map {it.toInt()}
            grid[x][y] = 1
        }

        val result = count(grid, M, N)
        println(result)
    }

    br.close()
}

fun count(grid: Array<IntArray>, M: Int, N:Int): Int {
    val visited = Array(M) {BooleanArray(N)}

    var count = 0

    for (i in 0 until M) {
        for (j in 0 until N) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                bfs(grid, visited, i, j, M, N)
                count++
            }
        }
    }

    return count
}

fun bfs(grid: Array<IntArray>, visited: Array<BooleanArray>, startX:Int, startY:Int, M:Int, N:Int) {
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(Pair(startX, startY))
    visited[startX][startY] = true

    while (queue.isNotEmpty()) {
        val (x, y) = queue.removeFirst()

        // 4방향 탐색
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until M && ny in 0 until N && grid[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true
                queue.addLast(Pair(nx,ny))
            }
        }
    }
}

