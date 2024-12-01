package Model.Workers;

import java.util.regex.Pattern;

/**
 *
 * @author carlo
 */
public class Workers {
    private String idCard;
    private String name;
    private String lastName1;
    private String lastName2;
    private String telephone;
    private String email;
    private String position;
    private String schedule;
    private double salary;

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

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Workers(String idCard, String name, String lastName1, String lastName2, String telephone, String email, String position, String schedule, double salary) {
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
      public boolean validarCorreo(String email){
       if(email==null) return false;
       String formato="^[a-zA-Z0-9+&-]+(?:\\.[a-zA-Z0-9+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
       return Pattern.compile(formato).matcher(email).matches();
    }
      public boolean validarTelefono(String telephone){
        if(telephone==null) return false;
        String format= "^\\d{8}$";
        return Pattern.compile(format).matcher(telephone).matches();
    }
}
