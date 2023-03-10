package Problem4;


import java.io.*;

import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Server {
    
	//ArrayList of Client connected to server
    private static ArrayList<ClinetConected>  clients= new ArrayList<>() ;
    
    //Pool to execute thread of clientConnected class for each user
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String argv[]) throws Exception

    {

        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Server is waiting...");
        //Chat always open for new users       
        while (true){
            Socket connectionSocket = welcomeSocket.accept();
            ClinetConected clienThread = new ClinetConected(connectionSocket ,clients) ;
            clients.add(clienThread) ;
            pool.execute(clienThread); ;
        }

    }
}