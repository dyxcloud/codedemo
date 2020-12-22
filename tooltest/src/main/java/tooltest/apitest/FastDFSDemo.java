package tooltest.apitest;

import org.apache.commons.io.FilenameUtils;
/*import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;*/

public class FastDFSDemo {
	
   /* public String uploadToFastDfs(byte[] fileBuff, String filename) throws Exception {
        // 1、指定FastDFS配置文件位置,初始化FastDFS配置文件
        ClientGlobal.init(this.getClass().getResource("/fdfs_client.conf").getPath());
        // 2、创建跟踪服务器客户端
        TrackerClient trackerClient = new TrackerClient();
        // 3、获取跟踪服务器服务端
        TrackerServer trackerServer = trackerClient.getConnection();
        // 4、创建存储服务器客户端
        StorageClient1 storageClient = new StorageClient1(trackerServer, null);
        // 5、附件上传操作
        String fileExtname = FilenameUtils.getExtension(filename);
        // fid不包括服务器地址: "group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg"
        String path = storageClient.upload_file1(fileBuff, fileExtname, null);
        return path;
    }
	
	
	public static String uploadToFastDfs() throws Exception{
		ClientGlobal.init(FastDFSDemo.class.getResource("/fdfs_client.conf").getPath());
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
		String file_ext_name = "png";
		String path = storageClient1.upload_file1("E:\\Download\\headTest.png", file_ext_name, null);
		return path;
	}
	
	public static int deleteFromFastDfs() throws Exception{
		ClientGlobal.init(FastDFSDemo.class.getResource("/fdfs_client.conf").getPath());
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		StorageClient1 storageClient1 = new StorageClient1(trackerServer, null);
		int delete = storageClient1.delete_file1("group1/M00/00/01/wKjIgFpAq_eADXgwAAAA5AXcx9k285.png");
		return delete;
	}
	

	public static void main(String[] args) throws Exception {
		//group1/M00/00/01/wKjIgFpAq_eADXgwAAAA5AXcx9k285.png头像
//		System.out.println(uploadToFastDfs());
//		System.out.println(deleteFromFastDfs());
		
		System.out.println(FastDFSDemo.class.getClassLoader());
	}*/
}
