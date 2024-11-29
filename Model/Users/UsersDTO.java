package Model.Users;

/**
 *
 * @author carlo
 */
public class UsersDTO {
  private final int id;
  private final String name;
  private final String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UsersDTO(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

 

    
}
