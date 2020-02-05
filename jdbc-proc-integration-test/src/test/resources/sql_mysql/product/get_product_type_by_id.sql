delimiter $$

create procedure get_product_type_by_id (
     in i_id int(10)
)
begin
    select p.type as type
      from product p
     where p.product_id = i_id;
end
$$

insert into resultset_info (specific_name, routine_resultset)
values ('get_product_type_by_id', 'type varchar');

commit;