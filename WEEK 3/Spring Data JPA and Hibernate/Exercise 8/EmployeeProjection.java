import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    
    @Value("#{target.name + ' - ' + target.department}")
    String getEmployeeDetails();
}
