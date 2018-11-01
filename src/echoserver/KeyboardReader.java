package echoserver;
import java.io.IOException;
import java.io.OutputStream;


public class KeyboardReader implements Runnable {
    OutputStream socketOutputStream;

    public KeyboardReader(OutputStream socketOutputStream) {
        this.socketOutputStream = socketOutputStream;
    }

    public void run() {
        int readByte;

        try {
            while ((readByte = System.in.read()) != -1) {
                socketOutputStream.write(readByte);
            }
        } catch (IOException e) {
            System.out.println("This is an IOException.");
            System.exit(1);
        }
    }
}
