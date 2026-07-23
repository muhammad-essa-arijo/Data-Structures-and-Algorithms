/*
Write a program that calculates the square of a number provided by the user without using 
any built-in function or the * operator. 
*/

import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num;
        System.out.print("Enter a number: ");
        num = input.nextInt();

        int square = 0;

        for (int i = 1; i <= num; i++) {
            square += num;
        }
        System.out.println("Square of " + num + " is: " + square);

        input.close();
    }
}
