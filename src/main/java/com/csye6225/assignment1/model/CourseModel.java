package com.csye6225.assignment1.model;

import java.util.List;

public class CourseModel {

    private String title;
    private List<LectureModel> lectures;
    private String board;
    private List<StudentModel> roster;
    private List<StudentModel> students;
    private ProfessorModel professor;
    private StudentModel ta;

    public CourseModel() {

    }

    public List<LectureModel> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureModel> lectures) {
        this.lectures = lectures;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public List<StudentModel> getRoster() {
        return roster;
    }

    public void setRoster(List<StudentModel> roster) {
        this.roster = roster;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }

    public StudentModel getTa() {
        return ta;
    }

    public void setTa(StudentModel ta) {
        this.ta = ta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
