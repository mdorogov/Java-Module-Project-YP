import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Привет, это разделитель счёта");
       askUser();
    }

    public static void askUser() {
        int people = 0;
        while (people <= 1) {
            System.out.println("Введите количество человек, на которых делится счёт");
            if (scanner.hasNextInt()){
            people = scanner.nextInt();
            } else {
                System.out.println("Неверное значение. Попробуй снова");
                scanner.nextLine();
            }
        }
        makeCalculation(people);

    }

    public static void makeCalculation(int people) {
        Calculator calculator = new Calculator(people);
        calculator.askUser();


    }
}