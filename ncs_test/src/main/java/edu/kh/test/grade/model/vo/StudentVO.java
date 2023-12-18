package edu.kh.test.grade.model.vo;

public class StudentVO {
    private String studentNumber;
    private String studentName;
    private int koreanScore;
    private int englishScore;
    private int mathScore;

    public StudentVO() {}

    public StudentVO(String studentNumber, String studentName, int koreanScore, int englishScore, int mathScore) {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getKoreanScore() {
        return koreanScore;
    }

    public void setKoreanScore(int koreanScore) {
        this.koreanScore = koreanScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }
}
