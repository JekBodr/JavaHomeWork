package hw14;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

@SuppressWarnings("ALL")
public class Server {
    public static LinkedList<Servers> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(55555)) {
            System.out.println("Server Started");
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new Servers(socket));
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}

class Servers extends Thread {

    private final Socket socket;
    private final BufferedReader input;
    private final BufferedWriter output;
    SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yy hh:mm:s");

    public Servers(Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }
    @Override
    public void run() {
        String word;
        try {
            word = input.readLine();
            try {
                output.write(word + "\n");
                output.flush();
            } catch (IOException ignored) {}
            try {
                while (true) {
                    word = input.readLine();
                    if(word.equals("exit")) {
                        this.downService();
                        break;
                    }
                    System.out.println(word);
                    for (Servers vr : Server.serverList) {
                        vr.send(word);
                    }
                }
            } catch (NullPointerException ignored) {}


        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) {
        try {
            output.write(formatDate.format(new Date())+ "\n " + msg + "\n");
            output.flush();
        } catch (IOException ignored) {}

    }

    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                input.close();
                output.close();
                for (Servers vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}
