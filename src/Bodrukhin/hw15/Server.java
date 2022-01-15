package hw15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    static final int port = 2222;
    private ArrayList<Handler> users = new ArrayList<Handler>();

    public Server() {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server has been started...");
            while (true) {
                clientSocket = serverSocket.accept();
                Handler client = new Handler(clientSocket, this);
                users.add(client);
                new Thread(client).start();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                clientSocket.close();
                System.out.println("Server stopped.");
                serverSocket.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void m2AllClients(String msg) {
        for (Handler o : users) {
            o.sendMsg(msg);
        }

    }

    public void removeClient(Handler client) {
        users.remove(client);
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}