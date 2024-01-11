
public class Validations {
    public static boolean isDigit(String input) {
        return input.matches("[0-9]+") || input.matches("[0-9 ]+");
    }
    public static boolean IsBinaryOperator(char ch) {
        return switch (ch) {
            case '+', '-', '*', '/', '%' -> true;
            default -> false;
        };
    }
    public static boolean IsPower(char ch) {
        return ch=='^';
    }
    public static boolean IsVar(char ch) {
        return Character.toString(ch).matches("[a-zA-Z]+");
    }
    public static boolean IsPolynomialForm(String Equation){
        String regex = "^(-?\\d*\\.?\\d*)?[a-zA-Z](\\^[0-9]+)?$";
        return Equation.matches(regex);
    }

}
