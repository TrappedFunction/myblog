package com.tf.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String account;
    @TableField(select = false)
    private String password;

    private String salt;
    @TableLogic(value = "0", delval = "1")
    private Integer deleted;

    public User(String username, String account, String password) {
        this.username = username;
        this.account = account;
        this.password = password;
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
