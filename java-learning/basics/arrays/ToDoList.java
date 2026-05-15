import java.util.ArrayList;

public class ToDoList {

    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();

        String toDo1 = "Workout";
        String toDo2 = "Code";
        String toDo3 = "Eat";
        String toDo4 = "Sleep";

        toDoList.add(toDo1);
        toDoList.add(toDo2);
        toDoList.add(toDo3);
        toDoList.add(toDo4);

        System.out.println(toDoList.size());
        System.out.println(toDoList.get(2));
        System.out.println(toDoList.indexOf("Workout"));

        toDoList.set(2, "create-projects");

        toDoList.remove(3);
    }

}