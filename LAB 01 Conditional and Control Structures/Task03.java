/*
Write a java program that takes the table, starting and ending point of the table and prints 
the output in the following way: 

5x5 = 25
5x6 = 30
5x7 = 35
5x8 = 40
5x9 = 45
5x10 = 50
*/

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int table;
        System.out.print("Enter table number: ");
        table = input.nextInt();

        int start;
        System.out.print("Enter the starting number: ");
        start = input.nextInt();

        int end;
        System.out.print("Enter the ending number: ");
        end = input.nextInt();

        for (; start <= end; start++){
            System.out.println(table + "*" + start + " = " + (table * start));
        }

        input.close();
    }
}
