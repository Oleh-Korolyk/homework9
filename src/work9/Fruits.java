package work9;

import work9.fruits.*;

import java.util.Arrays;

public class Fruits {

    Orang orange = new Orang();
    Lemon lemon = new Lemon();
    Pear pear = new Pear();
    Apple apple = new Apple();
    Pineapple pineapple = new Pineapple();


    public Object[] getFruits() {

        Object[] frukt = {apple, pear, lemon, orange, pineapple};

        return frukt;
    }

    @Override
    public String toString() {
        return Arrays.toString(getFruits());
    }
}
