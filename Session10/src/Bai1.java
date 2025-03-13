
/*1. Tính đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
 * Tính đóng gói (Encapsulation) là một nguyên tắc quan trọng trong lập trình hướng đối tượng (OOP),
 * trong đó dữ liệu (thuộc tính) của một đối tượng được bảo vệ khỏi sự truy cập trực tiếp từ bên ngoài.
 *
 * Tại sao tính đóng gói quan trọng?
      - Bảo vệ dữ liệu: Ngăn chặn sự thay đổi trực tiếp từ bên ngoài, giúp đảm bảo tính toàn vẹn của dữ liệu.
      - Kiểm soát quyền truy cập: Chỉ cho phép truy cập hoặc sửa đổi dữ liệu thông qua các phương thức cụ thể (getter, setter).
      - Dễ bảo trì và mở rộng: Khi cần thay đổi logic xử lý dữ liệu, chỉ cần chỉnh sửa bên trong lớp mà không ảnh hưởng đến phần còn lại của chương trình.
      - Tăng tính mô-đun hóa: Mỗi lớp có thể được thiết kế để hoạt động như một hộp đen với giao diện rõ ràng, giúp mã dễ hiểu hơn.
 *
 *
 * 2. Làm thế nào để áp dụng tính đóng gói trong Java? Giải thích cách sử dụng các phương thức getter và setter.
 *  Định nghĩa các thuộc tính của lớp với phạm vi private, ngăn chặn truy cập trực tiếp từ bên ngoài.
    Cung cấp các phương thức getter (để lấy giá trị) và setter (để thiết lập giá trị) với phạm vi public,
    cho phép kiểm soát việc truy cập và thay đổi dữ liệu.
 *
 * Cách sử dụng phương thức getter và setter:
        - Getter: Trả về giá trị của một thuộc tính.
        - Setter: Thiết lập giá trị mới cho thuộc tính, có thể bổ sung kiểm tra hợp lệ trước khi gán.
 *
 *  3. Ví dụ về cách sử dụng tính đóng gói trong một lớp có thuộc tính name, age
 * */
 class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Tuổi không hợp lệ!");
        }
    }
}

public class Bai1 {
    public static void main(String[] args) {
        Person person = new Person();

        person.setName("Nguyễn Thế Minh");
        person.setAge(25);

        System.out.println("Tên: " + person.getName());
        System.out.println("Tuổi: " + person);

    }
}

 /* 4. Lợi ích của việc sử dụng tính đóng gói trong việc bảo vệ dữ liệu và kiểm soát quyền truy cập

  - Bảo vệ dữ liệu: Ngăn chặn truy cập trực tiếp từ bên ngoài, đảm bảo dữ liệu không bị thay đổi bất hợp pháp.
  - Kiểm soát quyền truy cập: Chỉ cho phép thay đổi dữ liệu theo cách mà lập trình viên quy định (ví dụ: kiểm tra hợp lệ trước khi gán giá trị).
  - Dễ bảo trì: Khi thay đổi cách xử lý dữ liệu bên trong lớp, không cần chỉnh sửa code bên ngoài đang sử dụng lớp đó.
  - Tăng tính linh hoạt: Có thể thêm logic kiểm tra hợp lệ trước khi thay đổi dữ liệu.
  - Tạo mã nguồn sạch và dễ hiểu hơn: Tách biệt rõ ràng giữa dữ liệu và cách truy cập vào dữ liệu.
*/
