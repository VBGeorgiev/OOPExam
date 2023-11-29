package com.oopexam.validate;

import java.util.Scanner;

public class ValidateCommands {
    public static boolean validateCommnands(String command) {
        if(command.equals("Add Employee") || command.equals("List employees")
                || command.equals("Save & Exit") || command.equals("List all employees")) {
            return true;
        } else if(command.matches("Edit [0-9]*")) {
            return true;
        } else if(command.matches("Search Id [0-9]*")) {
            return true;
        } else if(command.matches("Search Name [a-zA-z][a-zA-z\\s]*")) {
            return true;
        } else if(command.matches("Search Department [a-zA-z][a-zA-z\\s]*")) {
            return true;
        } else if(command.matches("Fire [0-9]*")) {
            return true;
        } else {
            return false;
        }

    }

    public static <T extends Number> T parseNum(T outType, String string, String userMessage, Scanner sc) {
        Number num = 0;
        boolean isInt = false;
        while(!isInt) {
            try{
                if(outType instanceof Integer) {
                    num = Integer.parseInt(string);
                    isInt = true;
                } else if (outType instanceof Double) {
                    num = Double.parseDouble(string);
                    isInt = true;
                } else {
                    throw new NumberFormatException("Wrong input");
                }

            } catch (NumberFormatException e) {
                System.out.println(userMessage);
                string = sc.nextLine();
            }

        }

        return (T) num;

    }

}
