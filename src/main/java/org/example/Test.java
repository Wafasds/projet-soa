package org.example;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService
public interface Test {

    @WebMethod
    String sayHello(@WebParam(name = "user") user User);

    @WebMethod
    String ajouterUser(@WebParam(name = "user") user User);

    @WebMethod
    String updateUser(@WebParam(name = "user") user User);

    @WebMethod
    String deleteUser(@WebParam(name = "id") int id);
}
