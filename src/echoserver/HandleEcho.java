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
                int socketByte;
                // While there is more to read from the inputStream from the client
                while ((socketByte = inputStream.read()) != -1) {
                    // Write the data to the outputStream for the client
                    outputStream.write(socketByte);
                }
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            System.exit(1);
        }


    }

}