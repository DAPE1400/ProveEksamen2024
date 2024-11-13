package Oppgave1til3;

import java.util.Scanner;

public class Program {
    /**
     * This is the delivery on the exam - assignment 1.
     **/
    public void investigateStringArray(String[] strings) {
        int letters = 0;
        int nulls = 0;
        for (String s : strings) {
            if (s != null) {
                letters += s.length();
                if (s.contains("a")) {
                    System.out.println(s);
                }
            } else {
                nulls++;
            }
        }
        System.out.println("Total letters:" + letters);
        System.out.println("Total nulls:" + nulls);
    }

    /**
     * This is the delivery on the exam - assignment 2.
     * I could have used helper methods here, to make the method smaller, such as
     * - printing the menu.
     * - entering valid number
     **/
    public void simpleMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        String userHelp = "Vennligst velg et tall mellom 1 og 3";
        while (choice != 3) {
            System.out.println("Du har tre valg (1-3)");
            System.out.println("1: Motta dagens visdomsord");
            System.out.println("2: Se dagens værmelding");
            System.out.println("3: Avslutte programmet");
            boolean userHasEnteredValidNumber = false;
            while (!userHasEnteredValidNumber) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice > 0 && choice < 4) {
                        userHasEnteredValidNumber = true;
                    } else {
                        System.out.println(userHelp);
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println(userHelp);
                }
            }
            switch (choice) {
                case 1 -> displayWordOfWisdom();
                case 2 -> displayWeather();
                case 3 -> exitProgram();
                default -> System.out.println(userHelp);
            }
        }
    }

    /**
     * Not part of the delivery, but created to be able to compile project.
     **/
    private void exitProgram() {
        System.out.println("Bye!");
    }

    /**
     * Not part of the delivery, but created to be able to compile project.
     **/
    private void displayWeather() {
        System.out.println("Viser været");
    }

    /**
     * Not part of the delivery, but created to be able to compile project.
     **/
    private void displayWordOfWisdom() {
        System.out.println("Viser visdomsord");
    }

    /**
     * This is the delivery on the exam - assignment 3.
     */
    public static char[] reverse(char[] chars) {
        char[] charsToReturn = new char[chars.length];
        int index = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            charsToReturn[i] = chars[index];
            index--;
        }
        return charsToReturn;
    }
}
