package com.dhd.crowerdemo;

/**
 * Created by Administrator on 2018/5/22.
 */

public class DuanziInfo {
    private String id;
    private String tittle;
    private String contents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "DuanziInfo{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
