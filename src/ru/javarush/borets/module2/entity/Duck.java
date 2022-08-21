package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Duck extends Animal implements Flyable,Herbivores {
    double foodCount = START_FOOD_COUNT;

    public Duck() {
        super(6, 3, 1, true, "Duck");
    }


    @Override
    public Alive reproduce() {
        return new Duck();
    }

    @Override
    public String toString() {
        return view;
    }
}
