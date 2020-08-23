import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(2090);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
        ) {
            System.out.println("Сервер запущен, соединение с клиентом установлено");
            String input = in.readLine();
            out.write("Привет, " + input + ". Ваш порт " + clientSocket.getPort());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
