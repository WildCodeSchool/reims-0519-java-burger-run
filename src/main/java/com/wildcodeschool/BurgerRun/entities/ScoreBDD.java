package com.wildcodeschool.BurgerRun.entities;

public class ScoreBDD {
    private int id;
    private String nickname;
    private int steak_score;

    public ScoreBDD(int id, String nickname, int steak_score) {
        this.id = id;
        this.nickname = nickname;
        this.steak_score = steak_score;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSteak_score() {
        return steak_score;
    }

    public void setSteak_score(int steak_score) {
        this.steak_score = steak_score;
    }

}