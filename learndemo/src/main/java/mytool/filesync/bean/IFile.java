package mytool.filesync.bean;

import java.io.File;

/**
 * @author DongYunxiang
 * @create 2019-12-25
 **/
public abstract class IFile {

    IFile parent;
    String name;
    String path;
    long lastModify;

    public IFile(File f){
        name = f.getName();
        path = f.getParent();
        lastModify = f.lastModified();
    }
}
