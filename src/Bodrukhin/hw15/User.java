package hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class User extends JFrame {
    private static final String host = "localhost";
    private static final int port = 2222;
    private Socket clientSocket;
    private Scanner inMessage;
    private PrintWriter outMessage;
    private JTextField message;
    private JTextField name;
    private JTextArea textMess;
    private String clientName = "";
    public String getClientName() {
        return this.clientName;
    }

    public User() {
        try {
            clientSocket = new Socket(host, port);
            inMessage = new Scanner(clientSocket.getInputStream());
            outMessage = new PrintWriter(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setBounds(400, 300, 700, 500);
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        textMess = new JTextArea();
        textMess.setEditable(false);
        textMess.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(textMess);
        add(jsp, BorderLayout.CENTER);
        JLabel jlNumberOfClients = new JLabel("Количество клиентов в чате: ");
        add(jlNumberOfClients, BorderLayout.NORTH);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        JButton jbSendMessage = new JButton("Отправить");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);
        message = new JTextField("Введите ваше сообщение: ");
        bottomPanel.add(message, BorderLayout.CENTER);
        name = new JTextField("Ваш ник: ");
        bottomPanel.add(name, BorderLayout.WEST);
        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.getText().trim().isEmpty() && !name.getText().trim().isEmpty()) {
                    clientName = name.getText();
                    sendMsg();
                    message.grabFocus();
                }
            }
        });
        message.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                message.setText("");
            }
        });
        name.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                name.setText("");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (inMessage.hasNext()) {
                            String inMes = inMessage.nextLine();
                            String clientsInChat = "Клиентов в чате = ";
                            if (inMes.indexOf(clientsInChat) == 0) {
                                jlNumberOfClients.setText(inMes);
                            } else {
                                textMess.append(inMes);
                                textMess.append("\n");
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
        }).start();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    if (!clientName.isEmpty() && clientName != "Введите ник для чата: ") {
                        outMessage.println(clientName + " вышел из чата!");
                    } else {
                        outMessage.println("Участник 'без имени' вышел из чата!");
                    }
                    outMessage.println("!quit!");
                    outMessage.flush();
                    outMessage.close();
                    inMessage.close();
                    clientSocket.close();
                } catch (IOException exc) {

                }
            }
        });
        setVisible(true);
    }

    public void sendMsg() {
        String messageStr = new Date() + " " + name.getText() + ": " + message.getText();
        outMessage.println(messageStr);
        outMessage.flush();
        message.setText("");
    }

    public static void main(String[] args) {
        User client = new User();
    }
}
