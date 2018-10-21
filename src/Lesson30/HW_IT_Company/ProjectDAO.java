package Lesson30.HW_IT_Company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class ProjectDAO {

    public static ArrayList<Project> projects = new ArrayList<>();
    public static ArrayList<Project> emplProjects = new ArrayList<>();
    public static ArrayList<Project> projAllempl = new ArrayList<>();


    public static ArrayList<Project> addProject(Project project) {
        projects.add(project);
        return projects;
    }

    public static ArrayList<Project> projectsByEmployee(Employee employee) {
        for (Employee empl : EmployeeDAO.employees) {
            if ((!empl.getProjects().isEmpty()) && (empl.equals(employee)))
                emplProjects.addAll(empl.getProjects());
        }
        return emplProjects;
    }

    public static ArrayList<Project> projectsAllEmpl(Employee employee) {
        for (Employee empl : EmployeeDAO.employees) {
            if ((!empl.getProjects().isEmpty()))
                projAllempl.addAll(empl.getProjects());
        }
        return projAllempl;
    }
}

