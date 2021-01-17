import mysql.connector

class Mysql:
    def __init__(self, user, password, host, database):
        self.user = user
        self.password = password
        self.host = host
        self.database = database
        self.mysql = None
        self.cursor = None

    #Estabelecendo uma conexão
    def connect(self):
        try:
            self.mysql = mysql.connector.connect(
            user=self.user, password=self.password, host=self.host, database=self.database)
            #Criando cursor para manipulação do banco.
            print(self.mysql)
            self.cursor = self.mysql.cursor()
        except Exception as err:
            print(err)
            raise

    def insertMovimentacao(self, produto, quantidade, momento):
        query = "INSERT INTO movimentacao(fkProduto, quantidade, momento) VALUES ({}, {}, '{}')".format(produto,quantidade,momento)
        try:
            print("\nInserindo Valores")
            self.cursor.execute(query)
            self.mysql.commit()
        except Exception as err:
            print(err)
            self.mysql.rollback() 
            self.close()

    def updateProduto(self, valorAtual, produto):
        query = "UPDATE produto SET qtdAtual = {} WHERE idProduto={}".format(valorAtual, produto)
        try:
            print("\nAlterando quantia do produto")
            self.cursor.execute(query)
            self.mysql.commit()
        except Exception as err:
            print(err)
            self.mysql.rollback() 
            self.close()
            
    def selectProduto(self):
        query = "SELECT idProduto FROM produto"
        try:
            self.cursor.execute(query)
            meuresultado = self.cursor.fetchall()
        except Exception as err:
            print(err)
            meuresultado = 0
            self.mysql.rollback()
            self.mysql.close()
        return meuresultado

    def selectCountProduto(self):
        query = "SELECT count(idProduto) FROM produto"
        try:
            self.cursor.execute(query)
            meuresultado = self.cursor.fetchone()
        except Exception as err:
            print(err)
            meuresultado = 0
            self.mysql.rollback()
            self.mysql.close()
        return meuresultado[0]

    def selectQtdProduto(self, produto):
        query = "SELECT qtdAtual FROM produto WHERE idProduto = {}".format(produto)
        try:
            self.cursor.execute(query)
            meuresultado = self.cursor.fetchone()
            print("\nqtd Atual do produto:",meuresultado)
        except Exception as err:
            print(err)
            meuresultado = 0
            self.mysql.rollback()
            self.mysql.close()
        return meuresultado[0]

    def selectAbastecimento(self, produto):
        query = "SELECT qtdAbastecimento FROM produto WHERE idProduto = {}".format(produto)
        try:
            self.cursor.execute(query)
            meuresultado = self.cursor.fetchone()
        except Exception as err:
            print(err)
            meuresultado = 0
            self.mysql.rollback()
            self.mysql.close()
        return meuresultado[0] 

    def selectLimite(self, produto):
        query = "SELECT limiteMin FROM produto WHERE idProduto = {}".format(produto)
        try:
            self.cursor.execute(query)
            meuresultado = self.cursor.fetchone()
        except Exception as err:
            print(err)
            meuresultado = 0
            self.mysql.rollback()
            self.mysql.close()
        return meuresultado[0]
    
    # Fechando conexão
    def close(self):
        self.mysql.close()

        


