package Oppgave1til3;

import java.util.Arrays;

/**
 * This class is not intended to be delivered on the exam.
 * It is just for testing purposes.
 * Remember to test your code to see if your code works as intended.
 **/
public class Main {
    public static void main(String[] args) {
        String[] strings = {"eksamen", null, "DAPE1400", "høsten", "2024"};
        Program p = new Program();
        // Testing assignment 1
        p.investigateStringArray(strings);
        // Testing assignment 2
        p.simpleMenu();
        // Testing assignment 3
        System.out.println(Program.reverse(new char[]{'a', 'b', 'c', 'a', 'b', 'c'}));
        System.out.println("Expecting empty array...");
        System.out.println(Program.reverse(new char[]{}));
        System.out.println("Was it empty?");
    }
}