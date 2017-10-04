import java.lang.String;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CharacterCheck {
    public static void main(String[] args) {
        System.out.println("Enter the string: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase();
        Set<Character> set = new HashSet<Character>();
        try {
            for (char c : str.toCharArray()) {
                set.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        boolean charsPresent = true;
        for (char c = 'a'; c != 'z'; c++) {
            if (!set.contains(c)) {
                charsPresent = false;
                break;
            }
        }
        if (charsPresent && set.contains('z'))
            System.out.println("Contains all chars.");
        else
            System.out.println("oops!");
    }
}

// time complexity is O(n) where n is the length of the string
// space complexity is O(1) since we are using set of size not more than 26
