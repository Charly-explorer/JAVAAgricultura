package Model.Workers;

/**
 *
 * @author carlo
 */
public class WorkersDTO {
    private final int id;
    private final String idCard;
    private final String name;
    private final String lastName1;
    private final String lastName2;
    private final String telephone;
    private final String email;
    private final String position;
    private final String schedule;
    private final double salary;

    public int getId() {
        return id;
    }

  

    public String getIdCard() {
        return idCard;
    }

    public String getName() {
        return name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getPosition() {
        return position;
    }

    public String getSchedule() {
        return schedule;
    }

    public double getSalary() {
        return salary;
    }

    public WorkersDTO(int id, String idCard, String name, String lastName1, String lastName2, String telephone, String email, String position, String schedule, double salary) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.telephone = telephone;
        this.email = email;
        this.position = position;
        this.schedule = schedule;
        this.salary = salary;
    }

   
    
    
    
} 
