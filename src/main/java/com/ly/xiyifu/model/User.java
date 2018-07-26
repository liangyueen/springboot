package com.ly.xiyifu.model;

import lombok.Data;

import java.util.Date;

/**
 * 文件名称： User
 * <p>
 * 包路径： book.store.model
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：系统集成测试类
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/24 - 14:23
 * <p>
 * 修改记录：
 */
@Data
public class User extends PageModel {

    private String userId;

    private String realName;

    private String nickName;

    private String phone;

    private Date createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
