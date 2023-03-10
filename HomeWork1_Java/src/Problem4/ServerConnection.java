package Problem4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//This class in implemented into client side to handle server connection of a server to any user 
// Use runnable interface to make a this class work in parallel
public class ServerConnection implements Runnable{
    //Server at which use  is connected 
    private Socket server  ;
    //Use to receive message from server 
    private BufferedReader in ;


    public ServerConnection(Socket socket) throws IOException {
        this.server = socket ;
        this.in = new BufferedReader(new InputStreamReader(server.getInputStream())) ;
    }
    
    
    // This is part of class that can be run i parallel
    // So  client can receive in parallel message from  server at anuy time
    //without waiting to send one 
    @Override
    public void run() {
        String str;

        try {

            while(true){
                str = in.readLine() ;
                System.out.println("FROM SERVER: " + str);
            }
        } catch (IOException e) {
            try {
                server.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
           
        }

    }
}