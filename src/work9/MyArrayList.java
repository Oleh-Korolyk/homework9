package work9;

import work9.fruits.Apple;
import work9.fruits.Orang;

import java.util.Arrays;

public class MyArrayList {

     Object[] fruits = new Fruits().getFruits();


    public void add(Object value) {

       fruits = Arrays.copyOf(fruits, fruits.length + 1);
       fruits[fruits.length - 1] = value;
    }

    public void remove(int index) {

        if (index >= 0 && index < fruits.length) {
            for (int i = index; i < fruits.length - 1; i++) {
                fruits[i] = fruits[i + 1];
            }
            fruits = Arrays.copyOf(fruits, fruits.length - 1);;
        }
    }

    public void clear() {

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = null;
        }

    }

    public int size() {
        return fruits.length;
    }

    public Object get(int index) {
        return fruits[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(fruits);
    }

    public static void main(String[] args) {

        MyArrayList  myList = new  MyArrayList();

        myList.add(2);
        myList.add("Vlad");
        myList.add('&');
        myList.add(new Orang());
        myList.add(new Apple());

        System.out.println(myList.get(0));
        System.out.println(myList.get(args.length));
        System.out.println(myList.size());
        System.out.println(myList);

        myList.remove(4);

        System.out.println(myList.size());
        System.out.println(myList);

        myList.clear();

        System.out.println(myList.size());
        System.out.println(myList);

        myList.clear();
    }

}

