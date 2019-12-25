package mytool.filesync.bean;

import java.io.File;
import java.util.Set;

/**
 * @author DongYunxiang
 * @create 2019-12-25
 **/
public class D extends IFile {

    Set<IFile> content;

    public D(File f){
        super(f);
    }

}
