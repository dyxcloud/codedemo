package mytool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 重命名P站图片,将图片后缀_p0_master1200删除
 * @author DongYunxiang
 * @create 2018-11-22
 **/
public class PixivImgRenameUtil {

    public static void main(String[] args) throws IOException {
        String dir = "D:/Download/Date";
        String oldStr = "_master1200";
        String newStr = "";
        doRename(dir,oldStr,newStr);
        oldStr = "_p0";
        doRename(dir,oldStr,newStr);
    }

    private static void doRename(String dir,String oldStr, String newStr) throws IOException {
        Files.list(Paths.get(dir))
                .filter(path -> path.toFile().isFile())
                .forEach(path -> {
            String oldName = path.getFileName().toString();
            File oldFile = path.toFile();
            boolean b = oldFile.renameTo(new File(oldFile.getParent(),oldName.replace(oldStr,newStr)));
            if(!b) System.out.println(oldName);
        });
    }
}
