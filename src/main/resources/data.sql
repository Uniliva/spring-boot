
insert into categoria (nome) values ('Escritorio');
insert into categoria (nome) values ('Informatica');
insert into categoria (nome) values ('Casa');

insert into produto (nome, valor) values ('Notebook',2000);
insert into produto (nome, valor) values ('Impressora',800.00);
insert into produto (nome, valor) values ('Mouse',80.00);

insert into PRODUTO_CATEGORIA (produto_id,categoria_id) values (1,1);
insert into PRODUTO_CATEGORIA (produto_id,categoria_id) values (1,2);
insert into PRODUTO_CATEGORIA (produto_id,categoria_id) values (1,3);
insert into PRODUTO_CATEGORIA (produto_id,categoria_id) values (2,1);
insert into PRODUTO_CATEGORIA (produto_id,categoria_id) values (3,1);

insert into estado(nome) values ('MInas Gerais');
insert into estado(nome) values ('São Paulo');

insert into cidade (nome,estado_id) values ('Uberlandia',1);
insert into cidade (nome,estado_id) values ('São Paulo',2);
insert into cidade (nome,estado_id) values ('Campinas',2);