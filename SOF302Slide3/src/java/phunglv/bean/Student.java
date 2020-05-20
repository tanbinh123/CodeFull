package phunglv.bean;

public class Student {
    private int masv;
    private String name;
    private Double mark;
    private String major;

    public Student(){}

    public Student(int masv, String name, Double mark, String major) {
        this.masv = masv;
        this.name = name;
        this.mark = mark;
        this.major = major;
    }
    
    public Student(String name, Double mark, String major) {
            this.name = name;
            this.mark = mark;
            this.major = major;
    }

    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }
    public Double getMark() {
            return mark;
    }
    public void setMark(Double mark) {
            this.mark = mark;
    }
    public String getMajor() {
            return major;
    }
    public void setMajor(String major) {
            this.major = major;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }
        
}
