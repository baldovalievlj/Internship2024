/**
 * In a factory, different lengths of tubes are produced from one long tube. Some parts of the tube are defected
 * and need to be extracted. Each part of the tube is marked with either a letter for the identifier or the faulty code.
 * We need to divide the tube the least number of times and extract the faulty pieces but leave the other parts intact.
 * The number of divisions should be printed at the end.
 *
 * Example
 * Tube: TAAABCAACASS
 * Faulty code: A
 * Output: 6
 *
 * We divide the tube into T, AAA, BC, AA, C, A, SS and we count each breaking of it, which in this case is 6.
 */

fun main(args: Array<String>) {
    val input = readln().uppercase().map { it.toString() }
    val divisor = readln().uppercase()

    var inStreak = input.first() == divisor

    val result = input.fold(0) { acc, it ->
        if (it == divisor && !inStreak) {
            inStreak = true
            acc + 1
        } else if (it != divisor && inStreak) {
            inStreak = false
            acc + 1
        } else {
            acc
        }
    }
    println(result)
}