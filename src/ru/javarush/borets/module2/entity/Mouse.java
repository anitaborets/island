package ru.javarush.borets.module2.entity;

import lombok.Getter;

@Getter
public class Mouse extends Animal implements Herbivores  {
    double foodCount = START_FOOD_COUNT;

    public Mouse() {
        super(0.2, 2, 1, true, "Mouse");
    }


    @Override
    public Alive reproduce() {
        return new Mouse();
    }

    @Override
    public String toString() {
        return view;
    }
}
