package ru.javarush.borets.module2.factory;

import ru.javarush.borets.module2.Entities;

import java.util.HashMap;

public class MaxQuantity {
    public static  HashMap<Entities,Integer> maxQuantity = new HashMap<>();

    public static HashMap<Entities,Integer> putMaxQuantity(){
        maxQuantity.put(Entities.BEAR,5);
        maxQuantity.put(Entities.BOA,30);
        maxQuantity.put(Entities.BUFFALO,10);
        maxQuantity.put(Entities.CATERPILLAR,1000);
        maxQuantity.put(Entities.DEER,20);
        maxQuantity.put(Entities.DUCK,200);
        maxQuantity.put(Entities.EAGLE,20);
        maxQuantity.put(Entities.FOX,30);
        maxQuantity.put(Entities.GOAT,140);
        maxQuantity.put(Entities.HORSE,20);
        maxQuantity.put(Entities.MOUSE,500);
        maxQuantity.put(Entities.PIG,50);
        maxQuantity.put(Entities.PLANT,200);
        maxQuantity.put(Entities.RABBIT,150);
        maxQuantity.put(Entities.SHEEP,140);
        maxQuantity.put(Entities.WOLF,30);
        return maxQuantity;
    }

}
