package com.javarush.test.level08.lesson11.home02;

import java.util.*;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное
с новой строки
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        for (int i = 0; i < 4; i++) {
            Cat cat = new Cat();
            result.add(cat);
        }

        return result;
    }

    public static Set<Dog> createDogs() {
        HashSet<Dog> result = new HashSet<Dog>();
        for (int i = 0; i < 3; i++) {
            Dog dog = new Dog();
            result.add(dog);
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        HashSet<Object> joinSet = new HashSet<>();
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext()) {
            joinSet.add(iterator.next());
        }
        Iterator<Dog> iterator1 = dogs.iterator();
        while (iterator1.hasNext()) {
            joinSet.add(iterator1.next());
        }

        return joinSet;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator<Cat> iterator = cats.iterator();
        HashSet<Object> copy = new HashSet<>(pets);


        while (iterator.hasNext()) {
            Object nextCat = iterator.next();
            Iterator<Object> iterator1 = copy.iterator();
            while (iterator1.hasNext()) {

                Object nextPet = iterator1.next();
                if (nextCat.equals(nextPet)) {
                    pets.remove(nextCat);
                }
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static class Dog {

    }

    public static class Cat {

    }
}
