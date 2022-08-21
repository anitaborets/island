package ru.javarush.borets.module2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
public class Plant extends Alive {
    private final double weight = 1;
    private final String view = "\u2618";
    private final boolean eaten = true;

    @Override
    public Alive reproduce() {
        return new Plant();
    }

    @Override
    public String toString() {
        return view;
    }
}
