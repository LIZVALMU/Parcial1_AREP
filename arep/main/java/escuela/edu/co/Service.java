package escuela.edu.co;

public class Service{

    private static getClientResponse(URI requestURI){
        JsonObject response = FachadaService.getInstance();
        
        

    }









    public static String GetClientResponse(URI requestURI){
        return  "HTTP/1.1 200 OK\r\n"
        + "Content-Type: text/html\r\n"
         + "\r\n"
         + "<!DOCTYPE html>\n"
         + "<html>\n"
         + "<head>\n"
         + "<meta charset=\"UTF-8\">\n"
         + "<title>VALORES</title>\n"
         + "</head>\n"
         + "<body>\n"
         + "<h1>Mi propio mensaje</h1>\n"
         + "</body>\n"
         + "</html>\n";
    }

    public static String getError(URI requestURI){
        return "HTTP/1.1 400 Error\r\n"
        + "Content-Type: text/html\r\n"
         + "\r\n"
         + "<!DOCTYPE html>\n"
         + "<html>\n"
         + "<head>\n"
         + "<meta charset=\"UTF-8\">\n"
         + "<title>Pagina no Encontrada>\n"
         + "</head>\n"
         + "<body>\n"
         + "<h1>404 Not Found</h1>\n"
         + "</body>\n"
         + "</html>\n";
    }
    
}

