drop procedure if exists upload_products;
delimiter $$
create procedure upload_products()
main_sql:
  begin
    insert into product
          (
             name, type
          )
      select name,
             type
        from products;

    truncate table products;
  end
$$
delimiter ;