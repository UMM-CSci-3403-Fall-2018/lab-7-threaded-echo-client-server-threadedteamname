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
            while ((socketByte = socketInputStream.read()) != -1) {
                System.out.write(socketByte);
            }
        } catch (IOException e) {
            System.out.println("This is an IOException.");
            System.exit(1);
        }
    }
}
