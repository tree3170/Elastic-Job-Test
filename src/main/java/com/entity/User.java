package com.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Author hedehe
 * Date   16/6/19 10:49
 *
 * 用户签署账户信息
 */
public class User implements Serializable {

    private static final long serialVersionUID = -511185923772115733L;

    /**
     * 主键
     */
    private long id;

    /**
     * 用户ID
     */
    private long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 身份证
     */
    private String idCardNo;

    /**
     * MD5加密后的16字符串（用户名称+手机号+身份证）
     */
    private String md5Str;

    /**
     * 账户标识(签署商家的账户ID)
     */
    private String accountId;

    /**
     * 手绘印章图片Base64的路径（mongodb的objectID）
     */
    private String imgSignPath;

    /**
     * 电子印章数据的保存路径（mongodb的objectID）
     */
    private String sealDataPath;

    /**
     * 状态
     * @see
     */
    private int status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 获取加密原串
     * @return
     */
    public String getMD5SourceStr(){
        return this.userName + this.mobile + this.idCardNo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getMd5Str() {
        return md5Str;
    }

    public void setMd5Str(String md5Str) {
        this.md5Str = md5Str;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getImgSignPath() {
        return imgSignPath;
    }

    public void setImgSignPath(String imgSignPath) {
        this.imgSignPath = imgSignPath;
    }

    public String getSealDataPath() {
        return sealDataPath;
    }

    public void setSealDataPath(String sealDataPath) {
        this.sealDataPath = sealDataPath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserSignAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", md5Str='" + md5Str + '\'' +
                ", accountId='" + accountId + '\'' +
                ", imgSignPath='" + imgSignPath + '\'' +
                ", sealDataPath='" + sealDataPath + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

