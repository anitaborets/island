package ru.javarush.borets.module2.entity;

import ru.javarush.borets.module2.Entities;

import java.util.HashMap;

public class Edibility {
    //static final HashMap<String, Integer> edibility = new HashMap<>();

    public static final HashMap<String, HashMap<String, Integer>> edibility = new HashMap<>();

    public static HashMap<String, HashMap<String, Integer>> putEdibility() {

        HashMap<String, Integer> wolfMap = new HashMap<>();
        wolfMap.put(Entities.HORSE.name(), 10);
        wolfMap.put(Entities.DEER.name(), 15);
        wolfMap.put(Entities.RABBIT.name(), 60);
        wolfMap.put(Entities.MOUSE.name(), 80);
        wolfMap.put(Entities.GOAT.name(), 60);
        wolfMap.put(Entities.SHEEP.name(), 70);
        wolfMap.put(Entities.BUFFALO.name(), 10);
        wolfMap.put(Entities.PIG.name(), 15);
        wolfMap.put(Entities.DUCK.name(), 40);
        edibility.put(Entities.WOLF.name(), wolfMap);

        HashMap<String, Integer> boaMap = new HashMap<>();
        boaMap.put(Entities.FOX.name(), 15);
        boaMap.put(Entities.RABBIT.name(), 20);
        boaMap.put(Entities.MOUSE.name(), 40);
        boaMap.put(Entities.DUCK.name(), 10);
        edibility.put(Entities.BOA.name(), boaMap);

        HashMap<String, Integer> foxMap = new HashMap<>();
        foxMap.put(Entities.RABBIT.name(), 70);
        foxMap.put(Entities.MOUSE.name(), 90);
        foxMap.put(Entities.DUCK.name(), 60);
        foxMap.put(Entities.CATERPILLAR.name(), 40);
        edibility.put(Entities.FOX.name(), foxMap);

        HashMap<String, Integer> bearMap = new HashMap<>();
        bearMap.put(Entities.BOA.name(), 80);
        bearMap.put(Entities.HORSE.name(), 40);
        bearMap.put(Entities.DEER.name(), 80);
        bearMap.put(Entities.RABBIT.name(), 80);
        bearMap.put(Entities.MOUSE.name(), 90);
        bearMap.put(Entities.GOAT.name(), 70);
        bearMap.put(Entities.SHEEP.name(), 70);
        bearMap.put(Entities.BUFFALO.name(), 20);
        bearMap.put(Entities.PIG.name(), 50);
        bearMap.put(Entities.DUCK.name(), 10);
        edibility.put(Entities.BEAR.name(), bearMap);

        HashMap<String, Integer> eagleMap = new HashMap<>();
        eagleMap.put(Entities.FOX.name(), 10);
        eagleMap.put(Entities.RABBIT.name(), 90);
        eagleMap.put(Entities.MOUSE.name(), 90);
        eagleMap.put(Entities.DUCK.name(), 80);
        edibility.put(Entities.EAGLE.name(), eagleMap);
        return edibility;
    }


    //static final EnumMap<Entities, List<String>> edibility = new EnumMap<Entities, List<String>>(Entities.class);

    //public static EnumMap<Entities, List<String>> getEdibility() {
    //   edibility.put(Entities.WOLF, Arrays.asList(Entities.HORSE.name(),Entities.DEER.name()));
    //return edibility;
    // }
}
