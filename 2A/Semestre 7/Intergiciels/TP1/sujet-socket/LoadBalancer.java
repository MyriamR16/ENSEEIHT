import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.net.Socket;
import java.net.ServerSocket;

public class LoadBalancer extends Thread {
    
    static String hosts[] = {"localhost", "localhost"};
    static int ports[] = {8081,8082};
    static int nbHosts = 2;
    static Random rand = new Random();
    Socket client;
    

    public LoadBalancer(Socket s) {
        client = s;
    }
    
    public static void main(String arg[]) {
        try {
            ServerSocket ss = new ServerSocket(8080); 
            while (true) {
                new LoadBalancer(ss.accept()).start(); // start et pas pas de run sinon on run sur le thread principal du coup on bloque
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            int nb = LoadBalancer.rand.nextInt(LoadBalancer.nbHosts);
            Socket server = new Socket(hosts[nb],ports[nb]);
            InputStream cs_input = client.getInputStream();
            InputStream sc_input = server.getInputStream();
            OutputStream cs_output = client.getOutputStream();
            OutputStream sc_output = server.getOutputStream();

            int nbLus;
            byte[] buff = new byte[1024];
            nbLus = cs_input.read(buff);
            sc_output.write(buff,0,nbLus);
            nbLus = sc_input.read(buff);
            cs_output.write(buff,0,nbLus);

            server.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}