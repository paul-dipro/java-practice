public abstract class User implements Authenticatable {

    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) {

        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public abstract void displayDashboard();
}