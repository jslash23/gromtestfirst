package Lesson30.HW_IT_Company;


import java.util.Collection;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    Collection  department;
    Collection customers;

    public Firm(Date dateFounded, Collection department, Collection customers) {
        this.dateFounded = dateFounded;
        this.department = department;
        this.customers = customers;
    }
}
