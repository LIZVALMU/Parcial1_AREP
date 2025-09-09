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
    boolean firtline = false;
    
    while ((inputLine = in.readLine()) != null) {
        System.out.println("Recibí: " + inputLine);

        if (!in.ready()) {break; }
    }

    URI requestUri = new URI(requestStringUri);
    if(requestUri.getPath().startsWith("/getkv?key={key}"));



    outputLine = "HTTP/1.1 200 OK\r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n"
            + "<!DOCTYPE html>\n"
            + "<html>\n"
            + "<head>\n"
            + "<meta charset=\"UTF-8\">\n"
            + "<title>Title of the document</title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h1>Mi propio mensaje</h1>\n"
            + "</body>\n"
            + "</html>\n";

        outputLine = "HTTP/1.1 400 OK\r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n"
            + "<!DOCTYPE html>\n"
            + "<html>\n"
            + "<head>\n"
            + "<meta charset=\"UTF-8\">\n"
            + "<title>Pagina no Encontrada</title>\n"
            + "</head>\n"
            + "<body>\n"
            + "<h1>404 Not Found</h1>\n"
            + "</body>\n"
            + "</html>\n";

        out.println(outputLine);
        out.close(); 
        in.close(); 
        clientSocket.close();
        serverSocket.close(); 
    }
    }

}

