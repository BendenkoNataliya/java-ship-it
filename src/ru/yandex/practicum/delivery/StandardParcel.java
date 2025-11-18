package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, int weight,
                          String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getUnitPrice() {
        return 2;
    }

    @Override
    public String toString() {
        return "StandardParcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}
