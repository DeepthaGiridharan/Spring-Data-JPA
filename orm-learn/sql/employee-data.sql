
create table department(dp_id int primary key auto_increment,dp_name varchar(45));
create table skill(sk_id int primary key auto_increment,sk_name varchar(45));
create table employee (em_id  int Primary key auto_increment,em_name varchar(45),em_salary decimal(10,2),em_permanent boolean,em_date_of_birth date,em_dp_id int,FOREIGN KEY (em_dp_id) REFERENCES department(dp_id));
create table employee_skill(es_id int primary key auto_increment,es_em_id int not null, es_sk_id int not null,FOREIGN KEY (es_em_id) REFERENCES employee(em_id),FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id));

insert into department (dp_name) values("Finance");
insert into department (dp_name) values("Quality Assurance");
insert into department (dp_name) values("Human Resource");

insert into employee (em_name,em_salary,em_permanent,em_date_of_birth,em_dp_id) values ("Suresh",50000 ,true ,"1982-11-14" ,2);
insert into employee (em_name,em_salary,em_permanent,em_date_of_birth,em_dp_id) values ("Ramesh",150000 ,true ,"1978-06-03" ,2);
insert into employee (em_name,em_salary,em_permanent,em_date_of_birth,em_dp_id) values ("Latha",200000 ,true ,"1990-01-24" ,2);
insert into employee (em_name,em_salary,em_permanent,em_date_of_birth,em_dp_id) values ("Radha",80000 ,false ,"1985-10-17" ,2);

insert into skill (sk_name) values ("Soft skills");
insert into skill (sk_name) values ("Ethics");

insert into skill (sk_name) values ("Accounting");
insert into skill (sk_name) values ("E Commerce");

insert into skill (sk_name) values ("Testing");
insert into skill (sk_name) values ("Debugging");

insert into skill (sk_name) values ("Agile Development");


insert into employee_skill (es_em_id, es_sk_id) values (1,1);
insert into employee_skill (es_em_id, es_sk_id) values (1,4);

insert into employee_skill (es_em_id, es_sk_id) values (2,2);
insert into employee_skill (es_em_id, es_sk_id) values (2,5);

insert into employee_skill (es_em_id, es_sk_id) values (3,3);
insert into employee_skill (es_em_id, es_sk_id) values (3,6);