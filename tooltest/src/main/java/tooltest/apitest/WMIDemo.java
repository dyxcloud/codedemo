package tooltest.apitest;

import java.net.UnknownHostException;

//import com.profesorfalken.wmi4java.WMI4Java;
//
//import cn.chenlichao.wmi4j.SWbemLocator;
//import cn.chenlichao.wmi4j.SWbemObject;
//import cn.chenlichao.wmi4j.SWbemObjectSet;
//import cn.chenlichao.wmi4j.SWbemServices;
//import cn.chenlichao.wmi4j.WMIException;

public class WMIDemo {

    /*
            <!-- wmi -->
        <dependency>
            <groupId>cn.chenlichao</groupId>
            <artifactId>wmi4j</artifactId>
            <version>0.9</version>
        </dependency>
        <dependency>
            <groupId>com.profesorfalken</groupId>
            <artifactId>WMI4Java</artifactId>
            <version>1.6.2</version>
        </dependency>
     */

    /*
        10.1.10.234,efs_user,Edoc123$%^112
        10.1.10.109,efs_user,Edoc123$%^109,d:
        10.1.10.110,efs_user,Edoc123$%^110,d:
        10.1.10.113,efs_user,Edoc123$%^113,h:
        10.1.10.114,efs_user,Edoc123$%^114,e:
        10.1.10.106,efs_user,Edoc123$%^106,d:
        10.1.10.107,efs_user,123456,d:
        10.1.10.111,efs_user,Edoc123$%^111,d:
        10.1.10.105,efs_user,123456,f:
        10.1.10.153,administrator,cpictfs153,e:
         10.1.10.233 administrator Passw0rd

        efs wmi连不上(RPC)
        10.1.10.108,efs_user,Edoc123$%^108
        maximo 连不上
        10.50.2.26,9000_user,cpic3219
        10.1.10.140,administrator,cpic3219
        anyuan 超时 ping不通
        10.30.107.1,administrator,oracle,c:
        10.30.107.2,monitor,123456,d:
        10.30.107.4,administrator,sipo_4_4,d:
    */

    private static String server = "10.1.10.234";
    private static String username = "efs_user";
    private static String password = "Edoc123$%^112";

    private static String namespace = "root\\cimv2";
//    static String namespace = "root\\wmi";

/*

    public static void main(String[] args) throws WMIException, UnknownHostException {
        WMI4J();

//        WMI4Java();
    }

    */
/**
     * 连接远程WMI服务的API
     *
     * @throws WMIException
     * @throws UnknownHostException
     *//*

    private static void WMI4J() throws WMIException, UnknownHostException {
        // 构建连接器
        SWbemLocator locator = new SWbemLocator(server, username, password, namespace);
        SWbemServices connectServer = locator.connectServer();
//        SWbemServices connectServer = locator.connectServer(null,"NTLMDomain:administrator",null,null);
        SWbemObjectSet services = connectServer.instancesOf("win32_process");
        // SWbemObjectSet services = connectServer.instancesOf("win32_process");
        System.out.println("服务数量： " + services.getCount());
        Iterator<SWbemObject> iterator = services.iterator();
        while (iterator.hasNext()) {
            SWbemObject service = iterator.next();
            System.out.println(service.getObjectText());
            System.out.println("-----------------------------------------------");
        }
    }

    */
/**
     * 用于连接本机WMI服务的APi
     *//*

    private static void WMI4Java() {
        List<String> wmiClassesList = WMI4Java.get().namespace("root/WMI").listClasses();
        for (String string : wmiClassesList) {
            System.out.println(string);
        }
        System.out.println(">>>>>>>>>>>>>>>");
        Map<String, String> wmiObjectProperties = WMI4Java.get().VBSEngine().getWMIObject("win32_process");
        Set<Entry<String, String>> entrySet = wmiObjectProperties.entrySet();
        for (Entry<String, String> entry : entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
*/

}
