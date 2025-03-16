package Bai10;

class Manager extends Employee implements AttendMeeting {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Quản lý " + name + " (Lương: $" + salary + ") đang giám sát dự án");
    }

    @Override
    public void takeVacation() {
        System.out.println("Quản lý " + name + " (Lương: $" + salary + ") đang đi nghỉ phép tại Pháp.");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Quản lý " + name + " (Lương: $" + salary + ") đang tham gia cuộc họp");
    }
}
