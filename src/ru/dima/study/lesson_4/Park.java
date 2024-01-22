package ru.dima.study.lesson_4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Park {

   private  List<Attraction> attractions;
   private String nameOfPark;

    public Park(String nameOfPark) {
        this.nameOfPark = nameOfPark;
        this.attractions = new ArrayList<>();
    }

    public String getNameOfPark() {
        return nameOfPark;
    }

    public void addNewAttraction(String name, String openingTime, String closingTime, double cost) {
      attractions.add(new Attraction(name, openingTime, closingTime, cost));
    }

    public void removeByName(String name) {
        attractions = attractions.stream().filter(p -> !p.getName().equals(name)).collect(Collectors.toList());
    }

    public void displayAttractions(){
        System.out.println("Attractions in the " + nameOfPark + " park:");
        attractions
                .forEach(attraction -> {
                    System.out.println("Name: " + attraction.getName());
                    System.out.println("Working Hours: " + attraction.getWorkingHours());
                    System.out.println("Cost: $" + attraction.getCost());
                    System.out.println();
                });
    }


    public class Attraction {
        private String name;

        private LocalTime openingTime;

        private LocalTime closingTime;
        private double cost;

        public Attraction(String name, String openingTime, String closingTime, double cost) {
            this.name = name;
            this.openingTime =   LocalTime.parse(openingTime, DateTimeFormatter.ofPattern("HH:mm"));
            this.closingTime = LocalTime.parse(closingTime, DateTimeFormatter.ofPattern("HH:mm"));
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public String getWorkingHours() {
            return openingTime + "-" + closingTime;
        }

        public double getCost() {
            return cost;
        }
    }
}
