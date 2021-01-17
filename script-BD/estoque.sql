create database estoque;
use estoque;

create table categoria (
	idCategoria int primary key auto_increment,
    nomeCategoria varchar(50)
    );
    
create table produto (
	idProduto int primary key auto_increment,
    nome varchar(50),
    fkCategoria int,
    qtdAtual int,
    qtdAbastecimento int,
    limiteMin int,
    foreign key (fkCategoria) references categoria(idCategoria)
);

create table movimentacao (
	idMovimentacao int primary key auto_increment,
    fkProduto int,
    quantidade int,
    momento datetime,
    foreign key (fkProduto) references produto(idProduto)
);

update produto set nome = "Papel Higienico" where idProduto = 7;

select * from produto;

select * from movimentacao where quantidade>6;

select idMovimentacao, nome, nomeCategoria, quantidade, date_format(momento, "%Y-%m-%d %H:%i:%s") as momento from categoria, produto, movimentacao
where idCategoria=fkCategoria and idProduto=fkProduto order by idMovimentacao;