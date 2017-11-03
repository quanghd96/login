package com.quang.connect;

import com.quang.models.entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseConnect {
    public static Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://node161069-env-0233725.j.layershift.co.uk/hello?useUnicode=true&amp;characterEncoding=utf8", "root", "QRlhNULEPF");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/hello?useUnicode=true&amp;characterEncoding=utf8", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean checkUser(String username, String password) {
        Connection connection = getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username = \"" +
                    username + "\"");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("password").equals(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertUser(User user) {
        Connection connection = getConnect();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            connection.prepareStatement("INSERT INTO user (username,ngaysinh,quequan,password,hoten) VALUES " +
                    "(\"" + user.getUsername() + "\",\"" + simpleDateFormat.format(user.getNgaysinh()) +
                    "\", \"" + user.getQuequan() + "\", \"" + user.getPassword() +
                    "\", \"" + user.getHoten() + "\")").execute();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modyfyUser(User user) {
        Connection connection = getConnect();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            if (user.getPassword().length() > 0) {
                connection.prepareStatement("UPDATE user SET ngaysinh = \"" + simpleDateFormat.format(user.getNgaysinh()) +
                        "\", quequan = \"" + user.getQuequan() + "\", password = \"" + user.getPassword() +
                        "\", hoten = \"" + user.getHoten() + "\" WHERE username = \"" + user.getUsername() + "\"").execute();
            } else {
                connection.prepareStatement("UPDATE user SET ngaysinh = \"" + simpleDateFormat.format(user.getNgaysinh()) +
                        "\", quequan = \"" + user.getQuequan() +
                        "\", hoten = \"" + user.getHoten() + "\" WHERE username = \"" + user.getUsername() + "\"").execute();
            }
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String username) {
        Connection connection = getConnect();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE username = \"" + username + "\"");
            ResultSet rs = ps.executeQuery();
            if (rs.wasNull()) return null;
            while (rs.next()) {
                String hoten = rs.getString("hoten");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
                Date ngaysinh = simpleDateFormat.parse(rs.getString("ngaysinh"));
                String quequan = rs.getString("quequan");
                String password = rs.getString("password");
                connection.close();
                return new User(hoten, ngaysinh, quequan, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
