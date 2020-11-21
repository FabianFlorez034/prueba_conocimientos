CREATE TABLE TEST_CLIENTE(
id_cliente int not null AUTO_INCREMENT,
identificacion int not null,
nombres varchar(100) not null,
apellidos varchar(100) not null,
direccion varchar(300) not null,
telefono varchar(50),
email varchar(100),
primary key(id_cliente)
);


CREATE TABLE TEST_PRODUCTO(
id_producto int not null AUTO_INCREMENT,
codigo varchar(30) not null,
nombre varchar(100) not null,
valor_unidad decimal(18,3) not null,
stock int not null,
primary key(id_producto) 
);


CREATE TABLE TEST_FACTURA(
id_factura int not null AUTO_INCREMENT,
id_cliente int not null,
fecha_venta datetime not null,
valor_total decimal(18,3) not null,
primary key(id_factura),
foreign key(id_cliente) references TEST_CLIENTE(id_cliente)
);


CREATE TABLE TEST_FACTURA_DETALLE(
id_factura_detalle int not null AUTO_INCREMENT,
id_factura int not null,
id_producto int not null,
cantidad int not null,
valor_unidad decimal(18,3) not null,
valor_total decimal(18,3) not null,
primary key(id_factura_detalle),
foreign key(id_factura) references TEST_FACTURA(id_factura),
foreign key(id_producto) references TEST_PRODUCTO(id_producto)
);

INSERT INTO TEST_CLIENTE VALUES('','11223344','CLIENTE','BAJO','CALLE 1 # 2-1','3210099','CL01@YAHOO.ES');
INSERT INTO TEST_CLIENTE VALUES('','789456','PETER','ROJO','CALLE 11 # 21-11',NULL,NULL);
INSERT INTO TEST_CLIENTE VALUES('','66995522','JAIR','RUIZ','CALLE 63 # 55-1','3669955','JAIR@YAHOO.ES');
INSERT INTO TEST_CLIENTE VALUES('','2255448','VICTOR','BARCO','CALLE 19 # 21','7410022','VICTOR@YAHOO.ES');
INSERT INTO TEST_CLIENTE VALUES('','123456789','MARIA','CALLE','CALLE 61 # 77D-96','6660005','CALLE@YAHOO.ES');
INSERT INTO TEST_CLIENTE VALUES('','41000333','LUIS','CORREO','CALLE 45 # 32-11','4444444','LCORREO@YAHOO.ES');

INSERT INTO TEST_PRODUCTO VALUES('','0001','TOSTACOS',950,15);
INSERT INTO TEST_PRODUCTO VALUES('','0002','LECHE',2350,40);
INSERT INTO TEST_PRODUCTO VALUES('','0003','PLATANO',1500,20);
INSERT INTO TEST_PRODUCTO VALUES('','0004','PAÑALES',36500,4);
INSERT INTO TEST_PRODUCTO VALUES('','0005','BULTO DE MANDARINAS',156800,9);
INSERT INTO TEST_PRODUCTO VALUES('','0006','ARROZ',6450,60);
INSERT INTO TEST_PRODUCTO VALUES('','0007','PESCADO',99000,45);
INSERT INTO TEST_PRODUCTO VALUES('','0008','HUEVOS',11500,20);
INSERT INTO TEST_PRODUCTO VALUES('','0009','PAPAS JAJAJAJA',6600,1);
INSERT INTO TEST_PRODUCTO VALUES('','0010','DETERGENTE',5001000,3);