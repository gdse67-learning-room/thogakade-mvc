create table orders(
                       order_id varchar(35) primary key,
                       cus_id varchar(35) not null,
                       date date not null,
                       constraint foreign key (cus_id) references customer(id)
                        on delete cascade on update cascade
);