from banco import Mysql
from dataGenerator import getProduto, getMoment, carrinho, getProdutos, getValue
import time

mysql = Mysql('Kaio', 'bandtec', '127.0.0.1', 'estoque')
mysql.connect()

while True:
    print("\nCadastrando movimentação")
    produtoList = mysql.selectProduto()
    qtdProduto = mysql.selectCountProduto()
    momento = getMoment()

    listaProdutos  = getProdutos(produtoList, qtdProduto)
    quantidades = carrinho(listaProdutos)

    cont = 0
    for x in listaProdutos:
        limite = mysql.selectLimite(x)
        qtd = mysql.selectQtdProduto(x)

        if qtd <= limite:
            abastecimento = mysql.selectAbastecimento(x)
            mysql.insertMovimentacao(x,abastecimento,momento)
            mysql.updateProduto(abastecimento, x)
        else:
            mysql.insertMovimentacao(x,quantidades[cont],momento)
            prodRestante = getValue(qtd, quantidades[cont])
            mysql.updateProduto(prodRestante, x)

        cont+=1

    time.sleep(17.6468)