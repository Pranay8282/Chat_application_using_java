import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

class Server {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Server() throws Exception {
        server = new ServerSocket(7777);
        System.out.println("Server Is Ready to Accept Connection");
        System.out.println("Waiting....");
        socket = server.accept();

        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());

        StartReading();
        StartWriting();

    }

    public void StartReading() {
        Runnable r1 = () -> {
            System.out.println("Reader Started..");
            try {
                while (true) {

                    String msg = br.readLine();

                    if (msg.equalsIgnoreCase("exit")) {
                        System.out.println("Client Terminated Chat");
                        break;
                    }

                    System.out.println("Client : " + msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        new Thread(r1).start();
    }

    public void StartWriting() {
        Runnable r2 = () -> {
            while (true) {
                try {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String contant = br1.readLine();
                    out.println(contant);
                    out.flush();

                    if (contant.equalsIgnoreCase("Exit")) {
                        socket.close();
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r2).start();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("This IS Srever .. Going To Start");
        new Server();
    }
}