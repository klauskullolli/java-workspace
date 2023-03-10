package Problem4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


//This is a class that handle client response form a server using runnable 
//So it can be implemented to a thread
public class ClinetConected  implements  Runnable{
   
	// Client socket 
	Socket socket ;
    
    //Used to writ form server to a user 
    PrintWriter out ;
    //Read input stream of server given by output stream of user 
    BufferedReader in ;
    ArrayList<ClinetConected> clients;

   //Constructor 
    ClinetConected(Socket mySocket , ArrayList<ClinetConected>clients) throws IOException {
        this.socket = mySocket ;
        this.clients = clients ;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream() ,true) ;

    }
    @Override
    // Is a method that can be implemented to thread to be handle in parallel way 
    //So server receives messages from client parallel so each client can send to server message any time
    //Server can broad cast massage to any user parallel
    public void run() {
        String clientSentence;
        Scanner input = new Scanner(System.in);


        try {
        	//Chat open until the server receive a stop message from client 
            while (true) {
                clientSentence = in.readLine();
                System.out.println("FROM CLIENT: " + clientSentence);
                if (clientSentence.contains("stop")) break;
                System.out.print("> ");
                String str = input.nextLine();
                //out.println(str);
                outToAll(str);
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
   
    //Use to broad cast message to any user
    private  void outToAll(String str){
        for (ClinetConected client : clients){
            client.out.println(str);
        }
    }
}

