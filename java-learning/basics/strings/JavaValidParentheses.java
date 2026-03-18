import java.util.*;

public class JavaValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {

                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }

            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        boolean result = isValid(s);
        System.out.println("Valid: " + result);
    }
}