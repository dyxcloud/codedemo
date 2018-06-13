package cn.ws;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class ShowHello {

    public String show(String name){
        return "hello "+name;
    }

    public static void main(String[] args) {
        String address = "http://localhost:8080/show";
        Object s = new ShowHello();
        Endpoint.publish(address,s);
        System.out.println("show ws run...");
    }

}
