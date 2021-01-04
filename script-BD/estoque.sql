drop database if exists estoque;
create database estoque;
use estoque;

create table categoria (
	idCategoria int primary key auto_increment,
    nomeCategoria varchar(50)
);

insert into categoria values
	(null, "Bebidas"),
    (null, "Alimentos"),
    (null, "Higiene");

create table produto (
	idProduto int primary key auto_increment,
    nome varchar(50),
    fkCategoria int,
    quantidadeAtual int,
    valorProduto double,
    limiteMin int,
    foreign key (fkCategoria) references categoria(idCategoria)
);

insert into produto values
	(null, "Coca-cola", 1, 1000, 70.90, 100),
    (null, "Fandangos", 2, 300, 100.00, 50),
    (null, "Lenço Umedecido", 3, 600, 60.00, 120),
	(null, "Pepsi", 1, 800, 80.00, 100);
    
create table movimentacao (
	idMovimentacao int primary key auto_increment,
    fkProduto int,
    quantidade int,
    momento time,
    foreign key (fkProduto) references produto(idProduto) 
);

select * from categoria;
select * from categoria, produto where idCategoria=fkCategoria and nomeCategoria = "Bebidas";
select * from movimentacao;
select * from (select quantidade, nome, momento from movimentacao, produto where nome = "fandangos" and fkProduto=idProduto order by momento desc limit 20) sele order by momento asc;


