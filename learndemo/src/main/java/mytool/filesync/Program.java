package mytool.filesync;

import mytool.filesync.bean.D;
import mytool.filesync.bean.F;
import mytool.filesync.bean.IFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author DongYunxiang
 * @create 2019-12-25
 **/
public class Program {

    /*
    文件比对依据 路径/文件名, 大小/修改日期

    文件同步可能出现的操作:
        添加
        修改 内容
        删除
        修改 路径/文件名

     */


    public IFile walk(File root){
        if (root==null) return null;
        if(root.isFile()) {return new F(root);}

        D r = new D(root);


        return null;
    }


    public static void main(String[] args) throws IOException {
        String target = "D:/Download/workspace/";
        Files.list(Paths.get(target)).forEach(System.out::println);
        System.out.println("========");
        Files.walk(Paths.get(target), FileVisitOption.FOLLOW_LINKS).forEach(System.out::println);

    }
}
