package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private final int maxWeight;
    private ArrayList<T> parcelInBox;

    public ParcelBox(int maxWeight, ArrayList<T> parcelInBox) {
        this.maxWeight = maxWeight;
        this.parcelInBox = parcelInBox;
    }

    public void addParcel(T parcel) {
        if ((calculateWeightParcelsInBox(parcelInBox) + parcel.weight)
                <= maxWeight) {
            parcelInBox.add(parcel);
        } else {
            System.out.println("Посылка не добавлена в коробку. "
                    + "Превышен максимальный вес коробки.");
        }
    }

    public void getAllParcels() {
        for (T parcel : parcelInBox) {
            System.out.println(parcel);
        }
    }

    private int calculateWeightParcelsInBox(ArrayList<T> parcelInBox) {
        int weightParcelsInBox = 0;
        if (parcelInBox.isEmpty()) {
            return 0;
        } else {
            for (T parcel : parcelInBox) {
                weightParcelsInBox += parcel.weight;
            }
        }
        return weightParcelsInBox;
    }

    public ArrayList<T> getParcelInBox() {
        return parcelInBox;
    }
}
