package ru.dima.study.lesson_5.task_2;

class Rectangle implements Shape {
    private double length;
    private double width;
    private String fillColor;
    private String borderColor;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public void printCharacteristics() {
        System.out.printf("Прямоугольник: Периметр=%.2f, Площадь=%.2f, Цвет фона=%s, Цвет границы=%s%n",
                calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}
