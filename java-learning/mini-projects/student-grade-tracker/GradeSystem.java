public class GradeSystem {

    public String getGrade(double marks) {

        if (marks >= 400) {
            return "A+";
        }
        else if (marks >= 300) {
            return "A";
        }
        else if (marks >= 225) {
            return "B";
        }
        else if (marks >= 150) {
            return "C";
        }
        else {
            return "F";
        }
    }
}