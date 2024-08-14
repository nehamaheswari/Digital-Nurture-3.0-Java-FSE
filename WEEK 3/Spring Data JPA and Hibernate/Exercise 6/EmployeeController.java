import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/searchByName")
    public Page<Employee> searchByName(@RequestParam String name, Pageable pageable) {
        return employeeService.getEmployeesByName(name, pageable.getPageNumber(), pageable.getPageSize());
    }

    @GetMapping("/searchByDepartment")
    public Page<Employee> searchByDepartment(@RequestParam String department, Pageable pageable) {
        return employeeService.getEmployeesByDepartment(department, pageable.getPageNumber(), pageable.getPageSize());
    }

    @GetMapping("/searchByNameContaining")
    public Page<Employee> searchByNameContaining(@RequestParam String substring, Pageable pageable) {
        return employeeService.getEmployeesByNameContaining(substring, pageable.getPageNumber(), pageable.getPageSize());
    }

    @GetMapping("/searchByNameStartingWith")
    public Page<Employee> searchByNameStartingWith(@RequestParam String prefix, Pageable pageable) {
        return employeeService.getEmployeesByNameStartingWith(prefix, pageable.getPageNumber(), pageable.getPageSize());
    }
}
