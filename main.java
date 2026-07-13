import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManager manager = new EmployeeManager();

        int choice;

        do {

            System.out.println("\n===== Employee Record System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department : ");
                    String dept = sc.nextLine();

                    System.out.print("Enter Salary : ");
                    double salary = sc.nextDouble();

                    manager.addEmployee(new Employee(id, name, dept, salary));

                    break;

                case 2:

                    manager.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter Employee ID : ");
                    manager.searchEmployee(sc.nextInt());

                    break;

                case 4:

                    System.out.print("Enter Employee ID : ");
                    int uid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name : ");
                    String uname = sc.nextLine();

                    System.out.print("Enter Department : ");
                    String udept = sc.nextLine();

                    System.out.print("Enter Salary : ");
                    double usalary = sc.nextDouble();

                    manager.updateEmployee(uid, uname, udept, usalary);

                    break;

                case 5:

                    System.out.print("Enter Employee ID : ");
                    manager.deleteEmployee(sc.nextInt());

                    break;

                case 6:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}