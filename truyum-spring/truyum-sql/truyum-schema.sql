create database truyum;
use truyum;
create table user (us_id INT auto_increment primary key,us_name varchar(60));

create table menu_item (me_id INT auto_increment primary key,me_name varchar(100),
me_price float(2),me_active boolean,me_date_of_launch date,me_category varchar(45),
me_free_delivery boolean);

create table cart (
ct_us_id int,
ct_pr_id int,
constraint primary key(ct_us_id,ct_pr_id),
foreign key (ct_us_id) references user(us_id),
foreign key (ct_pr_id) references menu_item(me_id)
);





