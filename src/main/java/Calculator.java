import java.util.Scanner;

public class Calculator {
    static int people;

    Calculator(int people) {
        this.people = people;
    }

    static String items = "Добавленные товары:";
    static double sumItemPrices = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void askUser() {
        String userResponce = "1";
        String itemName;
        double itemPrice = 0;


        while (!userResponce.equals("0")) {
            boolean isPriceEntered = false;
            System.out.println("Введите название товара");
            itemName = scanner.next();
            while (!isPriceEntered) {
                scanner.nextLine();
                System.out.println("Введите стоимость товара");

                if (scanner.hasNextDouble()) {
                    itemPrice = scanner.nextDouble();
                    if (itemPrice < 0) {
                        System.out.println("Ошибка: отрицательное число");
                    } else {
                        isPriceEntered = true;
                    }
                } else {
                    System.out.println("Ошибка, необходимо только число");
                }
            }
            Item item = new Item(itemName, itemPrice);
            items = items + "\n" + item.name;
            sumItemPrices = sumItemPrices + item.price;
            System.out.println("Товар успешно добавлен");
            System.out.println("Если хотите добавить еще товар, то введите - 1 \n" +
                    "Если нет, введите - Завершить");
            userResponce = scanner.next();
            if (userResponce.equalsIgnoreCase("завершить")) {
                userResponce = "0";
                scanner.close();
                calculation();
            }
        }


    }

    public static void calculation() {
        Formatter formatter = new Formatter();
        double sumPerPerson = sumItemPrices / people;
        // String sumRubStr = formatter.rubFormatter(sumPerPerson);
        System.out.println(items);
        System.out.println("Каждый из " + people + " человек должен заплатить:" + String.format("%.2f", sumPerPerson) +
                formatter.rubFormatter(sumPerPerson));
    }

}
