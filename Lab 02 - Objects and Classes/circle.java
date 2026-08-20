/*
    Write a program to print the area of circumference of circle by creating a class
    named 'Circle' which taking the radius as parameters in its constructor and
    having a method named 'Circumference' which returns the circumference of the
    circle. The formula for circumference of circle is:  2πr
*/

import java.util.Scanner;

public class circle {
    float radius;
    public circle(float radius) {
        this.radius = radius;
    }
    public float circumference() {
        return 2 * 3.14f * radius;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        float radius = sc.nextFloat();

        circle c = new circle(radius);
        System.out.println("Circumference of circle: " + c.circumference());
        
        sc.close();
    }
}
