package ru.javarush.borets.module2.statistic;

import ru.javarush.borets.module2.entity.Alive;

import java.util.ArrayList;
import java.util.HashMap;

public class EntityCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public EntityCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object object) {
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

    private void printStatistic() {
        StringBuilder result = new StringBuilder("{");
        for (Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(",");
        }
        result.delete(result.length() - 1, result.length());
        result.append("}");
        System.out.println(result);
    }

    public static void getStatistic (ArrayList<? extends Alive> listOfAnimals) {
        EntityCounter count = new EntityCounter(Alive.class);
        for (Object alive : listOfAnimals) {
            if(!(alive ==null))
            count.count((Alive) alive);
        }
        count.printStatistic();
    }
}

