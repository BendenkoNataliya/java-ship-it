package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight,
                         String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getUnitPrice() {
        return 4;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description
                + " обернута в защитную пленку");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила"
                + " местоположение на " + newLocation);
    }

    public static void addToTracking(FragileParcel fragileParcel) {
        trackedShipments.add(fragileParcel);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "FragileParcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}

