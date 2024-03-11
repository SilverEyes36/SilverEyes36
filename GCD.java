/*
Name: Rahja Hansbrough
Class: Cryptography CS 3626
Section: W01
 */
import java.util.*;
import java.math.*;
public class Main {
    public static int GCD(int x, int y){
        if(x < y && x != 0){ //This if statement will swap the values if x less than y, so it can use the Euclidean Algorithm
            int temp = x;
            x = y;
            y = temp;
        }
        int c = x % y; //Finds a remainder of the x & y value
        if(c > 0) {
            y = GCD(y, c); // This method uses recursion to repeat the process equation of a = qb + r
        }
        return y; // once there is no remainder the function will return the last y with no remainder.
    }
    public static void main(String[] args) {

        System.out.println("Answer1: " + GCD(0,15));// Q1
        System.out.println("Answer2: " + GCD(39,13));// Q2
        System.out.println("Answer3: " + GCD(31356,55576));// Q3
    }
}
