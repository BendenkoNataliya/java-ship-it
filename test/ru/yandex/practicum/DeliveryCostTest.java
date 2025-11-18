package ru.yandex.practicum;

import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    private final StandardParcel standardParcel = new StandardParcel("Food",
            15, "Moscow, Baymanskaya, 144", 23);
    private final PerishableParcel perishableParcel = new PerishableParcel(
            "Flowers", 5, "Spb, Varshavskaya, 37-15",
            15, 5);
    private final FragileParcel fragileParcel = new FragileParcel("Glass",
            26, "Volhov, Lenina, 18", 12);

    @Test
    public void shouldBe30WhenParcelStandard() {
        Assertions.assertEquals(30, standardParcel.getUnitPrice()
                * standardParcel.getWeight());
    }

    @Test
    public void shouldBe15WhenParcelPerishable() {
        Assertions.assertEquals(15, perishableParcel.getUnitPrice()
                * perishableParcel.getWeight());
    }

    @Test
    public void shouldBe104WhenParcelFragile() {
        Assertions.assertEquals(104, fragileParcel.getUnitPrice()
                * fragileParcel.getWeight());
    }

    @Test
    public void shouldBeZeroWhenWeightParselZero() {
        fragileParcel.setWeight(0);
        Assertions.assertEquals(0,fragileParcel.getUnitPrice()
                * fragileParcel.getWeight());
    }
}
