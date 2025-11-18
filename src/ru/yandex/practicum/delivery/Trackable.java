package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public interface Trackable {
    ArrayList<Trackable> trackedShipments = new ArrayList<>();

    public void reportStatus(String newLocation);
}
