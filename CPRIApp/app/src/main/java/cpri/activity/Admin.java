package cpri.activity;

/**
 * Created by manisha on 1/2/2018.
 */

public class Admin {
    private String name, role, country;
    private int image;

    public Admin() {
    }

    public Admin(String name, String role, int image) {
        this.name = name;
        this.role = role;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
