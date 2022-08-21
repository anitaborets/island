package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle extends Animal implements Flyable,Predator {
    double foodCount = START_FOOD_COUNT;

    public Eagle() {
        super(6, 3, 1, false, "Eagle");
    }

    @Override
    public Alive reproduce() {
        return new Eagle();
    }

    @Override
    public String toString() {
        return view;
    }
}
