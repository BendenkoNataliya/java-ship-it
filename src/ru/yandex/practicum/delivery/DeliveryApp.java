package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> boxWithStandard = new ParcelBox<>(25,
            new ArrayList<>());
    private static final ParcelBox<PerishableParcel> boxWithPerishable = new ParcelBox<>(40,
            new ArrayList<>());
    private static final ParcelBox<FragileParcel> boxWithFragile = new ParcelBox<>(35,
            new ArrayList<>());

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackShipment();
                    break;
                case 5:
                    showContentsOfTheBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Отследить отправление");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Укажите тип Вашей посылки: 1 - стандартная," +
                "2 - хрупкая, 3 - скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите вес посылки в кг:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Кратко опишите Вашу посылку:");
        String description = scanner.nextLine();
        System.out.println("Укажите адрес назначения:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Укажите день отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());
        int timeToLive = 0;
        if (type == 3) {
            System.out.println("Укажите срок в днях, за который посылка "
                    + "не испортится: ");
            timeToLive = Integer.parseInt(scanner.nextLine());
        }
        switch (type) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description,
                        weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                boxWithStandard.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description,
                        weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                boxWithFragile.addParcel(fragileParcel);
                FragileParcel.addToTracking(fragileParcel);
                break;
            case 3:
                PerishableParcel perishableParcel = new PerishableParcel(description,
                        weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                boxWithPerishable.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Неверно указан тип посылки.");
        }
    }

    private static void sendParcels() {
        for (Parcel p : allParcels) {
            p.packageItem();
            p.deliver();
        }
    }

    private static void calculateCosts() {
        int cost = 0;
        for (Parcel p : allParcels) {
            cost += p.getUnitPrice() *  p.weight;
        }
        System.out.println("Общая стоимость доставки всех посылок составила: "
                + cost + ".");
    }

    private static void trackShipment() {
        System.out.println("Укажите местонахождeние Вашей посылки: ");
        String newLocation = scanner.nextLine();
        System.out.println("Для отслеживания вашего отправления укажите "
                + "следующие данные (через 'Enter'): описание, вес, "
                + "адрес доставки, дата отправления.");
        String description = scanner.nextLine();
        int weight = Integer.parseInt(scanner.nextLine());
        String deliveryAddress = scanner.nextLine();
        int sendDay = Integer.parseInt(scanner.nextLine());
        Trackable requestShipment = new FragileParcel(description, weight,
                deliveryAddress, sendDay);
        for (Parcel p : allParcels) {
            if (p.equals(requestShipment)) {
                requestShipment.reportStatus(newLocation);
            }
        }
    }

    private static void showContentsOfTheBox() {
        System.out.println("Укажите тип коробки: 1 - со стандартными"
                + " посылками, 2 - с хрупкими посылками, "
                + "3 - со скоропортящимися посылками");
        int type = Integer.parseInt(scanner.nextLine());
        switch (type) {
            case 1:
                for (Parcel p : boxWithStandard.getParcelInBox()) {
                    System.out.println(p);
                }
                break;
            case 2:
                for (Parcel p : boxWithFragile.getParcelInBox()) {
                    System.out.println(p);
                }
                break;
            case 3:
                for (Parcel p : boxWithPerishable.getParcelInBox()) {
                    System.out.println(p);
                }
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }
}
