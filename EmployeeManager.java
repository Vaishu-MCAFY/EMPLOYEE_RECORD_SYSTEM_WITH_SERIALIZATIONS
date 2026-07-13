import java.io.*;
import java.util.*;

public class EmployeeManager {

    private final String FILE_NAME = "employees.dat";
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = loadEmployees();
    }

    private ArrayList<Employee> loadEmployees() {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return new ArrayList<>();

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (ArrayList<Employee>) in.readObject();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveEmployees() {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(employees);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee emp) {

        employees.add(emp);
        saveEmployees();

        System.out.println("Employee Added Successfully.");
    }

    public void viewEmployees() {

        if (employees.isEmpty()) {

            System.out.println("No Employee Records.");
            return;
        }

        for (Employee e : employees)
            System.out.println(e);
    }

    public void searchEmployee(int id) {

        for (Employee e : employees) {

            if (e.getId() == id) {

                System.out.println(e);
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    public void updateEmployee(int id,
                               String name,
                               String dept,
                               double salary) {

        for (Employee e : employees) {

            if (e.getId() == id) {

                e.setName(name);
                e.setDepartment(dept);
                e.setSalary(salary);

                saveEmployees();

                System.out.println("Employee Updated Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    public void deleteEmployee(int id) {

        Iterator<Employee> itr = employees.iterator();

        while (itr.hasNext()) {

            Employee e = itr.next();

            if (e.getId() == id) {

                itr.remove();

                saveEmployees();

                System.out.println("Employee Deleted Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }
}