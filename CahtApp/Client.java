import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Client() throws Exception {
        System.out.println("Sending Request To Server..");
        socket = new Socket("127.0.0.1", 7777);
        System.out.println("Connection Done..");
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
        StartReading();
        StartWriting();
    }

    public void StartReading() {
        Runnable r1 = () -> {
            System.out.println("Reader Started..");

            while (true) {
                try {
                    String msg = br.readLine();

                    if (msg.equalsIgnoreCase("exit")) {
                        System.out.println("Server Terminated Chat");

                        socket.close();
                        break;
                    }

                    System.out.println("Server : " + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        new Thread(r1).start();
    }

    public void StartWriting() {
        Runnable r2 = () -> {
            try {
                while (true) {
                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    String contant = br1.readLine();
                    out.println(contant);
                    out.flush();

                    if (contant.equalsIgnoreCase("Exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        new Thread(r2).start();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("This Is ..Client");
        new Client();
    }
}
