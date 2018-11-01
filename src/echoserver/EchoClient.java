package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
    public static final int PORT_NUMBER = 6013;

    public static void main(String[] args) throws IOException {
        EchoClient client = new EchoClient();

        String server;
        // Use "127.0.0.1", i.e., localhost, if no server is specified.
        if (args.length == 0) {
            server = "127.0.0.1";
        } else {
            server = args[0];
        }

        client.start(server);
    }

    private void start(String server) throws IOException {
        Socket socket = new Socket(server, PORT_NUMBER);
        InputStream socketInputStream = socket.getInputStream();
        OutputStream socketOutputStream = socket.getOutputStream();

        Thread input = new Thread(new KeyboardReader(socketOutputStream));
        Thread output = new Thread(new OutputWriter(socketInputStream));

        output.start();
        input.start();


        try {
            input.join();
            output.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception.");
            System.exit(1);
        }



        /*
        int readByte;
        while ((readByte = System.in.read()) != -1) {
            socketOutputStream.write(readByte);
            int socketByte = socketInputStream.read();
            System.out.write(socketByte);
        }
*/
        System.out.flush();
    }
}