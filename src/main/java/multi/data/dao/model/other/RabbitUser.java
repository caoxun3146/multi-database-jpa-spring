package multi.data.dao.model.other;

import java.io.Serializable;

public class RabbitUser implements Serializable {

    private static final long serialVersionUID=1L;

    String name;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RabbitUser() {
    }

    public RabbitUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "RabbitUser{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
