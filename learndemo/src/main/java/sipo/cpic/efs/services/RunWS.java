package sipo.cpic.efs.services;

public class RunWS {

    public static void main(String[] args) {
        GetFileWSService getFileWSService = new GetFileWSService();
        GetFileWS ws = getFileWSService.getGetFileWSSoapPort();
        String fid = "PCTSA20180418037109";
        String version = "1";
        String s = ws.retrieveFile(fid, version);
        System.out.println(s);
    }
}
