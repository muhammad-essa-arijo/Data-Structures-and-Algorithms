/* 
    Develop a java program for calculating the total electricity bill when a user enters the number of units consumed. For the calculations of the total bill consider the following tariff:
    Number of Units	Price PER unit in Rupees

    Initial 50 units	10
    50-100	            15
    101-200         	20
    201-300	            25
    301-onwards     	30

*/

import java.util.Scanner;

public class Task01{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int units;
        System.out.print("Enter the number of units consumed: ");
        units = input.nextInt();

        // calculate price and display
        if(units <= 50 && units >= 0) System.out.print("Price: " + units*10);
        else if(units > 50 && units <= 100) System.out.print("Price: " + units*15);
        else if(units > 100 && units <= 200) System.out.print("Price: " + units*20);
        else if(units > 200 && units <= 300) System.out.print("Price: " + units*25);
        else if(units > 300) System.out.print("Price: " + units*30);
        else System.out.print("Invalid Input");

        input.close();
    }
}
