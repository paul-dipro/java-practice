package collections;

public class Main {
    public static void main(String[] args) {

        // --- TEST 1: STACK FOR BACKEND SKILLS (STRINGS) ---
        System.out.println("=== Testing String Stack ===");
        GenericStack<String> skillStack = new GenericStack<>();

        // Pushing data onto the stack
        skillStack.push("Java Foundation");
        skillStack.push("Cloud Scaling");
        skillStack.push("Cybersecurity Protection");

        // Popping data out (Should print in reverse order: LIFO)
        while (!skillStack.isEmpty()) {
            String skill = skillStack.pop();
            System.out.println("Popped Skill: " + skill);
        }

        System.out.println();

        // --- TEST 2: STACK FOR NUMBERS (INTEGERS) ---
        System.out.println("=== Testing Integer Stack ===");
        GenericStack<Integer> numberStack = new GenericStack<>();

        numberStack.push(100);
        numberStack.push(200);
        numberStack.push(300);

        while (!numberStack.isEmpty()) {
            System.out.println("Popped Number: " + numberStack.pop());
        }
    }
}