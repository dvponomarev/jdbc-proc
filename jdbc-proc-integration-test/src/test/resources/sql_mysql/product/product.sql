create table product (
     product_id   int(10) unsigned not null auto_increment
   , name         varchar(60)
   , type         varchar(10)

   , constraint pk_product primary key (product_id)
) engine = innodb ;

