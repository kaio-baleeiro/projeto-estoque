import random
from datetime import datetime


def getProduto(produtos):
    produto = random.choice(produtos)
    return produto[0]

def getMoment():
    now = datetime.now()
    data_formatada = now.strftime("%Y-%m-%d %T")
    print ("\n",data_formatada)
    return data_formatada

def getProdutos(produtos,qtdProds):
    qtdProduto = random.randint(1, qtdProds)

    contador = 1
    escolhidos = []

    while True:
        if contador <= qtdProduto:
            escolhidos.append(getProduto(produtos))
            contador+=1
        else:
            break
    
    return escolhidos

def carrinho(escolhidos):
    qtdProdEscolhido = []
    for x in escolhidos:
        qtdProdEscolhido.append(random.randint(1,5))

    return qtdProdEscolhido

def getValue(qtdAtual, qtdSelecionada):
    valor = qtdAtual - qtdSelecionada
    return valor
