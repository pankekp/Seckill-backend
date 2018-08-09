package pers.pk.seckill.util.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import pers.pk.seckill.domain.User;

public class UserUtil {

    private static void createUser(int count) throws Exception {
        List<User> users = new ArrayList<>(count);
        //生成用户
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(100000 + i);
            user.setUsername("user" + i);
            user.setPassword("12345678");
            users.add(user);
        }
        System.out.println("create user finished");

//        //插入数据库
//        Connection conn = DBUtil.getConn();
//        String sql = "insert into user(id,username,password)values(?,?,?)";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        for (int i = 0; i < users.size(); i++) {
//            User user = users.get(i);
//            pstmt.setInt(1, user.getId());
//            pstmt.setString(2, user.getUsername());
//            pstmt.setString(3, user.getPassword());
//            pstmt.addBatch();
//        }
//        pstmt.executeBatch();
//        pstmt.close();
//        conn.close();
//        System.out.println("insert to db finished");

        //登录生成token
        File file = new File("/home/panke/Workspace/Jmeter/token.txt");
        if (file.exists()) {
            file.delete();
        }
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        file.createNewFile();
        raf.seek(0);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String urlString = "http://39.104.112.178:90/token?username=" + user.getUsername() + "&password=" + user.getPassword();
            URL url = new URL(urlString);
            HttpURLConnection co = (HttpURLConnection) url.openConnection();
            co.setRequestMethod("GET");
            co.setDoOutput(false);
            co.setDoInput(true);
            co.setRequestProperty("Content-Type", "application/json");
            co.connect();
            InputStream inputStream = co.getInputStream();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte buff[] = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buff)) >= 0) {
                bout.write(buff, 0, len);
            }
            inputStream.close();
            bout.close();
            String token = new String(bout.toByteArray());
            System.out.println("create token : " + user.getId());

            String row = user.getId() + "," + token;
            raf.seek(raf.length());
            raf.write(row.getBytes());
            raf.write("\r\n".getBytes());
            System.out.println("write to file : " + user.getId());
        }
        raf.close();

        System.out.println("over");
    }

    public static void main(String[] args) throws Exception {
        createUser(5000);
    }
}
