drop database if exists estoque;
create database estoque;
use estoque;

create table produto (
	idProduto int primary key auto_increment,
    nome varchar(50),
    categoria varchar(50),
    valorProduto double,
    limiteMin int
);

create table movimentacao (
	idMovimentacao int primary key auto_increment,
    fkProduto int,
    quantidade int,
    momento datetime,
    foreign key (fkProduto) references produto(idProduto) 
);

select * from produto;
select * from movimentacao order by idMovimentacao desc;
truncate movimentacao;

insert into produto values
	(null, "Coca-cola", "Bebidas", 70.90, 100),
    (null, "Fandangos", "Alimentos", 100.00, 50);

