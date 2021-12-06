fun main() {
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    val input = readInput("Day03")
    println(part1(input))

    check(part2(testInput) == 230)

    println(part2(input))
}

fun part1(input: List<String>): Int {
    val size = input.size
    val length = input.first().length
    val msb = StringBuilder()
    val lsb = StringBuilder()
    for (n in 0 until length) {
        if (input.sumOf { it[n].toString().toInt() } > size / 2) {
            msb.append("1")
            lsb.append("0")
        } else {
            msb.append("0")
            lsb.append("1")
        }
    }
    return msb.toString().toInt(2) * lsb.toString().toInt(2)
}

fun part2(input: List<String>): Int {
    return countOxygenRate(input, 0, 1) * countOxygenRate(input, 0, 0)
}

fun countOxygenRate(input: List<String>, counter: Int, value: Int): Int {
    val size = input.size

    if (size <= 1) {
        return input[0].toInt(2)
    }

    return if (input.sumOf { it[counter].toString().toInt() } >= size / 2.0) {
        countOxygenRate(input.filter { it[counter].toString().toInt() == value }, counter + 1, value)
    } else {
        countOxygenRate(input.filter { it[counter].toString().toInt() != value }, counter + 1, value)
    }
}