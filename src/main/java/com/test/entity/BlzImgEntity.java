package com.test.entity;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/15.
 */
public class BlzImgEntity {

    private String id;

    private String imgName;

    private String imgUrl;

    private int imgSize;

    private String imgGroup;

    private String imgSource;

    private String imgNameCH;

    private String imgDescripe;

    private Date updateTime;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getImgSize() {
        return imgSize;
    }

    public void setImgSize(int imgSize) {
        this.imgSize = imgSize;
    }

    public String getImgGroup() {
        return imgGroup;
    }

    public void setImgGroup(String imgGroup) {
        this.imgGroup = imgGroup;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgNameCH() {
        return imgNameCH;
    }

    public void setImgNameCH(String imgNameCH) {
        this.imgNameCH = imgNameCH;
    }

    public String getImgDescripe() {
        return imgDescripe;
    }

    public void setImgDescripe(String imgDescripe) {
        this.imgDescripe = imgDescripe;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
