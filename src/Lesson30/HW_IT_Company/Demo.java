package Lesson30.HW_IT_Company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

         Customer customer = new Customer("John","Egipt",1250);
          Customer customer1 = new Customer("Bob","USA",2570);

          Project project = new Project("Viber",customer1);
          Project project1 = new Project("Viber",customer);
          Project project2 = new Project("Viberius",customer);

          Department programingDepartment = new Department(
                  DepartmentType.PROGRAMMING_DEP,EmployeeDAO.employees);

         ArrayList <Department> departments = new ArrayList<>();

        ArrayList<Project> projects = new ArrayList<>();
        projects.add(project);
        projects.add(project1);
        projects.add(project2);
        System.out.println("input projects" + projects);

        System.out.println(Controller.Projectadd(project1));

     Employee employee1 = new Employee("Max","Dmitriev"
            ,new Date(),PositionType.TEAM_LEAD, programingDepartment,
             ProjectDAO.projects);

        System.out.println("AddEmployees " + Controller.AddEmployees(employee1));
        System.out.println("EmployeesByProject " + Controller.EmployeesByProject("Viber"));
        System.out.println("projectsByEmployee " + Controller.projByEmployee(employee1));
        System.out.println("employeesByDepartmentWithoutProjects " + Controller.employeesByDepartmentWithoutProj(DepartmentType.PROGRAMMING_DEP));
        System.out.println("employeesWithoutProjects " + Controller.employeesWithoutProj());
        System.out.println("teamLeadsByEmployee " + Controller.teamLeadsByEmpl(employee1));
        System.out.println("emloyeesByProjEmployee " + Controller.emloyeesByProjEmployee(employee1));
        System.out.println("projectsByCustomer " + Controller.projsByCustomer(customer1));
        System.out.println("employeesByCustomerProjects " + Controller.employeesByCustomerProjs(customer));
    }
}
