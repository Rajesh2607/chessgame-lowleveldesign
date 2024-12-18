public class Account {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    public Account(String username, String password, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
}
