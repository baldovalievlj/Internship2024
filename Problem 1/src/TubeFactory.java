/**
 * In a factory, different lengths of tubes are produced from one long tube. Each part of the tube is marked with letter
 * for the identifier.  Some parts of the tube are defected and need to be extracted. The defected parts are marked with a
 * faulty letter which can have different lengths.
 * We need to divide the tube the least number of times and extract the faulty pieces but leave the other parts intact.
 * The number of divisions should be printed at the end.
 *
 * Example
 * Tube: TAAABCAACASS
 * Faulty code: A
 * Output: 6
 * We divide the tube into T | AAA | BC | AA | C | A | SS, and we count each breaking of it (|), which in this case is 6.
 *
 * Example 2:
 * Tube: AAABAAAAAA
 * Faulty code: A
 * Output: 2
 * AAA | B | AAAAAA
 *
 */

import java.util.Scanner;

public class TubeFactory {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String[] input = scanner.nextLine().split("");
        final String code = scanner.nextLine();

        int counter = 0;
        Boolean inStreak = input[0].equals(code);

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(code) && !inStreak) {
                counter++;
                inStreak = true;
            } else if (!input[i].equals(code) && inStreak) {
                inStreak = false;
                counter++;
            }
        }
        System.out.println(counter);
    }
}