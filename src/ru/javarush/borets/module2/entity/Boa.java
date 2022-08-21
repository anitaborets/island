package ru.javarush.borets.module2.entity;

import lombok.Getter;

@Getter

public class Boa extends Animal implements Predator {
    double foodCount = START_FOOD_COUNT;

    public Boa() {
        super(15, 1, 3, true, "Boa");
    }

       @Override
    public Alive reproduce() {
        return new Boa();
    }

    @Override
    public String toString() {
        return view;
    }

}
