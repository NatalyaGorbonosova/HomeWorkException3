import java.util.Scanner;

public class PasswordVerifier {
    public static void main(String[] args) {
        boolean continueInput = true;
        do {
            try{
                String password = inPutPassword();
                continueInput = false;
            } catch (InvalidPasswordException e){
                System.out.println(e.getMessage());
            }
        } while (continueInput);
        System.out.println("Пароль принят");

    }
    public static String inPutPassword() throws InvalidPasswordException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите новый пароль");
        String password = sc.nextLine();

        if (password.length() < 8) throw new InvalidPasswordException("Пароль должен быть не менее 8 символов");
        if (!hasDigit(password)) throw new InvalidPasswordException("Пароль должен содержать хотя бы одну цифру");
        if (!hasCapitalLetter(password)) throw new InvalidPasswordException("Пароль должен содержать хотя бы одну заглавную букву");
        sc.close();


        return password;

    }
    public static boolean hasDigit(String word){
        boolean hasDigit = false;
        for (int i=0; i < word.length() && !hasDigit; i++){
            if(Character.isDigit(word.charAt(i))) {
                hasDigit = true;
            }
        }
        return hasDigit;
    }
    public static boolean hasCapitalLetter(String word){
        boolean hasCL = false;
        for (int i = 0; i < word.length() && !hasCL; i++){
            if (Character.isUpperCase(word.charAt(i))) {
                hasCL = true;
            }
        }
        return hasCL;
    }

    static class InvalidPasswordException extends Exception{
        public InvalidPasswordException(String message){
            super(message);
        }
    }
}
