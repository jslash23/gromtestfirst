package Lesson30.HW_IT_Company;

import java.lang.reflect.Array;
import java.util.*;

public class EmployeeDAO {


    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Employee> emplByProject = new ArrayList<>();

    public static ArrayList<Employee> emplWithoutProjects = new ArrayList<>();
    public static ArrayList<Employee> emplWithoutProjectAll = new ArrayList<>();
    public static ArrayList<Employee> emplByLead = new ArrayList<>();
    public static ArrayList<Employee> emplByProjectEmployee = new ArrayList<>();

    public static ArrayList<Employee>  teamLeadsByEmpl = new ArrayList<>();



    public static ArrayList<Employee> addEmployee(Employee employee) {
        employees.add(employee);
        return employees;
    }

    public static ArrayList<Employee> employeesByProject(String projectName) {

        for (Employee empl : employees) {
            if (empl.getProjects().contains(projectName))
                emplByProject.add(empl);
        }
        return emplByProject;
    }


    //Список сотрудников из заданого отдела, не учавствующих не в одном проекте
    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        for (Employee empl : employees) {
            if (empl.getDepartment().getType().equals(departmentType) && empl.getProjects().isEmpty())
                emplWithoutProjects.add(empl);
        }
        return emplWithoutProjects;
    }

    public static ArrayList<Employee> employeesWithoutProject() {
        for (Employee empl : employees) {
            if (empl.getProjects().isEmpty())
                emplWithoutProjectAll.add(empl);
        }
        return emplWithoutProjectAll;
    }

   /* //Список подчиненных для заданого руководителя (по всем проектам, которыми он руководит )
    public static ArrayList<Employee> employessByTeamLead(Employee lead) {
        for (Employee empl : employees) {
            for (Project Proj : employees.
                 ) {
                
            }


        }
        return emplByLead;
    }*/

    //Список руководителей для заданого сотрудника (по всем проектам, в которых он участвует )
    public static ArrayList<Employee> teamLeadsByEmployee(Employee employee){
        for (Employee empl : employees) {
            if (ProjectDAO.projectsByEmployee(employee).equals(ProjectDAO.projAllempl)
                    && empl.getPosition().equals(employee.getPosition()) )
                teamLeadsByEmpl.add(empl);// empl у нас руководитель
    }
        return teamLeadsByEmpl;
    }

    //список сотрудников, участвующих в тех же проектах что и заданный сотрудник
    public static ArrayList<Employee> employeesByProjectEmployee(Employee employee){
        for (Employee empl: employees) {
            if (empl.getProjects().equals(employee.getProjects()))
                emplByProjectEmployee.add(empl);
        }

    return emplByProjectEmployee;
    }
}
