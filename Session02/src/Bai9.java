import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ngày: ");
        int day = sc.nextInt();
        System.out.print("Nhập tháng: ");
        int month = sc.nextInt();
        System.out.print("Nhập năm: ");
        int year = sc.nextInt();

        int[] nextDate = getNextDay(day, month, year);

        System.out.println("Ngày tiếp theo là: " + nextDate[0] + "/" + nextDate[1] + "/" + nextDate[2]);

        System.out.println("Nhập ngày thứ nhất:");
        System.out.print("Nhập ngày: ");
        int day1 = sc.nextInt();
        System.out.print("Nhập tháng: ");
        int month1 = sc.nextInt();
        System.out.print("Nhập năm: ");
        int year1 = sc.nextInt();

        System.out.println("Nhập ngày thứ hai:");
        System.out.print("Nhập ngày: ");
        int day2 = sc.nextInt();
        System.out.print("Nhập tháng: ");
        int month2 = sc.nextInt();
        System.out.print("Nhập năm: ");
        int year2 = sc.nextInt();

        int daysBetween = countDaysBetween(day1, month1, year1, day2, month2, year2);
        System.out.println("Số ngày giữa hai ngày là: " + daysBetween);

        sc.close();
    }

    // Hàm kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Hàm tính ngày tiếp theo
    public static int[] getNextDay(int day, int month, int year) {
        if (month == 2) { // Tháng 2
            if (isLeapYear(year)) {
                if (day == 29) {
                    day = 1;
                    month++;
                } else {
                    day++;
                }
            } else {
                if (day == 28) {
                    day = 1;
                    month++;
                } else {
                    day++;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day == 30) {
                day = 1;
                month++;
            } else {
                day++;
            }
        } else {
            if (day == 31) {
                day = 1;
                if (month == 12) {
                    month = 1;
                    year++;
                } else {
                    month++;
                }
            } else {
                day++;
            }
        }

        return new int[]{day, month, year};
    }

    // Hàm đếm số ngày giữa hai ngày
    public static int countDaysBetween(int day1, int month1, int year1, int day2, int month2, int year2) {
        int count = 0;

        while (day1 != day2 || month1 != month2 || year1 != year2) {
            int[] nextDate = getNextDay(day1, month1, year1);
            day1 = nextDate[0];
            month1 = nextDate[1];
            year1 = nextDate[2];
            count++;
        }

        return count;
    }
}
