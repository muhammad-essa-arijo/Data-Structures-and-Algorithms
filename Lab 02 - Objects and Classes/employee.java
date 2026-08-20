/*
    Write a program by creating an 'Employee' class having the following methods
    and print the final salary.
        1 - 'getInfo()' which takes the salary, number of hours of work per day of
            employee as parameter
        2 - 'AddSal()' which adds $10 to salary of the employee if it is less than $500.
        3 - 'AddWork()' which adds $5 to salary of employee if the number of hours of
            work per day is more than 6 hours.
        4 – Create a print method to print salary and working hours.
*/

import java.util.Scanner;

public class employee {
    private float salary;
    private int hoursPerDay;

    public void getInfo(float salary, int hoursPerDay) {
        this.salary = salary;
        this.hoursPerDay = hoursPerDay;
    }

    public void AddSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    public void AddWork() {
        if (hoursPerDay > 6) {
            salary += 5;
        }
    }

    public void printInfo() {
        System.out.println("Salary: $" + salary);
        System.out.println("Hours per day: " + hoursPerDay);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");
        float salary = sc.nextFloat();

        System.out.print("Enter number of hours of work per day: ");
        int hoursPerDay = sc.nextInt();

        employee emp = new employee();
        emp.getInfo(salary, hoursPerDay);
        
        emp.AddSal();
        emp.AddWork();
        emp.printInfo();

        sc.close();
    }
}  
