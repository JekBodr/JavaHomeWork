package hw8;

public class Auth {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void signUP(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[a-zA-Z0-9]{5,20}$")) {
            System.out.println("Ваш логин может содержать только латинский буквы и цифры");
            throw new WrongLoginException();
        }
       else if (!password.matches("^[a-zA-Z0-9]{5,}$")) {
            System.out.println("Пароль должен содержать латинские ,буквы, цифры, знак подчеркивания");
            throw new WrongPasswordException();
        }
       else   if (!password.equals(confirmPassword)) {
            System.out.println("Введеные вами пароли не совпадают");
            throw new WrongPasswordException();
        }
       else {
           System.out.println("Вы успешно прошли регистрацию");
           setLogin(login);
           setPassword(password);
        }
    }


    public void signIn(String login, String password) throws WrongPasswordException, WrongLoginException {
        if(!getLogin().equals(login)){
            throw new WrongLoginException("Вы ввели логин или пароль неправильно");
        }
        if(!getPassword().equals(password)){
            throw new WrongLoginException("Вы ввели логин или пароль неправильно");
        }
        else {
            System.out.println("Вы авторизовались на сайте");
        }



    }
}