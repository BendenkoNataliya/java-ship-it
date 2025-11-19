package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.delivery.ParcelBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.StandardParcel;

import java.util.ArrayList;

public class ParcelBoxTest {

    private static final ArrayList<StandardParcel> standardParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> boxWithStandard = new ParcelBox<>(
            25, standardParcels);
    private final StandardParcel parcel= new StandardParcel("Books",
            15, "Moscow, Lenina 40-155", 15);

    @BeforeEach
    public void clearListParcel() {
        standardParcels.clear();
    }

    @Test
    public void shouldBeFalseWhenParcelWeight15() {
        boxWithStandard.addParcel(parcel);
        Assertions.assertFalse(standardParcels.isEmpty());
    }

    @Test
    public void shouldBeFalseWhenParcelWeight25() {
        parcel.setWeight(25);
        boxWithStandard.addParcel(parcel);
        Assertions.assertFalse(standardParcels.isEmpty());
    }

    @Test
    public void shouldBeTrueWhenParcelWeight35() {
        parcel.setWeight(35);
        boxWithStandard.addParcel(parcel);
        Assertions.assertTrue(standardParcels.isEmpty());
    }
}
