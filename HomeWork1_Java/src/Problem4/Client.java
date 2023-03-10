package Problem4;


import java.io.*;

import java.net.*;
import java.util.Scanner;

class Client {

    public static void main(String argv[]) throws Exception

    {   
    	//Client send message to server form keyboard 
        Scanner input  = new Scanner(System.in);
        String sentence ="";

        Socket clientSocket = new Socket("127.0.0.1", 6789);

        // Use to write into server
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream() ,true);
        
        //Use serverConnection class to handle in parallel messages received from servers 
        ServerConnection  serverConnection = new ServerConnection(clientSocket) ;
        new Thread(serverConnection).start();
        //Chat open until stop word is sent
        while (true){
            System.out.print("> ") ;
            sentence = input.nextLine() ;
            outToServer.println(sentence);
            if(sentence.contains("stop")) break;
        }
        clientSocket.close() ;


    }

}