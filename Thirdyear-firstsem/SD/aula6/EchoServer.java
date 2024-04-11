package aula6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
class ServerWorker implements Runnable  {
    private Socket socket;

    public ServerWorker(Socket socket) {
        this.socket = socket;
    }


    public void run() {
        try {
            int total = 0;
            int i = 0;
            BufferedReader in = null;

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String line;
            while ((line = in.readLine()) != null) {
                total += Integer.parseInt(line);
                i += 1;
                out.println(total);
                out.flush();
            }
            System.out.println("acabou");
            out.println(total / i);
            out.flush();

            socket.shutdownOutput();
            socket.shutdownInput();
            socket.close();
        } catch (IOException e) {

        }

    }
}

public class EchoServer {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(12345);

            while (true) {

                //espera nova conexão
                Socket socket = ss.accept();

                Thread thread = new Thread(new ServerWorker(socket));
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
