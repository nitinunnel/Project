package com.example.acer.project.model;

/**
 * Created by acer on 12/9/2017.
 */

// class ที่เป็น model ให้กับ ArrayList
public class Potter {
    public final String quiz;
    public final int picture;
    public final String rightans;
    public final String wrongans;

    public Potter(String quiz, int picture, String rightans, String wrongans) {
        this.quiz = quiz;
        this.picture = picture;
        this.rightans = rightans;
        this.wrongans = wrongans;
    }
}
