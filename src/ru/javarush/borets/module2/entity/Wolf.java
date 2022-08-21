package ru.javarush.borets.module2.entity;

import lombok.Getter;
import ru.javarush.borets.module2.Entities;

@Getter
public class Wolf extends Animal implements Predator {
    double foodCount = START_FOOD_COUNT;
    public final String name = String.valueOf(Entities.WOLF);

    public Wolf() {
        super(50, 3, 8, false, "Wolf");
    }

    @Override
    public Alive reproduce() {
        return new Wolf();
    }

    @Override
    public String toString() {
        return view;
    }
}
