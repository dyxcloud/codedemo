package mytool.filesync.bean;

import java.io.File;

/**
 * @author DongYunxiang
 * @create 2019-12-25
 **/
public class F extends IFile {

    long size;
    String sha1;

    public F(File f){
        super(f);
        size = f.length();
    }

}
