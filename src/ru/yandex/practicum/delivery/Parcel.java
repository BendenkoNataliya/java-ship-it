package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
    String description;
    int weight;
    String deliveryAddress;
    int sendDay;
    private static int unitPrice;


    public Parcel(String description, int weight,
                  String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public abstract int getUnitPrice();

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description
                + " доставлена по адресу " + deliveryAddress);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parsel = (Parcel) o;
        return weight == parsel.weight && sendDay == parsel.sendDay &&
                Objects.equals(description, parsel.description) &&
                Objects.equals(deliveryAddress, parsel.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}