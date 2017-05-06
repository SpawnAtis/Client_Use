package by.Pokosenko.SocketClient;

import by.Pokosenko.Message.Message;
import by.Pokosenko.Utils.Actions;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClient implements Runnable {

    private final String address = "127.0.0.1"; // это IP-адрес компьютера, где исполняется наша серверная программа
    private final int serverPort = 8080; // здесь обязательно нужно указать порт к которому привязывается сервер
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    public Socket socket = null;

    public void run() {

        try {

            try {
                InetAddress ipAddress = InetAddress.getByName(address); // создаем объект который отображает вышеописанный IP-адрес
                socket = new Socket(ipAddress, serverPort); // создаем сокет используя IP-адрес и порт сервера

                // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectInputStream = new ObjectInputStream(socket.getInputStream());

                //message = new Message();

                //Actions action = Actions.SignIn;
                // message = (Message) objectInputStream.readObject(); // принимаю строку сервером;
                // System.out.println(message.getAction());

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*public void send(Actions action) throws IOException
    {
        objectOutputStream.writeObject(new Message(action)); // отсылаем введенную строку текста серверу.
    }*/
}
