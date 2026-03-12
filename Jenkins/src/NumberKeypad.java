import java.util.ArrayList;
import java.util.List;

public class NumberKeypad {
    static void run() {
        String str = "24";
        List<String> result = solve(str);
        System.out.println(result);
    }

    public static List<String> solve(String str) {
        String[] mapper = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        List<String> result = new ArrayList<>();
        backtrack(str, mapper, 0, new StringBuilder(), result);
        return result;
    }

    public static void backtrack(String str, String[] mapper, int index, StringBuilder current, List<String> result) {
        if(index == str.length()) {
            result.add(current.toString());
            return;
        }

        String letters = mapper[str.charAt(index) - '0'];
        for(char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(str, mapper, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }

    }

}
