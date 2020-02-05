delimiter $$

create procedure create_product1 (
   i_name varchar(60)
   , i_type varchar(10)
)
begin
    insert into product( name, type ) values (i_name, i_type);
end
$$
