package ru.job4j.menu;

import java.util.Scanner;

public class PrintMenu {
//    public static void main(String[] args) {
//        System.out.println(new PrintMenu().print(1, "S"));
//    }
    public String print(int number, String menuName) {
        Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                return number + ".";
            } else if (sc.hasNextLine()){
                menuName = sc.nextLine();
                return menuName;
            }
        return null;
    }
}
