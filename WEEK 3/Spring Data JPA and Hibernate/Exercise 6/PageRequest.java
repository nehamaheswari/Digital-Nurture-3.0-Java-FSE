import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

// Example method with sorting
public Page<Employee> getEmployeesByName(String name, int page, int size, String sortBy, String sortDirection) {
    Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
    Pageable pageable = PageRequest.of(page, size, sort);
    return employeeRepository.findByName(name, pageable);
}
