package hw;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientPart {
    @SneakyThrows
    public static void main(String[] args) {
        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8081);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("hello from Pavlo");
        writer.flush();
    }
}
