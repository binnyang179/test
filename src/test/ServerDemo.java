import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {

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


    public static void main(String[] args) {
        ServerDemo serverDemo = new ServerDemo();
        serverDemo.start();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(80000);
        System.out.println("Waiting");
        Socket s = serverSocket.accept();
        System.out.println("success" + s.getInetAddress());
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        Reader reader = new Reader(out);
        reader.start();
        Writer writer = new Writer(in);
        writer.start();
    }
}
