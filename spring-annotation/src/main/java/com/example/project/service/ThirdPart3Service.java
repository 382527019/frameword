package com.example.project.service;

/**
 * Created with IDEA
 * author:YunGui Hhuang
 * Date:2023/3/26
 * Time:20:19
 */
public class ThirdPart3Service {
    private String des;

    public ThirdPart3Service(){}

    public ThirdPart3Service(String des) {
        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "ThirdPart3Service{" +
                "des='" + des + '\'' +
                '}';
    }
}
