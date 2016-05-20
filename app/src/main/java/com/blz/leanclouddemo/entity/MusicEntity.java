package com.blz.leanclouddemo.entity;

/**
 * Created by BuLingzhuang
 * on 2016/5/20
 * E-mail bulingzhuang@foxmail.com
 */
public class MusicEntity {
    private String objectId;
    private String musicName;
    private String author;
    private String type;
    private String duration;

    public MusicEntity() {
    }

    public MusicEntity(String objectId, String musicName, String author, String type, String duration) {

        this.objectId = objectId;
        this.musicName = musicName;
        this.author = author;
        this.type = type;
        this.duration = duration;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
