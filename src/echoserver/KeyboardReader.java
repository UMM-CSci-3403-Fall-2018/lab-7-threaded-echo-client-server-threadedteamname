package echoserver;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class KeyboardReader implements Runnable {
    OutputStream socketOutputStream;
    Socket socket;

    public KeyboardReader(OutputStream socketOutputStream, Socket socket) {
        this.socketOutputStream = socketOutputStream;
        this.socket = socket;
    }

    public void run() {
        int readByte;

        try {
            // While there is additional data to be read from the keyboard
            while ((readByte = System.in.read()) != -1) {
                // Write it to the outputStream for the server
                socketOutputStream.write(readByte);
            }
            // Tells server there is nothing left to send
            socket.shutdownOutput();
        } catch (IOException e) {
            System.out.println("This is an IOException.");
            System.exit(1);
        }
    }
}
