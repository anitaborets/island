package ru.javarush.borets.module2;

import com.diogonunes.jcolor.Attribute;
import ru.javarush.borets.module2.statistic.StatisticReport;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static com.diogonunes.jcolor.Ansi.colorize;
import static java.util.Map.entry;
import static ru.javarush.borets.module2.Constants.*;
import static ru.javarush.borets.module2.Main.daysOfLife;
import static ru.javarush.borets.module2.Main.finalReport;
import static ru.javarush.borets.module2.loading_from_external_sources.Configuration.appConfiguration;

public class Dialog {
    public static Scanner keyboard = new Scanner(System.in);
    public Map<String, Integer> configurationFromUser = Map.ofEntries(
            entry(WIDTH, 0),
            entry(HEIGHT, 0),
            entry(DAY_OF_LIFE, 0));

    public Map<String, Integer> startDialog() {
        System.out.println(colorize("WELCOME TO THE ISLAND!!!" + "\n", Attribute.GREEN_TEXT()));
        System.out.println(colorize("We will create an island with animals, and we will watch how the fittest survive. On our island will live: ", Attribute.BLUE_TEXT()));

        for (Entities entity : Entities.values()) {
            System.out.print(entity.toString().toLowerCase(Locale.ROOT) + ", ");
        }
        System.out.println("\n");

        System.out.println(colorize("By default, our island will have dimensions: ", Attribute.BRIGHT_MAGENTA_TEXT()));
        System.out.println("Island dimensions: " + appConfiguration.get("sizeX") + " wight and height: " + appConfiguration.get("sizeY"));
        System.out.println("Number of simulation days: " + appConfiguration.get("DAY_OF_LIFE"));
        System.out.println(colorize("Do you want to change this dimensions? Input 1 if you want.", Attribute.BRIGHT_MAGENTA_TEXT()));
        String choice = keyboard.nextLine();

        if (Objects.equals(choice, "1")) {
            System.out.println(colorize("Please input island width - positive number from 1 to 10", Attribute.BRIGHT_MAGENTA_TEXT()));
            int changeDimensions = ValidatorInputConfiguration.validateInputIslandParametres();
            configurationFromUser.put(WIDTH, changeDimensions);
            System.out.println(colorize("Please input island height - positive number from 1 to 10", Attribute.BRIGHT_MAGENTA_TEXT()));
            changeDimensions = ValidatorInputConfiguration.validateInputIslandParametres();
            configurationFromUser.put(HEIGHT, changeDimensions);

            System.out.println(colorize("Please input number of simulation days - positive number from 2 to 31", Attribute.BRIGHT_MAGENTA_TEXT()));
            changeDimensions = ValidatorInputConfiguration.validateInputSimulationDays();
            configurationFromUser.put(DAY_OF_LIFE, changeDimensions);

            System.out.println(colorize("Thank you! We are starting simulation with your dimensions.", Attribute.BRIGHT_MAGENTA_TEXT()));

        } else {
            System.out.println(colorize("We are starting simulation with default dimensions.", Attribute.BRIGHT_MAGENTA_TEXT()));
        }

        System.out.println((colorize("**********************************", Attribute.GREEN_BACK())));
        System.out.println((colorize("WE ARE STARTING!", Attribute.BRIGHT_GREEN_TEXT(), Attribute.BOLD())));
        System.out.println("\n");
        return configurationFromUser;
    }

    public void finishDialog() {
        StatisticReport report = new StatisticReport();
        System.out.println((colorize("**********************************", Attribute.GREEN_BACK())));
        System.out.println((colorize("The whole island lived " + daysOfLife + " days.", Attribute.BRIGHT_MAGENTA_TEXT())));
        report.printInfoAboutLifeDay(finalReport);
        System.out.println(colorize("That is life... Run again and see who will be the most tenacious!!!", Attribute.MAGENTA_TEXT(), Attribute.BOLD()));
    }
}
