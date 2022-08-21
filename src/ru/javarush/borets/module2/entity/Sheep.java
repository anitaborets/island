package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sheep extends Animal implements Herbivores {
    double foodCount = START_FOOD_COUNT;

    public Sheep() {
        super(70, 3, 15, true, "Sheep");
    }

    @Override
    public Alive reproduce() {
        return new Sheep();
    }

    @Override
    public String toString() {
        return view;
    }
}
