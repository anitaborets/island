package ru.javarush.borets.module2;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public interface ValidatorInputConfiguration {

    static int validateInputIslandParametres() {
        int input = 0;
        try {
            input = Integer.parseInt(Dialog.keyboard.nextLine().trim());
            if (input < 1 || input > 10) {
                System.out.println(colorize("Please input positive number from 1 to 10", Attribute.RED_TEXT(), Attribute.BOLD()));
                validateInputIslandParametres();
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("It is not number", Attribute.RED_TEXT(), Attribute.BOLD()));
            System.out.println(colorize("Please input positive number from 1 to 10", Attribute.RED_TEXT(), Attribute.BOLD()));
            validateInputIslandParametres();
        }
        return input;
    }

    static int validateInputSimulationDays() {
        int input = 0;
        try {
            input = Integer.parseInt(Dialog.keyboard.nextLine().trim());
            if (input < 2 || input > 31) {
                System.out.println(colorize("Please input positive number from 2 to 31", Attribute.RED_TEXT(), Attribute.BOLD()));
                validateInputIslandParametres();
            }
        } catch (NumberFormatException e) {
            System.out.println(colorize("It is not number", Attribute.RED_TEXT(), Attribute.BOLD()));
            System.out.println(colorize("Please input positive number from 2 to 31", Attribute.RED_TEXT(), Attribute.BOLD()));
            validateInputIslandParametres();
        }
        return input;
    }
}
