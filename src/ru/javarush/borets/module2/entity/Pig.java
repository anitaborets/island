package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pig extends Animal implements Herbivores {

    public Pig() {
        super(400, 2, 50, true, "Pig");
    }

    @Override
    public Alive reproduce() {
        return new Pig();
    }

    @Override
    public String toString() {
        return view;
    }
}
