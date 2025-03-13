
/*
* 1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?
- Kế thừa (Inheritance) là một tính năng của lập trình hướng đối tượng (OOP) cho phép một lớp (class)
có thể sử dụng lại các thuộc tính và phương thức từ một lớp khác.
- Lớp con (subclass hoặc child class) kế thừa từ lớp cha (superclass hoặc parent class) bằng cách sử dụng từ khóa extends.
- Kế thừa giúp tái sử dụng mã nguồn (code reusability), giảm trùng lặp, và tạo ra cấu trúc phân cấp giữa các lớp.
- Giúp tổ chức mã nguồn một cách logic, dễ mở rộng và bảo trì.
*
*
* Đặc điểm                       	      Kế thừa (Inheritance)	                                        Đóng gói (Encapsulation)
Khái niệm:	            Cho phép một lớp kế thừa thuộc tính, phương thức từ lớp khác	  Bảo vệ dữ liệu và kiểm soát quyền truy cập của dữ liệu trong lớp
Từ khóa sử dụng:                             extends                                                   private, protected, public
Mục đích:	                    Tái sử dụng mã nguồn, giảm trùng lặp	                          Che giấu thông tin và bảo vệ dữ liệu
Cách thức hoạt động:	       Lớp con kế thừa từ lớp cha và có thể ghi đè phương thức	       Các biến được khai báo private, truy cập thông qua getter/setter
*
*
*
*
* */


class Animal {
    String name;

    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Dogs extends Animal {
    public void bark() {
        System.out.println(name + " is barking");
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Dogs myDog = new Dogs();
        myDog.name = "Buddy";
        myDog.makeSound();
        myDog.bark();
    }
}

/*
* 4. Lợi ích và hạn chế của kế thừa trong Java
 + Lợi ích
     - Tái sử dụng mã nguồn: Giúp giảm trùng lặp mã bằng cách kế thừa các thuộc tính và phương thức từ lớp cha.
     - Dễ mở rộng: Có thể mở rộng lớp cha bằng cách tạo các lớp con có chức năng riêng.
     - Tính tổ chức tốt: Mã nguồn dễ đọc hơn do có quan hệ phân cấp rõ ràng giữa các lớp.

 + Hạn chế
     - Tăng sự phụ thuộc giữa các lớp: Nếu lớp cha thay đổi, các lớp con có thể bị ảnh hưởng.
     - Không hỗ trợ đa kế thừa trực tiếp: Java không cho phép một lớp kế thừa nhiều lớp cha (để tránh vấn đề diamond problem).
     - Có thể gây khó khăn khi bảo trì: Khi lớp cha quá lớn và phức tạp, việc sửa đổi có thể ảnh hưởng đến nhiều lớp con.
* */
