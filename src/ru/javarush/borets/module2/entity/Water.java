package ru.javarush.borets.module2.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
public class Water extends Alive {

    private final String view = "\u2652";

    @Override
    public String toString() {
        return view;
    }
}
