import java.util.ArrayList;

public class ToDoList {

    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>();

        String toDo1 = "gym";
        String toDo2 = "pushups";
        String toDo3 = "pullups";
        String toDo4 = "plank";

        toDoList.add(toDo1);
        toDoList.add(toDo2);
        toDoList.add(toDo3);
        toDoList.add(toDo4);

        System.out.println(toDoList.size());
        System.out.println(toDoList.get(2));
        System.out.println(toDoList.indexOf("gym"));

        toDoList.set(2, "biceps-curls");

        toDoList.remove(3);
    }

}