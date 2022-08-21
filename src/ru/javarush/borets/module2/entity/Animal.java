package ru.javarush.borets.module2.entity;

import lombok.EqualsAndHashCode;
import lombok.Setter;
@Setter

@EqualsAndHashCode(callSuper = true)
public abstract class Animal extends Alive implements Activity {
    public static final int START_FOOD_COUNT = 1;
    public boolean isAte = false;

    double weight;
    int speed;
    double amountOfFood;
    boolean eaten;
    String view;
    double foodCount = START_FOOD_COUNT;

    public Animal(double weight, int speed, double amountOfFood, boolean eaten, String view) {
        this.weight = weight;
        this.speed = speed;
        this.amountOfFood = amountOfFood;
        this.eaten = eaten;
        this.view = view;
    }

    public Animal() {
    }

    public double getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    public double getAmountOfFood() {
        return amountOfFood;
    }

    public boolean isEaten() {
        return eaten;
    }

    public String getName() {
        return view;
    }

    public double getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(double foodCount) {
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        return this.getName() + " speed: " + this.getSpeed() + " weight: " + this.getWeight()
                + " amountOfFood: " + this.getAmountOfFood() + " isEaten: " + this.isEaten();
    }
}
