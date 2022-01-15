package hw15;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Handler implements Runnable {

    private Server server;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private Socket clientSocket = null;
    private static int clients_count = 0;

    public Handler(Socket socket, Server server) {
        try {
            clients_count++;
            this.server = server;
            this.clientSocket = socket;
            this.outMessage = new PrintWriter(socket.getOutputStream());
            this.inMessage = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                server.m2AllClients("Новый участник в чате!");
                server.m2AllClients("Коллличество клиентов в чате = " + clients_count);
                break;
            }

            while (true) {
                if (inMessage.hasNext()) {
                    String clientMessage = inMessage.nextLine();
                    if (clientMessage.equalsIgnoreCase("Выход")) {
                        break;
                    }
                    System.out.println(clientMessage);
                    server.m2AllClients(clientMessage);
                }
            }
        } finally {
            this.close();
        }
    }
    public void sendMsg(String msg) {
        try {
            outMessage.println(msg);
            outMessage.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void close() {
        server.removeClient(this);
        clients_count--;
        server.m2AllClients("Коллличество клиентов в чате = " + clients_count);
    }
}