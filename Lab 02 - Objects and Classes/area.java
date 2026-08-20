/*
    Write a program to print the area of a rectangle by creating a class named 'Area'
    having two methods. First method named as 'setDimentions' takes length and
    breadth of rectangle as parameters and the second method named as 'getArea'
    returns the area of the rectangle. Length and breadth of rectangle must be
    entered through keyboard.
*/

import java.util.Scanner;

public class area{
    private float length;
    private float breadth;

    private void setDimentions(float length, float breadth){
            this.length = length;
            this.breadth = breadth;
        }
    public float getArea(){
        return length * breadth;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length: ");
        float length = sc.nextFloat();

        System.out.print("Enter breadth: ");
        float breadth = sc.nextFloat();

        area a = new area();

        a.setDimentions(length, breadth);
        System.out.println("Area of rectangle: " + a.getArea());
        
        sc.close();
    }
}