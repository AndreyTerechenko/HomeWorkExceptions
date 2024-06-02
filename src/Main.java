public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {
        try {
            authorization("admin", "root", "root");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Проверка не пройдена");
            e.printStackTrace();
        }

    }

    public static void authorization(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException("логин содержит больше 20 символов");
        }
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("Логин содержит неприемлемые символы");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль содержит больше 20 символов");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("Пароль содержит неприемлемые символы");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

    }


}
