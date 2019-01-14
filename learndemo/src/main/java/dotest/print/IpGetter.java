package dotest.print;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2019-01-14
 **/
public class IpGetter {

    public static void main(String[] args) throws SocketException {
        getCurrentIp().forEach(System.out::println);
    }

    private static List<InetAddress> getCurrentIp() throws SocketException {
        ArrayList<InetAddress> result = new ArrayList<>();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface ni = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = ni.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                if (!inetAddress.isLinkLocalAddress() && !inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                    result.add(inetAddress);
                }
            }
        }
        return result;
    }
}
