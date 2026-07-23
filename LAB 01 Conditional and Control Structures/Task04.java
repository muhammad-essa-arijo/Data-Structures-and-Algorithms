/*
Write a program to display first n terms of a Fibonacci series. 
Sample Output:  
            Input number of terms to display: 10
            Fibonacci Series: 1 1 2 3 5 8 13 21 34
            
✓ Each number of Fibonacci Series is the sum of the previous two numbers. 
*/

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;
        System.out.print("Enter the number of terms to be displayed: ");
        n = input.nextInt();

        int BeforePreviousTerm = 0; // first
        int PreviousTerm = 1;       // 2nd
        int nextTerm = BeforePreviousTerm + PreviousTerm; // 3rd

        System.out.print("1,");
        for(int i = 1; i <= n; i++){
            System.out.print(nextTerm + ",");
            BeforePreviousTerm = PreviousTerm;
            PreviousTerm = nextTerm;
            nextTerm = BeforePreviousTerm + PreviousTerm;
        }

        input.close();
    }
}
