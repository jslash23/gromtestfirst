package Lesson30.HW_IT_Company;


import java.util.Collection;
import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired; //дата когда сотрудник был нанят
    private PositionType position;
    private Department department;
    private Collection projects;

    public Employee( String firstName, String lastName, Date dateHired, PositionType position, Department department, Collection projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public PositionType getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public Collection getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", department=" + department +
                ", projects=" + projects +
                '}';
    }
}
