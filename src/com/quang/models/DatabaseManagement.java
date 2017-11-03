package com.quang.models;

import com.quang.connect.DatabaseConnect;
import com.quang.models.entity.User;

public class DatabaseManagement {
    public boolean checkUser(String username, String password) {
        DatabaseConnect connect = new DatabaseConnect();
        return connect.checkUser(username, password);
    }

    public boolean register(User user) {
        DatabaseConnect connect = new DatabaseConnect();
        return connect.insertUser(user);
    }

    public boolean modify(User user){
        DatabaseConnect connect = new DatabaseConnect();
        return connect.modyfyUser(user);
    }
}
