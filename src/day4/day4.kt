package day4

private var INPUT_LOWER = 372304
private var INPUT_UPPER = 847060

fun checkIntPart1(check: Int): Boolean {
    var isValid = true
    val checkStr = check.toString()
    // Length is 6, has duplicates, is sorted
    isValid = isValid && checkStr.length == 6
    isValid = isValid && checkStr.toCharArray().distinct().size != 6
    isValid = isValid && checkStr.toCharArray().sorted() == checkStr.toList()
    return isValid
}

fun checkIntPart2(check: Int): Boolean {
    var isValid = true
    val checkStr = check.toString()
    // Length is 6, has at least one pair, is sorted
    isValid = isValid && checkStr.length == 6
    isValid = isValid && checkStr.toCharArray().sorted() == checkStr.toList()
    isValid = isValid && checkStr.groupingBy { it }.eachCount().any { it.value == 2 }
    return isValid
}

fun solveDay4() {
    // Part 1
    val answer1 = IntRange(INPUT_LOWER, INPUT_UPPER)
        .filter { checkIntPart1(it) }
        .count()
    println(String.format("Part 1: Total number of valid passwords between %d and %d is %d ", INPUT_LOWER, INPUT_UPPER, answer1))

    // Part 2
    val answer2 = IntRange(INPUT_LOWER, INPUT_UPPER)
        .filter { checkIntPart2(it) }
        .count()
    println(String.format("Part 2: Total number of valid passwords between %d and %d is %d ", INPUT_LOWER, INPUT_UPPER, answer2))


}