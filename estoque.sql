drop database if exists estoque;
create database estoque;
use estoque;

create table categoria (
	idCategoria int primary key auto_increment,
    categoria varchar(50)
);

insert into categoria values
	(null, "Bebidas"),
    (null, "Alimentos"),
    (null, "Higiene");

create table produto (
	idProduto int primary key auto_increment,
    nome varchar(50),
    fkCategoria int,
    valorProduto double,
    limiteMin int,
    foreign key (fkCategoria) references Categoria(idCategoria)
);

insert into produto values
	(null, "Coca-cola", 1, 70.90, 100),
    (null, "Fandangos", 2, 100.00, 50),
    (null, "Lenço Umedecido", 3, 60.00, 120),
	(null, "Pepsi", 1, 80.00, 100);
    
create table movimentacao (
	idMovimentacao int primary key auto_increment,
    fkProduto int,
    quantidade int,
    momento datetime,
    foreign key (fkProduto) references produto(idProduto) 
);

select * from categoria;
select * from movimentacao order by idMovimentacao desc;
select * from categoria, produto where idCategoria=fkCategoria and categoria = "Bebidas";

