import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите математическую операцию через пробел ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(calc(s));
    }
    static String calc(String s) {
        String[] array = s.split(" ");
        if (array.length < 3) {
            throw new RuntimeException("Cтрока не является математической операцией");
        }
        if (array.length > 3) {
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String first = array[0];
        String second = array[2];
        String operator = array[1];
        String result = " ";
        int num1 = 0;
        int num2 = 0;
        int res;
        String[] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        if (Character.isDigit(first.charAt(0)) && Character.isLetter(second.charAt(0)) || Character.isLetter(first.charAt(0)) && Character.isDigit(second.charAt(0))) {
            throw new RuntimeException("Используются одновременно разные системы счисления");
        } else if (Character.isDigit(first.charAt(0)) && Character.isDigit(second.charAt(0))) {
            num1 = Integer.parseInt(first);
            num2 = Integer.parseInt(second);
            if ((num1 <= 0) || (num2 <= 0) || (num1 > 10) || (num2 > 10)) {
                throw new RuntimeException("Калькулятор может принимать только числа от 1 до 10 включительно");
            } else {
                res = switch (operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default ->
                            throw new RuntimeException("Калькулятор умеет только скалдывать, вычитать, умножать или делить");
                };
            }
            result = Integer.toString(res);
        }else if (Character.isLetter(first.charAt(0)) && Character.isLetter(second.charAt(0))){
            for (int i = 0;i < roman.length;i++){
                if (first.equals(roman[i])){
                    num1 = i+1;
                }
                if(second.equals(roman[i])){
                    num2 = i+1;
                }
            }
            if ((num1 <= 0) || (num2 <= 0) || (num1 > 10) || (num2 > 10)) {
                throw new RuntimeException("Калькулятор может принимать только числа от I до X включительно");
            } else {
                res = switch (operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1- num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default ->
                            throw new RuntimeException("Калькулятор умеет только скалдывать, вычитать, умножать или делить");
                };
            }
            if (res<=0){
                throw new RuntimeException("В римской системе нет отрицательных чисел или 0");
            }
            result = roman[res-1];
        }
        return result;
    }
}