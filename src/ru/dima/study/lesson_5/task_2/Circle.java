package ru.dima.study.lesson_5.task_2;

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
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
        System.out.printf("Круг: Периметр=%.2f, Площадь=%.2f, Цвет фона=%s, Цвет границы=%s%n",
                calculatePerimeter(), calculateArea(), fillColor, borderColor);
    }
}
