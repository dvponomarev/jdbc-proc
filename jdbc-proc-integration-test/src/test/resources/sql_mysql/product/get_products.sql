delimiter $$

create procedure get_products ()
begin

    select product_id, name, type from product order by name;

end
$$

insert into resultset_info (specific_name, routine_resultset)
values ('get_products'
       , 'product_id int, name varchar, type varchar');

commit;