package cn.jdbc.db2Work;

import cn.jdbc.C3p0Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author DongYunxiang
 * @create 2018-09-17
 **/
public class FindFsid {


    public static void main(String[] args) throws SQLException {
        for(int i=0;i<10;i++){
            boolean b = take1000();
            if(!b) break;
        }
    }

    private static boolean take1000()  throws SQLException{
        List<Long> longs = getfsidList();
        for (long fsid : longs) {
            int i1 = 0, i2 = 0;
            if (getFileDate(fsid).startsWith("2018")) {
                long newfsid = getFSID("laptop");
                i1 = update("update ADM_FILE set FSID=" + newfsid + " where fsid=" + fsid);
                i2 = update("update ADM_COMPARE_C4 set fsid=" + newfsid + " where fsid=" + fsid + " and table_name='ADM_FILE'");
                if (i2 == 0)
                    i2 = update("update ADM_COMPARE_C4 set fsid=" + newfsid + " where fsid=" + fsid + " and table_name='adm_file'");
                System.out.println("i1[" + i1 + "],i2[" + i2 + "]");
                if (i1 != 1 || i2 != 1) {
                    System.out.println("!!!! error fsid[" + fsid + "] newfsid[" + newfsid + "]");
                    return false;
                }
            } else if (getNoticeDate(fsid).startsWith("2018")) {
                long newfsid = getFSID("laptop");
                i1 = update("update ADM_NOTICE set FSID=" + newfsid + " where fsid=" + fsid);
                i2 = update("update ADM_COMPARE_C4 set fsid=" + newfsid + " where fsid=" + fsid + " and table_name='ADM_NOTICE'");
                if (i2 == 0)
                    i2 = update("update ADM_COMPARE_C4 set fsid=" + newfsid + " where fsid=" + fsid + " and table_name='adm_notice'");
                System.out.println("i1[" + i1 + "],i2[" + i2 + "]");
                if (i1 != 1 || i2 != 1) {
                    System.out.println("!!!! error fsid[" + fsid + "] newfsid[" + newfsid + "]");
                    return false;
                }
            }
        }

        if(longs.size()<1000) return false;
        for (Long l : longs) {
            System.out.println(l + ",");
        }
        return true;
    }

    private static List<Long> getfsidList() {
        ArrayList<Long> longs = new ArrayList<>(1000);
        String sql = "select fsid from ADM_COMPARE_C4 where fsid BETWEEN 300000000 and 305583959 group by fsid HAVING count(fsid)>1 fetch first 1000 rows only";
        try (Connection conn = C3p0Utils.getConnection();
             Statement statement = conn.createStatement(); // 获得执行对象
             ResultSet resultSet = statement.executeQuery(sql);// 执行sql语句
        ) {
            while (resultSet.next()) {// 处理结果集
                longs.add(resultSet.getLong("fsid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return longs;
    }


    private static String getFileDate(long fsid) {
        String sql = "select * from EDOCEFS.ADM_FILE where fsid=" + fsid;
        try (Connection conn = C3p0Utils.getConnection();
             Statement statement = conn.createStatement(); // 获得执行对象
             ResultSet resultSet = statement.executeQuery(sql);// 执行sql语句
        ) {
            if (resultSet.next()) {// 处理结果集
                return resultSet.getString("process_date");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getNoticeDate(long fsid) {
        String sql = "select * from EDOCEFS.ADM_NOTICE where fsid=" + fsid;
        try (Connection conn = C3p0Utils.getConnection();
             Statement statement = conn.createStatement(); // 获得执行对象
             ResultSet resultSet = statement.executeQuery(sql);// 执行sql语句
        ) {
            if (resultSet.next()) {// 处理结果集
                return resultSet.getString("send_date");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static long getFSID(String hostName) {
        // 取一个随机数和主机名组成一个字符串
        int randNum = new Random().nextInt(899) + 100;
        String randString = hostName + "." + randNum;
        CallableStatement statement = null;
        Connection conn = null;
        try {
            conn = C3p0Utils.getConnectionForTemp();
            // 对象调用存储过程
            statement = conn.prepareCall("{?=call EDOCEFS.FSIDDISPATCH(?,?)}");
            statement.setInt(2, 1);
            statement.setString(3, randString);
            statement.registerOutParameter(1, Types.BIGINT);
            statement.execute();
            long fsid = statement.getLong(1);
            if (fsid < 1000) throw new RuntimeException("error fsid");
            return fsid;
        } catch (Exception e) {
            throw new RuntimeException("error fsid");
        } finally {
            try {
                conn.close();
                if (statement != null) statement.close();
            } catch (Exception ignored) {
            }
        }
    }

    private static int update(String sql) throws SQLException {
        Connection conn = C3p0Utils.getConnection();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            return statement.executeUpdate(sql);
        } finally {
            conn.close();
            if (statement != null) statement.close();
        }
    }

}
