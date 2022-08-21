package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rabbit extends Animal implements Herbivores  {
    double foodCount = START_FOOD_COUNT;

    public Rabbit() {
        super(2, 2, 0.45, true, "Rabbit");
    }

     @Override
    public Alive reproduce() {
        return new Rabbit();
    }

    @Override
    public String toString() {
        return view;
    }
}
