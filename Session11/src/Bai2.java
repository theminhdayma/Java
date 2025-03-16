public class Bai2 {
    /*
    * 1. Định Nghĩa:
    * Tính trừu tượng trong lập trình hướng đối tượng là nguyên tắc giúp ẩn đi các chi tiết
    * triển khai bên trong và chỉ hiển thị các chức năng cần thiết cho người dùng.
    * Nhờ đó, lập trình viên có thể tập trung vào cách sử dụng đối tượng mà không cần
    * quan tâm đến cách nó hoạt động bên trong. Trong Java, tính trừu tượng được thực hiện
    * bằng cách sử dụng lớp trừu tượng (abstract class) hoặc giao diện (interface).
    * Điều này giúp mã nguồn dễ bảo trì, tái sử dụng và tăng tính linh hoạt khi phát triển phần mềm.
    *
    *
    * 2. Tại sao cần tính trừu tượng trong phần mềm phức tạp?

    - Phần mềm phức tạp thường bao gồm nhiều thành phần hoạt động cùng nhau.
    * Tính trừu tượng giúp quản lý và tổ chức hệ thống tốt hơn bằng cách ẩn đi các chi tiết
    * triển khai không cần thiết.
    *
    - Nó giúp lập trình viên tập trung vào chức năng chính mà không bị ảnh hưởng bởi
    * các phần cài đặt phức tạp.
    *
    - Việc thay đổi hoặc mở rộng hệ thống dễ dàng hơn vì các thành phần được thiết kế
    * theo cách độc lập với nhau.

    * 3. Sự khác biệt giữa lớp trừu tượng và giao diện trong Java
    * Lớp trừu tượng trong Java có thể chứa cả phương thức trừu tượng và phương thức cụ thể,
    * cho phép khai báo biến instance và hỗ trợ kế thừa đơn (extends).
    * Trong khi đó, giao diện chỉ chứa phương thức trừu tượng (trừ khi dùng default hoặc static),
    * chỉ cho phép hằng số và hỗ trợ đa kế thừa (implements).
    *  Lớp trừu tượng phù hợp để tạo lớp cơ sở với hành vi chung, còn giao diện
    * được dùng để định nghĩa quy tắc cho nhiều lớp khác nhau.
    *
    * 4. Liên hệ thực tế về tính trừu tượng
    - Máy ATM: Người dùng chỉ cần biết cách rút tiền, gửi tiền hoặc kiểm tra số dư.
    * Họ không cần biết chi tiết bên trong như cách máy xác thực tài khoản hoặc xử lý giao dịch.

    - Điều khiển TV: Người dùng chỉ cần bấm nút để chuyển kênh, tăng giảm âm lượng
    * mà không cần hiểu cách tín hiệu truyền tải hoặc cách mạch điện bên trong hoạt động.

    - Ô tô: Người lái chỉ cần sử dụng vô lăng, bàn đạp ga/phanh để điều khiển xe
    *  mà không cần biết chi tiết động cơ hoạt động như thế nào.
    * */
}
