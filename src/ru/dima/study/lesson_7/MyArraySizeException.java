package ru.dima.study.lesson_7;

public class MyArraySizeException extends Exception {

    static String notMeetCriteria = "Размер массива должен быть 4x4";
    public MyArraySizeException() {
        super(notMeetCriteria);
    }

}
