create database employeeManagement;
use employeeManagement;

create table users
(
    user_name varchar(50) not null,
    password  varchar(20) not null,
    status    bit
);

insert into users(user_name, password, status)
values ('admin', 'admin', 1);

create table departments
(
    department_id   int primary key auto_increment,
    department_name varchar(100) not null check (length(department_name) >= 10),
    description     varchar(255),
    status          bit
);

INSERT INTO departments (department_name, description, status) VALUES
   ('Phòng Nhân sự', 'Quản lý tuyển dụng và phúc lợi nhân viên', 1),
   ('Phòng Kỹ thuật', 'Phụ trách hệ thống công nghệ và kỹ thuật', 1),
   ('Phòng Marketing', 'Thực hiện quảng bá và tiếp thị sản phẩm', 1),
   ('Phòng Tài chính', 'Quản lý ngân sách và tài chính công ty', 1),
   ('Phòng Chăm sóc KH', 'Chăm sóc và hỗ trợ khách hàng', 1),
   ('Phòng Pháp chế', 'Xử lý các vấn đề pháp lý và hợp đồng', 1),
   ('Phòng Nghiên cứu', 'Nghiên cứu thị trường và sản phẩm mới', 1),
   ('Phòng Kinh doanh', 'Phụ trách bán hàng và tìm kiếm khách hàng', 1),
   ('Phòng Hành chính', 'Quản lý công việc hành chính và văn phòng', 1),
   ('Phòng Đào tạo', 'Đào tạo và phát triển kỹ năng cho nhân viên', 1);




create table employees
(
    employee_id   char(5) primary key not null unique,
    employee_name varchar(150)        not null check (length(employee_name) >= 15),
    email         varchar(100)        not null unique,
    phone_number  char(10)            not null unique,
    gender        enum ('MALE', 'FEMALE', 'OTHER'),
    level_salary  int                 not null check (level_salary > 0),
    salary        decimal(15, 2)      not null check (salary > 0),
    date_of_birth date,
    address       varchar(250)        not null,
    status        enum ('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE'),
    department_id int,
    foreign key (department_id) references departments (department_id)
);

INSERT INTO employees (employee_id, employee_name, email, phone_number, gender, level_salary,
                       salary, date_of_birth, address, status, department_id) VALUES
    ('E0001', 'Nguyễn Văn Anfjek', 'an.nguyen@example.com', '0912345678', 'MALE', 3, 15000000.00, '1990-05-12', '123 Đường Láng, Hà Nội', 'ACTIVE', 1),
    ('E0002', 'Trần Thị Bìnhhekjcas', 'binh.tran@example.com', '0912345679', 'FEMALE', 2, 12000000.00, '1992-07-18', '45 Nguyễn Trãi, Hà Nội', 'ACTIVE', 2),
    ('E0003', 'Phạm Minh Chiếnclas', 'chien.pham@example.com', '0912345680', 'MALE', 4, 18000000.00, '1989-02-10', '30 Hoàng Hoa Thám, Hà Nội', 'ONLEAVE', 3),
    ('E0004', 'Lê Thị Duyênckas', 'duyen.le@example.com', '0912345681', 'FEMALE', 1, 9000000.00, '1995-11-03', '89 Trần Phú, Hà Nội', 'ACTIVE', 4),
    ('E0005', 'Hoàng Văn Emkcahcjkas', 'em.hoang@example.com', '0912345682', 'MALE', 2, 11000000.00, '1993-03-22', '56 Xã Đàn, Hà Nội', 'INACTIVE', 5),
    ('E0006', 'Đặng Thị Hạnhckajs', 'hanh.dang@example.com', '0912345683', 'FEMALE', 3, 14000000.00, '1991-12-30', '12 Láng Hạ, Hà Nội', 'ACTIVE', 6),
    ('E0007', 'Bùi Minh Hùngjchkasj', 'hung.bui@example.com', '0912345684', 'MALE', 2, 13000000.00, '1988-06-15', '78 Tây Sơn, Hà Nội', 'ACTIVE', 7),
    ('E0008', 'Vũ Thị Lancdhjbak', 'lan.vu@example.com', '0912345685', 'FEMALE', 1, 10000000.00, '1994-09-09', '14 Nguyễn Du, Hà Nội', 'POLICYLEAVE', 8),
    ('E0009', 'Đỗ Trung Kiêncbdjksa', 'kien.do@example.com', '0912345686', 'MALE', 4, 20000000.00, '1990-08-08', '90 Trúc Bạch, Hà Nội', 'ACTIVE', 9),
    ('E0010', 'Lương Thị Maijcshakjb', 'mai.luong@example.com', '0912345687', 'FEMALE', 2, 12000000.00, '1996-10-21', '65 Cầu Giấy, Hà Nội', 'ACTIVE', 10);



DELIMITER \\
create procedure login(
    name_in varchar(50),
    password_in varchar(20)
)
begin

    select * from users
    where user_name = name_in and password = password_in and status = 1;
end;
DELIMITER \\

DELIMITER \\
create procedure is_exist_department_name(
    department_name_in varchar(100)
)
begin
    select count(*) > 0 as is_exist_name from departments where department_name = department_name_in;
end;

create procedure is_exist_employee_id(
    employee_id_in char(5)
)
begin
    select count(*) > 0 as is_exist_emp_id from employees where employee_id = employee_id_in;
end;

create procedure is_exist_email(
    email_in varchar(100)
)
begin
    select count(*) > 0 as is_exist_email from employees where email = email_in;
end;

create procedure is_exist_phone_number(
    phone_number_in char(10)
)
begin
    select count(*) > 0 as is_exist_phone from employees where phone_number = phone_number_in;
end;
DELIMITER \\

DELIMITER \\
create procedure get_pagination_department(
    current_page int
)
begin
    declare item_per_page int default 5;
    declare total_records int;
    declare total_pages int;
    declare offset_value int;

    select count(*) into total_records from departments;
    set total_pages = ceil(total_records / item_per_page);
    set offset_value = (current_page - 1) * item_per_page;

    select *
    from departments
    limit item_per_page offset offset_value;
end;

create procedure get_all_department()
begin
    select * from departments;
end;

create procedure add_department(
    department_name_in varchar(100),
    description_in varchar(255),
    status_in bit
)
begin
    insert into departments(department_name, description, status)
    values (department_name_in, description_in, status_in);
end;

create procedure update_department(
    department_id_in int,
    department_name_in varchar(100),
    description_in varchar(255),
    status_in bit
)
begin
    update departments
    set department_name = department_name_in,
        description     = description_in,
        status          = status_in
    where department_id = department_id_in;
end;

create procedure find_department_by_id(
    department_id_in int
)
begin
    select * from departments where department_id = department_id_in;
end;

create procedure delete_department(
    department_id_in int
)
begin
    delete
    from departments
    where department_id = department_id_in;
end;

create procedure search_department_by_name(
    department_name_in varchar(100)
)
begin
    select *
    from departments
    where department_name like CONCAT('%', department_name_in, '%');
end;
DELIMITER \\

DELIMITER \\
create procedure get_pagination_employees(
    current_page int
)
begin
    declare itemPerPage int default 10;
    declare total_records int;
    declare total_pages int;
    declare offset_value int;

    select count(*) into total_records from employees;
    set total_pages = ceil(total_records / itemPerPage);

    set offset_value = (current_page - 1) * itemPerPage;

    select *
    from employees
    limit itemPerPage offset offset_value;
end;

create procedure get_all_employees()
begin
    select * from employees;
end;

create procedure add_employee(
    employee_id_in char(5),
    employee_name_in varchar(150),
    email_in varchar(100),
    phone_number_in char(10),
    gender_in char(10),
    level_salary_in int,
    salary_in decimal(15, 2),
    date_of_birth_in date,
    address_in varchar(250),
    status_in char(10),
    department_id_in int
)
begin
    insert into employees(employee_id, employee_name, email, phone_number, gender, level_salary, salary, date_of_birth,
                          address, status, department_id)
    values (employee_id_in, employee_name_in, email_in, phone_number_in, gender_in, level_salary_in, salary_in,
            date_of_birth_in, address_in, status_in, department_id_in);
end;

create procedure update_employee(
    employee_id_in char(5),
    employee_name_in varchar(150),
    email_in varchar(100),
    phone_number_in char(10),
    gender_in char(10),
    level_salary_in int,
    salary_in decimal(15, 2),
    date_of_birth_in date,
    address_in varchar(250),
    status_in char(10),
    department_id_in int
)
begin
    update employees
    set employee_name = employee_name_in,
        email         = email_in,
        phone_number  = phone_number_in,
        gender        = gender_in,
        level_salary  = level_salary_in,
        salary        = salary_in,
        date_of_birth = date_of_birth_in,
        address       = address_in,
        status        = status_in,
        department_id = department_id_in
    where employee_id = employee_id_in;
end;

create procedure find_employee_by_id(
    employee_id_in char(5)
)
begin
    select * from employees where employee_id = employee_id_in;
end;

create procedure delete_employee(
    employee_id_in char(5)
)
begin
    update employees
    set status = 'INACTIVE'
    where employee_id = employee_id_in;
end;

create procedure search_employee(
    employee_name_in varchar(150),
    date_from date,
    date_to date
)
begin
    select *
    from employees
    where employee_name like concat('%', employee_name_in, '%')
      and date_of_birth between date_from and date_to;
end;

create procedure sort_employee_by_salary()
begin
    select *
    from employees
    order by salary desc;
end;

create procedure sort_employee_by_name()
begin
    select *
    from employees
    order by employee_name;
end;
DELIMITER \\

DELIMITER \\
create procedure num_employees_of_department()
begin
    select d.department_name as department_name, count(e.employee_id) as count_employee
    from departments d
             left join employees e on d.department_id = e.department_id
    group by d.department_id, d.department_name;
end;

create procedure total_employees_system()
begin
    select count(*) as total_employees from employees;
end;

create procedure max_employee_of_department()
begin
    select d.department_name as department_name, count(e.employee_id) as count_employee
    from departments d
             left join employees e on d.department_id = e.department_id
    group by d.department_id, d.department_name
    having count(e.employee_id) = (
        select max(emp_count) from (
           select count(e2.employee_id) as emp_count
           from departments d2
                    left join employees e2 on d2.department_id = e2.department_id
           group by d2.department_id
       ) as subquery
    );
end;

create procedure max_salary_of_department()
begin
    select d.department_name as department_name, avg(e.salary) as avg_salary
    from departments d
             left join employees e on d.department_id = e.department_id
    group by d.department_id, d.department_name
    having avg(e.salary) = (
        select max(avg_salary)
        from (
         select avg(e2.salary) as avg_salary
         from departments d2
                  left join employees e2 on d2.department_id = e2.department_id
         group by d2.department_id
     ) as subquery
    );
end;
DELIMITER \\