import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private Long id;

    private String name;

    @Type(type = "org.hibernate.type.StringType")
    private String department;

    @Formula("(select count(*) from department where employee_id = id)")
    private int departmentEmployeeCount;

}
