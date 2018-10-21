package Lesson30.HW_IT_Company;


import java.util.ArrayList;
import java.util.LinkedList;

public class CustomerDAO extends Customer {

    public static ArrayList<Employee> emplByCustomerProjects = new ArrayList<>();
    public static ArrayList<Project> projByCustomer = new ArrayList<>();

    public void addCustom (Customer customer){
        LinkedList<Customer> customers = new LinkedList<>();
        customers.add(customer);

    }

    public void Custom (Customer customer){
        addCustom(customer);
    }

    //спиок проектов, выполняемых для заданого заказчика
    public static ArrayList<Project> projectsByCustomer(Customer customer){
        for (Project proj : ProjectDAO.projects ) {
            if (proj.getCustomer().equals(customer))
                projByCustomer.add(proj);
        }
        return projByCustomer;
    }

    //список сотрудников, учавствующих в проектах, выполняемых для заданого заказчика
    public static ArrayList<Employee> employeesByCustomerProjects(Customer customer){
        for (Employee empl : EmployeeDAO.employees ) {
            if (empl.getProjects().contains(customer))
                emplByCustomerProjects.add(empl);
        }
        return emplByCustomerProjects;
    }
}



