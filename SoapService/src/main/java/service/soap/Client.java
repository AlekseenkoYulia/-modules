package service.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9090/soap?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://soap.service/", "PetShopSoapServiceService");

        Service service = Service.create(url, qname);

        PetShopSoapServiceInterface s = service.getPort(PetShopSoapServiceInterface.class);

        System.out.println(s.welcome());
        System.out.println(s.findProductByDescription("kiwi"));
        System.out.println(s.addProduct("test2", "00000008", null,(double)1));
        System.out.println(s.findProductByDescription("test2"));
        System.out.println(s.buyProduct("00000008"));
        System.out.println(s.findProductByDescription("test2"));
    }
}
