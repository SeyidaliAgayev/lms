package com.div.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtil {
    public static int inputRequiredInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextInt();
    }

    public static String inputRequiredString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLine();
    }

    public static double inputRequiredDouble(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextDouble();
    }

    public static long inputRequiredLong(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        return scanner.nextLong();
    }

    public static LocalDate inputRequiredDate(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(title);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(input, formatter);
    }
}
