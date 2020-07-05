package tooltest.apitest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

public class HttpclientDemo {

    public static void main(String[] args) {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpClientBuilder.create().build();
        HttpClients.custom().build();
    }

}
