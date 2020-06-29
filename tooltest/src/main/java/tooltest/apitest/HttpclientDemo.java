package tooltest.apitest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpclientDemo {

    public static void main(String[] args) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        CloseableHttpClient aDefault = HttpClients.createDefault();
    }

}
