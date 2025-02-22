public class Formatter {
    public String rubFormatter(double sum) {
        int lastDigit = (int) (Math.floor(sum) % 100);
        if (lastDigit >= 10 && lastDigit <= 20) {
            return " рублей";
        }
        lastDigit = (int) (Math.floor(sum) % 10);
            return switch (lastDigit) {
                case 01 -> " рубль";
                case 02, 03, 04 ->" рубля";
                default -> " рублей";
            };
        }
            }

