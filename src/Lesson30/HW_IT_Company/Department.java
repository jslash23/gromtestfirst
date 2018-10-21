package Lesson30.HW_IT_Company;

import java.util.Collection;

public class Department {
    private  DepartmentType type;
    private Collection emloyees;

    public Department(DepartmentType type, Collection emloyees) {
        this.type = type;
        this.emloyees = emloyees;
    }

    public DepartmentType getType() {
        return type;
    }

    public Collection getEmloyees() {
        return emloyees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (type != that.type) return false;
        return emloyees.equals(that.emloyees);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + emloyees.hashCode();
        return result;
    }
}
