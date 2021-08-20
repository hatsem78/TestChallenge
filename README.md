# wenanceChallenge
Wenance Challenge


# Se crearon los siguientes enpoint .

    a) Obtener el precio del Bitcoin o Ethereum en cierto timestamp.
    
    http://localhost:9080/currency/GetPriceBitcoinEthereumTimestamp?currency=ETH&date=2021-08-18 19:07:11
    
    
    b) Conocer el promedio de valor (para una cripto ETH o BTC) entre dos timestamps
    así como la diferencia porcentual entre ese valor promedio y el valor máximo
    almacenado para toda la serie temporal disponible
    http://localhost:9080/currency/GetDifferencePercentageAverageValueMaximum?startDate=2021-08-18 19:07:11&endDate=2021-08-18 19:08:00&currency=BTC

    c) Devolver en forma paginada los datos almacenados con o sin filtro de timestamp.
    
    http://localhost:9080/currency/getAllBitcoinEthereum?currency=BTC


    Parte 2
    Exponer un endpoint donde se pueda convertir de BTC a USD o ETH a USD usando la api
    https://cex.io/api/convert/{symbol}/USD, cuya respuesta cuando sea exitosa contenga el monto
    convertido y el último valor almacenado para esa cripto en la parte 1 (tomar este dato de la
    db).

    http://localhost:9080/currency/convertBTCOrETHToUSD?currency=BTC&amnt=2.2

    para la carega de la base de datos se creo un componente ScheduledTasks que corre cada 10 segundo y guarda los datos

# Los enpoint de ejemplo estan
    estos se encuentran /wenanceChallenge/src/main/resources/wenanceChallenge.postman_collection.json

# Configuraciòn para la base de datos

    Cambiar las iguientes propiedadees para la conceccion
    #Coneccion mysql
    spring.datasource.url=jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=true
    spring.datasource.username=root
    spring.datasource.password=root@2021
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=create
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

    si se deja esa propiedad en create, crea las tablas correspondeitntes
    spring.jpa.hibernate.ddl-auto=create
    para que no lo cree tiene que estar seteado en none
    spring.jpa.hibernate.ddl-auto=create
