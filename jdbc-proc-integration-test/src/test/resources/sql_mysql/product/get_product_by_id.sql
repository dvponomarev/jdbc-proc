delimiter $$

create procedure get_product_by_id (
     in i_id int(10)
)
begin
    select p.product_id as product_id, p.name as name, p.type as type
      from product p
     where p.product_id = i_id;
end
$$

insert into resultset_info (specific_name, routine_resultset)
values ('get_product_by_id', 'product_id int, name varchar, type varchar');

commit;