import java.util.Scanner;

public class Calculator {
    int people;

    Calculator(int people) {
        this.people = people;
    }

    static String items = "Добавленные товары:";
    static double sumItemPrices = 0;
    static Scanner scanner = new Scanner(System.in);

    public void askUser() {
        String itemName;
        double itemPrice = 0;
        boolean isDataEntered = false;


        while (!isDataEntered) {
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
            sumItemPrices += item.price;
            System.out.println("Товар успешно добавлен");
            System.out.println("Если хотите добавить еще товар, то введите - 1 \n" +
                    "Если нет, введите - Завершить");
            if (scanner.next().equalsIgnoreCase("завершить")) {
                isDataEntered = true;
                scanner.close();
                calculation();
            }
        }


    }

    public void calculation() {
        Formatter formatter = new Formatter();
        double sumPerPerson = sumItemPrices / people;
        // String sumRubStr = formatter.rubFormatter(sumPerPerson);
        System.out.println(items);
        System.out.println("Каждый из " + people + " человек должен заплатить:" + String.format("%.2f", sumPerPerson) +
                formatter.rubFormatter(sumPerPerson));
    }

}
