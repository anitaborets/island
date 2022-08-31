package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pig extends Animal implements Herbivores, Predator {

    public Pig() {
        super(400, 2, 50, true, "Pig");
    }

    @Override
    public String toString() {
        return getName();
    }
}
