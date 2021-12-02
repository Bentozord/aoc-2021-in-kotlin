import kotlin.math.abs

data class Instruction(val type: String, val value: Int)


fun main() {
    val testInput = readInput("Day02_test")
            .map { s -> s.split(" ") }
            .map { Instruction(it[0], it[1].toInt()) }
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
            .map { s -> s.split(" ") }
            .map { Instruction(it[0], it[1].toInt()) }
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<Instruction>): Int {
    return countTypeValues(input, "forward") * abs(countTypeValues(input, "up") - countTypeValues(input, "down"))
}

private fun countTypeValues(input: List<Instruction>, type: String) =
        input.stream().filter { it.type == type }.mapToInt { it.value }.sum()

fun part2(input: List<Instruction>): Int {
    var aim = 0
    var depth = 0
    input.forEach {
        run {
            when (it.type) {
                "forward" -> depth += aim * it.value
                "down" -> aim -= it.value
                "up" -> aim += it.value
            }
        }
    }
    return countTypeValues(input, "forward") * abs(depth)
}
