public class Formatter {
    public static String rubFormatter(double sum) {
        int lastDigit = (int) (Math.floor(sum) % 10);
        return switch (lastDigit) {
            case 1 -> " рубль";
            case 2, 3, 4 -> " рубля";
            default -> " рублей";
        };

    }
}
