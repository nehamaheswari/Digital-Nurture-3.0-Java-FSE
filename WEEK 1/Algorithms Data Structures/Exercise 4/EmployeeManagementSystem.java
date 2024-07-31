class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    Employee[] employees;
    int count;

    EmployeeManagementSystem(int size) {
        employees = new Employee[size];
        count = 0;
    }

    void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Array is full");
        }
    }

    Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    void displayEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].employeeId + " " + employees[i].name + " " + employees[i].position + " " + employees[i].salary);
        }
    }

    void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift elements to the left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem(5);

        // Add some employees
        system.addEmployee(new Employee(1, "John Doe", "Manager", 50000));
        system.addEmployee(new Employee(2, "Jane Smith", "Developer", 45000));
        system.addEmployee(new Employee(3, "Bob Johnson", "Designer", 40000));

        // Search for an employee
        Employee foundEmployee = system.searchEmployee(2);
        if (foundEmployee != null) {
            System.out.println("Found employee: " + foundEmployee.name);
        } else {
            System.out.println("Employee not found");
        }

        // Display all employees
        system.displayEmployees();

        // Delete an employee
        system.deleteEmployee(2);

        // Display employees after deletion
        system.displayEmployees();
    }
}
