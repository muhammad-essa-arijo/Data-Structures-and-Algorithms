/*
Develop java code that prints following. 

             *               1                   *
          * * *             232                  **
       * * * * *           34543                 ***
    * * * * * * *         4567654                ****
 * * * * * * * * *       567898765               *****
*/

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of rows: ");
        n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        input.close();
    }
}
