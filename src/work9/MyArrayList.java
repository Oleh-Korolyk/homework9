package work9;

import work9.fruits.Apple;
import work9.fruits.Orang;
import work9.fruits.Pear;

import java.util.Arrays;

public class MyArrayList<E> {

     private static Object[] objects = new Object[0];


    public void add(E value) {

       objects = Arrays.copyOf(objects, objects.length + 1);
       objects[objects.length - 1] = value;
    }

    public void remove(int index) {

        if (index >= 0 && index < objects.length) {
            for (int i = index; i < objects.length - 1; i++) {
                objects[i] = objects[i + 1];
            }
            objects = Arrays.copyOf(objects, objects.length - 1);;
        }
    }

    public void clear() {

        for (int i = 0; i < objects.length; i++) {
            objects[i] = null;
        }

    }

    public int size() {
        return objects.length;
    }

    public Object get(int index) {
        return objects[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(objects);
    }

    public static void main(String[] args) {

        MyArrayList<String>  myListString = new  MyArrayList();
        MyArrayList<Integer>  myListInt = new  MyArrayList();
        MyArrayList<Character>  myListChar = new  MyArrayList();
        MyArrayList<Pear>  myListPear = new  MyArrayList();
        MyArrayList<Apple>  myListApple = new  MyArrayList();


        myListInt.add(2);
        myListString.add("Vlad");
        myListChar.add('&');
        myListPear.add(new Pear());
        myListApple.add(new Apple());
        myListString.add("Stepan");
        myListString.add("Pavlo");

        System.out.println(myListApple.get(0));
        System.out.println(myListString.get(args.length));
        System.out.println(myListInt.size());
        System.out.println(myListString);

        myListApple.remove(2);

        System.out.println(myListApple.size());
        System.out.println(myListApple);

        myListApple.clear();

        System.out.println(myListApple.size());
        System.out.println(myListApple);

        myListApple.clear();
    }

}

