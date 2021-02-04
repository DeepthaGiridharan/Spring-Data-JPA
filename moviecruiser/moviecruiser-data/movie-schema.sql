drop database if exists moviecruiser;
create database moviecruiser;
use moviecruiser;

create table moviecruiser.movies (
movie_id int auto_increment primary key,
movie_title varchar(100) not null,
movie_box_office decimal(2,1) not null,
movie_active boolean not null,
movie_date_of_launch date not null,
movie_genre varchar(20) not null,
movie_teaser boolean not null
);

create table moviecruiser.users (
user_id int auto_increment primary key,
user_name varchar(20) not null

);

create table moviecruiser.favorites (
user_id int,
movie_id int,
constraint primary key(user_id,movie_id),
foreign key (user_id) references users(user_id),
foreign key (movie_id) references movies(movie_id)
);
