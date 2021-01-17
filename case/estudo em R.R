library(readr)
dataset <- read_csv("bandtec/projeto-estoque/case/dataset.csv", 
col_types = cols(momento = col_datetime(format = "%Y-%m-%d %H:%M:%S")))

View(dataset)

cocaTable<-data.frame(subset(dataset, nome=='Coca-cola' & quantidade<6))
View(cocaTable)

names(cocaTable)<-c("idCoca", "nomeCoca", "categoriaCoca", 
                    "quantidadeCoca", "momentoCoca")

fandangosTable<-data.frame(subset(dataset, nome=='Fandangos' & quantidade<6))

table.default<-merge(cocaTable,fandangosTable)
View(table.default)

teste<-subset(table.default, momentoCoca==momento)
View(teste)

id<-c(1:117)

teste2<-data.frame(id,teste)
View(teste2)

teste2$idCoca<-NULL
teste2$momentoCoca<-NULL
teste2$idMovimentacao<-NULL

scatterplot3d::scatterplot3d(teste2$quantidadeCoca,teste2$quantidade,teste2$id)

plot3D::lines3D(teste2$quantidadeCoca,teste2$quantidade,teste2$id)