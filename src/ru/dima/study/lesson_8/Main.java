package ru.dima.study.lesson_8;


public class Main {

    public static void main(String[] args) {


        String[] wordsArray = {"apple", "orange", "banana", "apple", "grape", "banana", "kiwi", "orange", "apple", "melon", "kiwi", "grape", "banana"};

        System.out.println(WordProcessor.buildUniqueListOfWords(wordsArray));

        System.out.println(WordProcessor.countOfWords(wordsArray));

        PhoneDirectory.add("Dima",  "+375291111111");
        PhoneDirectory.add("Dima",  "+375291111122");
        PhoneDirectory.add("Roma",  "+375292222222");

        System.out.println(PhoneDirectory.get("Dima"));

    }
}
