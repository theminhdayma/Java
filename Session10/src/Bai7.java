class Student {
    protected String name;
    protected String id;
    protected double gpa;

    public Student(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.trim().isEmpty()) {
            this.id = id;
        }
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 4.0) {
            this.gpa = gpa;
        }
    }

    public String getDetails() {
        return "Tên: " + name + ", Mã SV: " + id + ", GPA: " + gpa;
    }
}

class GraduateStudent extends Student {
    private String researchTopic;
    private String supervisorName;

    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        if (researchTopic != null && !researchTopic.trim().isEmpty()) {
            this.researchTopic = researchTopic;
        }
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        if (supervisorName != null && !supervisorName.trim().isEmpty()) {
            this.supervisorName = supervisorName;
        }
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Đề tài: " + researchTopic + ", Giảng viên hướng dẫn: " + supervisorName;
    }
}

public class Bai7 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Nguyễn Thế Minh", "SV001", 3.2),
                new GraduateStudent("Trần Nho Hà", "SV002", 3.8, "Trí tuệ nhân tạo", "TS. Nguyễn Văn Cảnh"),
                new GraduateStudent("", "SV003", 2.9, "", "")
        };

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getDetails());
        }
    }
}
