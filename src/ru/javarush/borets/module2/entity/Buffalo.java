package ru.javarush.borets.module2.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Buffalo extends Animal implements Herbivores {

    public Buffalo() {
        super(700, 3, 100, true, "Buffalo");
    }

    @Override
    public Alive reproduce() {
        return new Buffalo();
    }


    @Override
    public String toString() {
        return view;
    }
}


