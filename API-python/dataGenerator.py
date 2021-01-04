import random
from datetime import datetime

def getValues():
    dados = random.randint(-500,500)
    return dados

def getProduto(produtos):
    produto = random.choice(produtos)
    return produto[0]

def getMoment():
    now = datetime.now()
    data_formatada = now.strftime("%Y-%m-%d %T")
    print (data_formatada)
    return data_formatada