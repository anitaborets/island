package ru.javarush.borets.module2.entity;

import lombok.Getter;
import ru.javarush.borets.module2.Entities;

@Getter
public class Horse extends Animal implements Herbivores {
    double foodCount = START_FOOD_COUNT;
    public static final String name = String.valueOf(Entities.HORSE);

    public Horse() {
        super(400, 4, 60, true, "Horse");
    }


    @Override
    public Alive reproduce() {
        return new Horse();
    }

    @Override
    public String toString() {
        return view;
    }
}
