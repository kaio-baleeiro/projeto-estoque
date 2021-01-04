from banco import Mysql
from dataGenerator import getValues, getProduto, getMoment
import time

mysql = Mysql('Kaio', 'bandtec', '127.0.0.1', 'estoque')
mysql.connect()

while True:
    print("\nCadastrando movimentação")
    quantidade = getValues()
    produtoList = mysql.selectProduto()
    produto = getProduto(produtoList)
    momento = getMoment()
    mysql.insertMovimentacao(quantidade,produto,momento)
    time.sleep(17.6468)