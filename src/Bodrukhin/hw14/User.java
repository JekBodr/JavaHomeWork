package hw14;

import java.io.*;
import java.net.Socket;

public class User {
    public static void main(String[] args) {
        new Users("localhost", 55555);
    }
}

class Users {

    private Socket socket;
    private BufferedReader input;
    private BufferedWriter output;
    private BufferedReader inputUser;
    private String login;

    public Users(String add, int port) {
        try {
            this.socket = new Socket(add, port);
        } catch (IOException e) {
            System.err.println("Socket failed");
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressLogin();
            new ReadMsg().start();
            new WriteMsg().start();
        } catch (IOException e) {
            Users.this.downService();
        }
    }

    private void pressLogin() {
        System.out.print("Enter your login: ");
        try {
            login = inputUser.readLine();
            output.write("Hello " + login + "\n");
            output.flush();
        } catch (IOException ignored) {
        }

    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                input.close();
                output.close();
            }
        } catch (IOException ignored) {}
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = input.readLine();
                    if (str.equals("exit")) {
                        Users.this.downService();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                Users.this.downService();
            }
        }
    }

    public class WriteMsg extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    userWord = inputUser.readLine();
                    if (userWord.equals("exit")) {
                        output.write("exit" + "\n");
                        Users.this.downService();
                        break;
                    } else {
                        output.write(login + ": " + userWord + "\n");
                    }
                    output.flush();
                } catch (IOException e) {
                    Users.this.downService();

                }
            }
        }
    }
}
