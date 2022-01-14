set foreign_key_checks=0;
truncate table incoming_stock;

insert into incoming_stock(`id`, `productName`, `brand`, `productCategory`, `price`, `quantity`)
values(110, 'luxury chair', 'Taeillo', 'Furniture', 100000, 5 ),
      (111, 'luxury sofa', 'upsillon', 'Furniture', 20000, 10),
      (112, 'luxury bench', 'orion', 'Furniture', 50000,10),
      (113, 'luxury table', 'Taeillo', 'Furniture', 200000,30);


set foreign_key_checks=1;