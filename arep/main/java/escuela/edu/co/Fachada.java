package escuela.edu.co;

import java.net.*;
import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.BufferedReader;
import requestStringUri;

public class Fachada{
    public static void main( String[] args ){
    ServerSocket serverSocket = null;
    try { 
        serverSocket = new ServerSocket(36000);
    } catch (IOException e) {
        System.err.println("Could not listen on port: 35000.");
        System.exit(1);
    }
    boolean running = true;
    Socket clientSocket = null;
    while(running){
    try {
        System.out.println("Listo para recibir ...");
        clientSocket = serverSocket.accept();
    } catch (IOException e) {
        System.err.println("Accept failed.");
        System.exit(1);
    }
    PrintWriter out = new PrintWriter(
                            clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
    String inputLine, outputLine;
    boolean firtline = true;
    String requestStringURI = "";
    
    while ((inputLine = in.readLine()) != null) {
        if(firtline){
            System.out.println("Recibí: " + inputLine);
        }
        

        if (!in.ready()) {break; }
    }

    URI requestURI = new URI(requestStringUri);
    if(requestURI.getPath().startsWith("/setkv?key={key}&value={value}")){
    outputLine = getClientResponse(requestURI);
    }else if(requestURI.getPath().startsWith("/getkv?key={key}")){
    }else{
        outputLine = getError();
    }

        out.println(outputLine);
        out.close(); 
        in.close(); 
        clientSocket.close();
    }
        serverSocket.close(); 
    }

}

