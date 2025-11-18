package ru.yandex.practicum.delivery;

public class ValuableLetters implements Trackable {
    String description;

    public ValuableLetters(String description) {
        this.description = description;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Отправление " + description + " изменило"
                + " местоположение на " + newLocation);
    }
}
