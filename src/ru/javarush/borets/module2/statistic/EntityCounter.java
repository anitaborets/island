package ru.javarush.borets.module2.statistic;

import ru.javarush.borets.module2.entity.Alive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EntityCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public EntityCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public static String getStatistic(ArrayList<? extends Alive> listOfAnimals) {
        EntityCounter count = new EntityCounter(Alive.class);
        for (Object alive : listOfAnimals) {
            if (alive != null)
                count.count((Alive) alive);
        }
        return count.printStatistic();

    }

    public static HashMap<Class<?>, Integer> getStatisticForCalculation(ArrayList<? extends Alive> listOfAnimals) {
        EntityCounter count = new EntityCounter(Alive.class);
        for (Object alive : listOfAnimals) {
            if (alive != null)
                count.count((Alive) alive);
        }
        return count;

    }

    private void count(Object object) {
        Class<?> type = object.getClass();
        if (!baseType.isAssignableFrom(type))
            throw new RuntimeException(object + "wrong type " + type);
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass))
            countClass(superClass);
    }

    private String printStatistic() {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
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

