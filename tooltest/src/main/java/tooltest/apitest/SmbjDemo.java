package tooltest.apitest;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.msfscc.fileinformation.FileAllInformation;
import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import com.hierynomus.smbj.share.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static java.util.EnumSet.*;

/**
 * @author DongYunxiang
 * @create 2020-03-24
 **/
public class SmbjDemo {

    // static final String host = "10.52.22.3";
    // static final String username = "dzwddoc40";
    // static final String password = "1qaz!2wsx";
    // static final String leadDir = "dzwddoc40";

    static final String host = "10.50.1.43";
    static final String username = "dzwddoc30";
    static final String password = "1qaz2wsx";
    static final String leadDir = "dzwddoc30/doc218";

    static SmbConfig config = SmbConfig.builder()
            .withTimeout(120, TimeUnit.SECONDS)
            .withSoTimeout(180, TimeUnit.SECONDS)
            .build();

    Connection connection;
    DiskShare share;

    @Before
    public void before() throws IOException {
        SMBClient smbClient = new SMBClient(config);
        connection = smbClient.connect(host);
        AuthenticationContext ac = new AuthenticationContext(username, password.toCharArray(), null);
        Session session = connection.authenticate(ac);
        share = (DiskShare) session.connectShare(leadDir);
    }

    @After
    public void after() throws IOException {
        if (connection != null)
            connection.close();
        if (share != null)
            share.close();
    }

    @Test
    public void look() {
        for (FileIdBothDirectoryInformation f : share.list("")) {
            System.out.print("File : " + f.getFileName());
            System.out.println("File : " + f.getAllocationSize());
        }
    }

    @Test
    public void download() throws IOException {
        String source = "533387891.zip";
        String target = "D:\\Download\\zxc.zip";
        boolean b = share.fileExists(source);
        System.out.println(b);
        FileAllInformation fileInformation = share.getFileInformation(source);
        System.out.println(fileInformation.getStandardInformation().getAllocationSize());

        File smbFileRead = share.openFile(source
                , EnumSet.of(AccessMask.GENERIC_READ), null
                , SMB2ShareAccess.ALL, SMB2CreateDisposition.FILE_OPEN, null);
        try (InputStream in = smbFileRead.getInputStream();
             BufferedInputStream bin = new BufferedInputStream(in);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] bytes = new byte[2048];
            int len = 0;
            while ((len = bin.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        }
    }

    @Test
    public void mkdir(){
        String target = "Download\\a\\w\\q";
        System.out.println(share.fileExists(target));
        share.mkdir(target);
    }

    @Test
    public void upload() throws IOException {
        String source = "D:\\Download\\Z.jpg";
        String filePath = "Znewupload.jpg";
        // 层级文件夹不存在 还要创建
        File file = share.openFile(filePath
                , of(AccessMask.GENERIC_ALL)
                , of(FileAttributes.FILE_ATTRIBUTE_NORMAL)
                , SMB2ShareAccess.ALL
                , SMB2CreateDisposition.FILE_CREATE
                , of(SMB2CreateOptions.FILE_DIRECTORY_FILE));
        try(OutputStream out = file.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source))){
            byte[] bytes = new byte[2048];
            int len = 0;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        }
    }

    @Test
    public void delete() {
        share.rm("Znewupload.jpg");
    }

}
