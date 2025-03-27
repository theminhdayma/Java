package Bai10;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true));

        LocalDate currentDate = LocalDate.of(2025, 3, 23);

        List<Task> overdueTasks = tasks.stream()
                .filter(task -> !task.isCompleted() && task.getDueDate().isBefore(currentDate))
                .toList();

        System.out.println("== Công việc quá hạn chưa hoàn thành ==");
        overdueTasks.forEach(task -> System.out.printf("- %s (Giao cho: %s, hạn chót: %s)\n",
                task.getTitle(), task.getAssignedTo().getName(), task.getDueDate()));

        double completedTasksCount = tasks.stream().filter(Task::isCompleted).count();
        System.out.println("\nTổng số công việc đã hoàn thành: " + completedTasksCount);

        System.out.println("\n== Thống kê công việc theo người dùng ==");
        Map<User, List<Task>> tasksByUser = tasks.stream()
                .collect(Collectors.groupingBy(Task::getAssignedTo));

        tasksByUser.forEach((user, userTasks) -> {
            double overdueCount = userTasks.stream()
                    .filter(task -> !task.isCompleted() && task.getDueDate().isBefore(currentDate))
                    .count();
            System.out.printf("- Tên: %-6s | Email: %-20s | Tổng việc: %d | Quá hạn: %.0f\n",
                    user.getName(), user.getEmail().orElse("Không có email"), userTasks.size(), overdueCount);
        });
    }
}