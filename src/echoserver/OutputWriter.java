package echoserver;
import java.io.IOException;
import java.io.InputStream;


public class OutputWriter implements Runnable {
    InputStream socketInputStream;

    public OutputWriter(InputStream socketInputStream) {
        this.socketInputStream = socketInputStream;
    }

    public void run() {
        int socketByte;

        try {
            // While there is data to be read from the server
            while ((socketByte = socketInputStream.read()) != -1) {
                // Write it out to the screen
                System.out.write(socketByte);
            }
        } catch (IOException e) {
            System.out.println("This is an IOException.");
            System.exit(1);
        }
    }
}
