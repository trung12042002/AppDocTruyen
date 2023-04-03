package com.example.ungdungdoctruyen.model;

public class chuyenmuc {

    private String tenchyenmuc;
    private int hinhanhchuyenmuc;

    public chuyenmuc(String tenchyenmuc, int hinhanhchuyenmuc) {
        this.tenchyenmuc = tenchyenmuc;
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }

    public String getTenchyenmuc() {
        return tenchyenmuc;
    }

    public void setTenchyenmuc(String tenchyenmuc) {
        this.tenchyenmuc = tenchyenmuc;
    }

    public int getHinhanhchuyenmuc() {
        return hinhanhchuyenmuc;
    }

    public void setHinhanhchuyenmuc(int hinhanhchuyenmuc) {
        this.hinhanhchuyenmuc = hinhanhchuyenmuc;
    }
}
