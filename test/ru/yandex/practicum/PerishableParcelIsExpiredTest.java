package ru.yandex.practicum;

import ru.yandex.practicum.delivery.PerishableParcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerishableParcelIsExpiredTest {

    private final PerishableParcel perishableParcel = new PerishableParcel(
            "Flowers", 5, "Spb, Varshavskaya, 37-15",
            15, 5);

    @Test
    public void shouldBeFalseWhenCurrentDay17() {
        Assertions.assertFalse(perishableParcel.isExpired(17));
    }

    @Test
    public void shouldBeTrueWhenCurrentDay23() {
        Assertions.assertTrue(perishableParcel.isExpired(23));
    }

    @Test
    public void shouldBeFalseWhenCurrentDay20() {
        Assertions.assertFalse(perishableParcel.isExpired(20));
    }
}
