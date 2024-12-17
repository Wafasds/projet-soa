package ws;


import jakarta.jws.*;
import org.example.user;

@WebService
public interface Test {
    @WebMethod
    String Helloworld();
    @WebMethod
    String Hellot(@WebParam(name = "name")String name);
    @WebMethod
    String ajouterUser(user User1);
}
