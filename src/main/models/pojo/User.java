package main.models.pojo;

/**
 * Created by admin on 19.04.2017.
 */
public class User {
    private Integer id_user;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private int limit;
    private boolean is_admin;

    public User(Integer id_user, String firstName, String lastName, String mail, String password, int limit, boolean is_admin) {
        this.id_user = id_user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.limit = limit;
        this.is_admin = is_admin;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
