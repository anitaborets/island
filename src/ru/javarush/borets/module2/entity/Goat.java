package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Goat extends Animal implements Herbivores {
    double foodCount = START_FOOD_COUNT;

    public Goat() {
        super(60, 3, 10, true, "Goat");
    }


    @Override
    public Alive reproduce() {
        return new Goat();
    }

    @Override
    public String toString() {
        return view;
    }
}
