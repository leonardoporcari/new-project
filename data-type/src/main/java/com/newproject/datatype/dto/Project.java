package com.newproject.datatype.dto;

public class Project {
    private boolean isGraded;
    private int grade;

    public Project(){
        this.isGraded= false;
    }

    public int getGrade(){
        if(isGraded) return this.grade;
        else return 0;
    }
}
