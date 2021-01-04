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

    def insertMovimentacao(self, quantidade, produto, momento):
        query = "insert into movimentacao(fkProduto, quantidade, momento) values ({}, {}, '{}')".format(produto,quantidade,momento)
        try:
            print("\nInserindo Valores")
            self.cursor.execute(query)
            self.mysql.commit()
        except Exception as err:
            print(err)
            self.mysql.rollback()
            self.close()
            
    def selectProduto(self):
        query = "select idProduto from produto"
        try:
            self.cursor.execute(query)
            meuresultado = self.cursor.fetchall()
            print(meuresultado)
        except Exception as err:
            print(err)
            self.mysql.rollback()
            self.mysql.close()
        return meuresultado
    
    # Fechando conexão
    def close(self):
        self.mysql.close()

        


