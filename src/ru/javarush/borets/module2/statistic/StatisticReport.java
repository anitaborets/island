package ru.javarush.borets.module2.statistic;

import ru.javarush.borets.module2.Entities;
import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Herbivores;
import ru.javarush.borets.module2.entity.Predator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static ru.javarush.borets.module2.Main.finalReport;

public class StatisticReport {

    public void printInfoAboutLifeDay(StringBuilder report) {
        System.out.println(report);
    }

    public void countEntities(ArrayList<Alive> dayListOfAnimals) {
        int countPredator = 0;
        int countHerbivores = 0;

        for (Alive alive : dayListOfAnimals) {
            if (alive instanceof Herbivores)
                countHerbivores++;
            else if (alive instanceof Predator)
                countPredator++;
        }
        finalReport.append("Count of predators was: ").append(countPredator).append(" and Herbivores: ").append(countHerbivores).append("\n");
    }

    public void startReport(ArrayList<Alive> listOfAnimals) {
        finalReport.append("Totally started life on the island: ").append(listOfAnimals.size())
                .append("\n").append("They were: ").append("\n").append(EntityCounter.getStatistic(listOfAnimals)).append("\n");
        countEntities(listOfAnimals);
    }

    public void finishReport(HashMap<Class<?>, Integer> finalMap, ArrayList<Alive> listOfAnimals) {
        finalReport.append("At least, remained on the island: ").append(listOfAnimals.size())
                .append("\n").append("They were: ").append("\n").append(EntityCounter.getStatistic(listOfAnimals)).append("\n");
        countEntities(listOfAnimals);

        Map.Entry<Class<?>, Integer> minEntry = finalMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElse(null);

        Map.Entry<Class<?>, Integer> maxEntry = finalMap.entrySet().stream()
                .filter(e -> !e.getKey().getSimpleName().equals("Alive"))
                .filter(e -> !e.getKey().getSimpleName().equals("Animal"))
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        assert maxEntry != null;
        finalReport.append("We have the most: ").append(maxEntry.getKey().getSimpleName()).append("=").append(maxEntry.getValue());
        assert minEntry != null;
        finalReport.append(" and the least: ").append(minEntry.getKey().getSimpleName()).append("=").append(minEntry.getValue()).append("\n");
    }

    public void whoIsDied(HashMap<Class<?>, Integer> finalMap) {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry entry : finalMap.entrySet()) {
            list.add(entry.getKey().toString().substring(40).toLowerCase(Locale.ROOT));        }

        finalReport.append("These entities are completely extinct: ");
        for (Entities entity : Entities.values()) {
            if (!list.contains(entity.toString().toLowerCase(Locale.ROOT))) {
                finalReport.append(entity).append(", ");
            }
        }
    }
    public String printEntityCounter(EntityCounter counter)  {
        StringBuilder result = new StringBuilder("{");

        for (Map.Entry<Class<?>, Integer> pair : counter.entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(",");
        }
        result.delete(result.length() - 1, result.length());
        result.append("}");
        return result.toString();
    }
}


