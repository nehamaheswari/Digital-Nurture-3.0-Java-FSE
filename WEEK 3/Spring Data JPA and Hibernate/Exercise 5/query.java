import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findEmployeesByName(@Param("name") String name);
    
    @Query("SELECT e FROM Employee e WHERE e.department = :department")
    List<Employee> findEmployeesByDepartment(@Param("department") String department);
    
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:substring%")
    List<Employee> findEmployeesByNameContaining(@Param("substring") String substring);
    
    @Query("SELECT e FROM Employee e WHERE e.name LIKE :prefix%")
    List<Employee> findEmployeesByNameStartingWith(@Param("prefix") String prefix);
}
