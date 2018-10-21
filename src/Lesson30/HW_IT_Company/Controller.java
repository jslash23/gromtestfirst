package Lesson30.HW_IT_Company;


import java.util.ArrayList;
import java.util.Set;

public class Controller {



    public static ArrayList<Project> Projectadd(Project project ) {//Возвращаем тот объект
        // который сохранили
       return ProjectDAO.addProject(project);
    }

    public static ArrayList<Employee> EmployeesByProject(String projectName){
        return EmployeeDAO.employeesByProject(projectName);
    }

    public static ArrayList<Employee> AddEmployees(Employee employee){
        return EmployeeDAO.addEmployee(employee);
    }

    public static ArrayList<Project> projByEmployee(Employee employee) {
        return ProjectDAO.projectsByEmployee(employee);
    }

    public static ArrayList<Employee> teamLeadsByEmpl(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }

    public static ArrayList <Employee> employeesByDepartmentWithoutProj(DepartmentType departmentType){
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public static ArrayList<Employee> employeesWithoutProj(){
        return EmployeeDAO.employeesWithoutProject();
    }

    public static ArrayList<Employee> emloyeesByProjEmployee(Employee employee){
        return EmployeeDAO.employeesByProjectEmployee(employee);
    }

    public static ArrayList<Project> projsByCustomer(Customer customer){
        return CustomerDAO.projectsByCustomer(customer);
    }

    public static ArrayList<Employee> employeesByCustomerProjs(Customer customer){
        return CustomerDAO.employeesByCustomerProjects(customer);
    }



/*

 public static Transaction save(Transaction transaction ) throws Exception{//Возвращаем тот объект
        // который сохранили

        return transactionDAO.save(transaction);
    }
*/

}
