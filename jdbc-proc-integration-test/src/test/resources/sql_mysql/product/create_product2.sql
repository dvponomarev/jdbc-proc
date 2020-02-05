delimiter $$

create procedure create_product2 (
   out o_product_id int(10)
   , i_name varchar(60)
   , i_type varchar(10)
)
begin
    insert into product( name, type ) values (i_name, i_type);
    set o_product_id = last_insert_id();
end
$$
