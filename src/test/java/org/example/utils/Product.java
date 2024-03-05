package org.example.utils;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private final double price;
    private final String brand;
    private final String name;

    public Product(double price, String brand, String name) {
        this.price = price;
        this.brand = brand;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(brand, product.brand) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, brand, name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
