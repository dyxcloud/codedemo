package tooltest.apitest;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import java.io.IOException;
import java.net.MalformedURLException;

public class CIFSDemo {

    
    public static void linkFileList() throws SmbException, MalformedURLException {
        // xxx:xxx是共享机器的用户名密码, 用户名不等同于登录邮箱
        // String url="smb://192.168.2.188/testIndex/";// 无密码要求的URL,未成功
        // String url = "smb://Administrator:qwer@127.0.0.1/e/Download/";
        // String url = "smb://dzwddoc28:1qaz2wsx@10.50.1.41/dzwddoc28/doc214/";
        String url = "smb://dzwddoc29:1qaz2wsx@10.50.1.43/dzwddoc29/";
        SmbFile file = new SmbFile(url);
        if (file.exists()) {
            SmbFile[] files = file.listFiles();
            for (SmbFile f : files) {
                System.out.println(f.getName()+ " length:"+f.length());
            }
        }
    }

    public static void linkFile() throws MalformedURLException, SmbException {
        String url = "smb://Administrator:qwe@127.0.0.1/Users/Administrator/Desktop/TIM截图20180129170304.png";
        System.out.println("getting");
        SmbFile file = new SmbFile(url);
        System.out.println(file.exists());
        System.out.println(file.length());
    }
    
    public void stream() throws IOException {
        SmbFile smbFile = new SmbFile("smb://test:test@10.218.100.12/share2/aa.txt");
        // 通过 smbFile.isDirectory();isFile()可以判断smbFile是文件还是文件夹
        int length = smbFile.getContentLength();// 得到文件的大小
        byte buffer[] = new byte[length];
        SmbFileInputStream in = new SmbFileInputStream(smbFile); // 建立smb文件输入流
        while ((in.read(buffer)) != -1) {
            System.out.write(buffer);
            System.out.println(buffer.length);
        }
        in.close();
    }
    
    
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        linkFileList();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
//        linkFile();
    }
}
