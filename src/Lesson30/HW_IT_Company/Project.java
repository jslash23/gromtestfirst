package Lesson30.HW_IT_Company;


public class Project /*implements Comparable<Project> */{
    private  String name;
    private Customer customer;

    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    /* @Override
    public int compareTo(Project pr) {
        return pr.name.compareTo(this.name);
    }*/

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }
}
