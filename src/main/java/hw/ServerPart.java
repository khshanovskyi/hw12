package hw;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPart {
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket socket = new ServerSocket(8081);
        while (true){
            Socket accept = socket.accept();
            InputStream inputStream = accept.getInputStream();
            System.out.println("accept works");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String message = reader.readLine().lines().collect(Collectors.joining());
            String message = new String(inputStream.readAllBytes());

            System.out.println(message);
            Socket socket2 = new Socket(InetAddress.getLocalHost().getHostAddress(), 8081);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket2.getOutputStream()));
            writer.write("hello from Pavlo");
            writer.flush();
        }
    }
}
