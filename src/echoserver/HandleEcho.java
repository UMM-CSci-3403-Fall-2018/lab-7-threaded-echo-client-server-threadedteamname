package echoserver;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class HandleEcho implements Runnable {

    Socket socket;

    public HandleEcho(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                int b;
                while ((b = inputStream.read()) != -1) {
                    outputStream.write(b);
                }
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            System.exit(1);
        }


    }

}