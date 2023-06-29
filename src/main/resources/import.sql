insert into clients (name, last_name, email, create_at, img) values ('Ximo', 'Llacer', 'ximo@mail.com', '2020-07-20', '');
insert into clients (name, last_name, email, create_at, img) values ('Guy', 'Guy', 'guy@mail.com', '2020-07-20', '');
insert into clients (name, last_name, email, create_at, img) values ('Gal', 'Gal', 'gal@mail.com', '2000-08-05', '');
insert into clients (name, last_name, email, create_at, img) values ('James', 'Bond', 'bond@mail.com', '1998-05-04', '');
insert into clients (name, last_name, email, create_at, img) values ('Maria', 'Hill', 'hill@mail.com', '1458-05-30', '');
insert into clients (name, last_name, email, create_at, img) values ('Ebenezer', 'Falls', 'falls@mail.com', '1845-07-01', '');
insert into clients (name, last_name, email, create_at, img) values ('Foltest', 'Red', 'red@mail.com', '1230-04-08', '');
insert into clients (name, last_name, email, create_at, img) values ('Aaron', 'Gordon', 'gordon@mail.com', '1980-07-01', '');
insert into clients (name, last_name, email, create_at, img) values ('Triss', 'Gold', 'gold@mail.com', '1335-06-12', '');
insert into clients (name, last_name, email, create_at, img) values ('Quartz', 'Green', 'Green@mail.com', '1468-09-04', '');
insert into clients (name, last_name, email, create_at, img) values ('Vale', 'Vale', 'Vale@mail.com', '2001-06-29', '');
insert into clients (name, last_name, email, create_at, img) values ('John', 'Cena', 'Cena@mail.com', '1960-05-04', '');
insert into clients (name, last_name, email, create_at, img) values ('Kale', 'Heat', 'Heat@mail.com', '2034-06-16', '');
insert into clients (name, last_name, email, create_at, img) values ('Will', 'What', 'What@mail.com', '1698-04-07', '');
insert into clients (name, last_name, email, create_at, img) values ('Horas', 'Min', 'Min@mail.com', '2015-04-09', '');
insert into clients (name, last_name, email, create_at, img) values ('Quentin', 'Tart', 'Tart@mail.com', '1940-06-25', '');
insert into clients (name, last_name, email, create_at, img) values ('Loren', 'Malaz', 'Malaz@mail.com', '2004-07-23', '');
insert into clients (name, last_name, email, create_at, img) values ('Tyus', 'Drake', 'Drake@mail.com', '1999-06-18', '');
insert into clients (name, last_name, email, create_at, img) values ('Pax', 'Penny', 'Penny@mail.com', '1980-05-24', '');
insert into clients (name, last_name, email, create_at, img) values ('Ann', 'Deux', 'Deux@mail.com', '1985-05-24', '');
insert into clients (name, last_name, email, create_at, img) values ('Ann', 'Deux', 'Deux@mail.com', '1985-05-24', '');
insert into clients (name, last_name, email, create_at, img) values ('Ann', 'Deux', 'Deux@mail.com', '1985-05-24', '');
insert into clients (name, last_name, email, create_at, img) values ('Ann', 'Deux', 'Deux@mail.com', '1985-05-24', '');
insert into clients (name, last_name, email, create_at, img) values ('Ann', 'Deux', 'Deux@mail.com', '1985-05-24', '');

insert into products(name, price, date) values ('Nuphy Air75 Keyboard', '130.00', '2023-06-29');
insert into products(name, price, date) values ('Razer Barracuda X', '75.00', '2023-06-29');
insert into products(name, price, date) values ('Logitech Hero G502', '30.00', '2023-06-29');
insert into products(name, price, date) values ('HP Pavillion', '430.00', '2023-06-29');
insert into products(name, price, date) values ('Razer Huntsman Mini', '230.00', '2023-06-29');
insert into products(name, price, date) values ('Nuphy Halo95 Keyboard', '180.00', '2023-06-29');

insert into invoices(description, notes, client_id, date) values ('New keyboards', 'null', 1, NOW());
insert into invoice_lines(amount, invoice_id, product_id) values (1, 1, 1);
insert into invoice_lines(amount, invoice_id, product_id) values (1, 1, 5);

insert into invoices(description, notes, client_id, date) values ('Set up', 'null', 1, NOW());
insert into invoice_lines(amount, invoice_id, product_id) values (1, 2, 2);
insert into invoice_lines(amount, invoice_id, product_id) values (1, 2, 3);
insert into invoice_lines(amount, invoice_id, product_id) values (1, 2, 4);
insert into invoice_lines(amount, invoice_id, product_id) values (1, 2, 6);



