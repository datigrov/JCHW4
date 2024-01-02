package Exceptions;

public class Main {
    public static String allowedCharacters = "^[a-zA-Z0-9_]+$";

    public static void main(String[] args) {
        try {
            registration("hfkdfdfh","login","login");
            System.out.println("Регистрация выполнена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void registration(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль слишком длинный");
        }

        if (!login.matches(allowedCharacters)) {
            throw new WrongLoginException("Логин содержит запрещенный символ");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введите корректный пароль");
        }
        if (!wrongInformation(password)) {
            throw new WrongPasswordException("Пароль содержит запрещенный символ");
        }
    }
    public static boolean wrongInformation(String allowedSharacters) {
        for (int i = 0; i < allowedSharacters.length(); i++) {
            char st = allowedSharacters.charAt(i);
            if ('a' <= st && st <= 'z' || 'A' <= st && st <= 'Z') {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
