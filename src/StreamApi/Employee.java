package StreamApi;

import java.util.Date;

public class Employee {
    private Double salary;
    private Date dateOfJoining;
    private String gender;

    public Employee(){

    }

    public Employee(String name, Double salary, Date dateOfJoining, String gender) {
        this.name = name;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
        this.gender = gender;

    }

    private String name;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dateOfJoining=" + dateOfJoining +
                ", gender='" + gender + '\'' +
                '}';
    }
}
