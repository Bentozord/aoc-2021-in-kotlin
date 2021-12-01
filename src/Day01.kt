fun main() {
    fun part1(input: List<Int>): Long {
        return input.zipWithNext()
                .stream()
                .filter { pair -> pair.first < pair.second }
                .count()
    }


    fun part2(input: List<Int>): Long {
        val result = mutableListOf<Int>()
        for (i in 0..input.size - 3) {
            result.add(sumThreeElements(input, i))
        }
        return part1(result)
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test").map { it.toInt() }
    check(part1(testInput) == 7L)
    check(part2(testInput) == 5L)

    val input = readInput("Day01").map { it.toInt() }
    println(part1(input))
    println(part2(input))
}

fun sumThreeElements(input: List<Int>, i: Int): Int {
    return input[i] + input[i + 1] + input[i + 2]
}