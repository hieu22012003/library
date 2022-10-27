package student.studentl;

public class Student {
    String name;
    String email;
    Integer mark;

    public Student(String name, String email, Integer mark) {
        this.name = name;
        this.email = email;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return getName()+"-"+getEmail()+"-"+getMark();
    }
}