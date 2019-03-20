import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) throws IOException {
        ClientDemo clientDemo = new ClientDemo();
        clientDemo.open();
    }

    public void open() throws IOException {
        Socket s = new Socket("localhost", 8000);
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        new Reader(out).start();
        new Writer(in).start();
    }
}

class Reader extends Thread {
    OutputStream out;

    public Reader(OutputStream out) {
        this.out = out;
        setDaemon(true);
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String str = scanner.nextLine();
                out.write(str.getBytes());
                out.write('\n');
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Writer extends Thread {
    InputStream in;

    public Writer(InputStream in_) {
        this.in = in;
    }

    public void run() {
        try {
            int b;
            while ((b = in.read()) != -1) {
                System.out.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
