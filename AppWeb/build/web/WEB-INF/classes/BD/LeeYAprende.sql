create database LYA;
go
use LYA;
go
---------------------------------------------------- TABLAS


create table Autor(
id_autor int IDENTITY(1,1),
nombre varchar(50)not null,	
primer_apellido varchar(50)not null,
segundo_apellido varchar (50),
pais varchar (45),


CONSTRAINT pk_autor
PRIMARY KEY (id_autor)


);




create table Editorial(
id_editorial int IDENTITY(1,1),
nombre varchar (100)  not null,
direccion varchar(100),
alta varchar(5) not null default 'true',

CONSTRAINT pk_editorial
primary key(id_editorial),
CONSTRAINT editorial_chk_alta CHECK (alta='true' or alta='false')

);


create table Area(
id_area int IDENTITY(1,1),
nombre varchar(50)not null,
alta varchar(5) default 'true' not null
CONSTRAINT pk_area
PRIMARY KEY (id_area)

CONSTRAINT area_chk_alta CHECK (alta='true' or alta='false')

);

create table Libro(
id_libro int IDENTITY(1,1),
titulo varchar (100)not null,
ISBN varchar (15)not null,
paginas int,
id_area int,
id_editorial int

CONSTRAINT pk_libro
PRIMARY KEY (id_libro)

CONSTRAINT fk_area_libro
FOREIGN KEY(id_area)
REFERENCES Area(id_Area),

CONSTRAINT fk_editorial_libro
FOREIGN KEY (id_editorial)
REFERENCES Editorial(id_editorial)

);



create table Autor_has(
id_autor_has int IDENTITY(1,1),
id_libro int,
id_autor int,

CONSTRAINT pk_id_autor_has
PRIMARY KEY (id_autor_has),

CONSTRAINT fk_libro_autor_has
FOREIGN KEY(id_libro)
REFERENCES Libro(id_libro),

CONSTRAINT fk_autor_autor_has
FOREIGN KEY (id_autor)
REFERENCES Autor(id_autor)
);

create table Estante(
id_estante int IDENTITY(1,1),
ubicacion varchar (50)

CONSTRAINT pk_estante
PRIMARY KEY (id_estante)

);

create table Ejemplar(
id_ejemplar int IDENTITY(1,1),
id_libro int,
id_estante int

CONSTRAINT pk_ejemplar
PRIMARY KEY (id_ejemplar)

CONSTRAINT fk_libro_ejemplar
FOREIGN KEY (id_libro)
REFERENCES Libro(id_libro),

CONSTRAINT fk_estante_ejemplar
FOREIGN KEY	(id_estante)
REFERENCES Estante(id_estante)

);

CREATE TABLE usuario(
id_usuario int IDENTITY(1,1),
nombre varchar(50)not null,
primer_apellido varchar (50)not null,
segundo_apellido varchar (50),
correo varchar (50)not null unique,
es_admi varchar (5) default 'false',
pass varchar (20)not null,
direccion varchar (100),
telefono varchar (40),
alta varchar(5) default 'true',

CONSTRAINT pk_usuario
PRIMARY KEY (id_usuario),

CONSTRAINT chk_usuario_prestamo CHECK (alta='true' or alta='false'),
CONSTRAINT chk_admi CHECK (es_admi='true' or es_admi='false')

);


CREATE TABLE prestamo(
	id_prestamo int IDENTITY(1,1),
	id_ejemplar int not null,
	id_usuario int not null,
	fecha_salida date not null,
	fecha_entrega date not null,
	
	CONSTRAINT prestamo_pk
	PRIMARY KEY(id_prestamo),
	
	CONSTRAINT fk_ejemplar_prestamo
	FOREIGN KEY(id_ejemplar)
	REFERENCES EJEMPLAR(id_ejemplar),
	
	CONSTRAINT fk_usuario_prestamo
	FOREIGN KEY(id_usuario)
	REFERENCES USUARIO(id_usuario),

	CONSTRAINT chk_dates check (fecha_salida < fecha_entrega)
);





Create table penalizacion(
	id_penalizacion int IDENTITY(1,1),
	limite_inferior int not null,
	limite_superior int,
	costo decimal not null,
	
	CONSTRAINT pk_penalizacion
	PRIMARY KEY(id_penalizacion)
);

--CONSTRAINT chk_monto CHECK (select Prestamo.fecha_solicitud, Prestamo.fecha_entrega from Prestamo
--join detallePrestamo on id_detallePrestamo=detallePrestamo.id_detallePrestamo join Penalizacion on Prestamo.id_prestamo=detallePrestamo.id_detallePrestamo)









------------------------------------------------------------------------------ DATOS

insert  Autor(nombre, primer_apellido)
VALUES ('Paulo','Cohelo'),
('Jk','Rowling'),
('Arthur','Conan'),
('J.R.R','Tolkien'),
('Julio','Verne');

insert Editorial(nombre,direccion)
values ('Planeta','Av. Presidente Masarik #111, 2do. Piso Col. Chapultepec Morales'),
('Salamandra','Almogàvers, 56, 7º 2ª - 08018 Barcelona - Spain	'),
('Everest','Calzada Ermita Iztapalapa 1681, Barrio San Miguel, Distrito Federal'),
('Minotauro','Barcelona '),
('Terramar',' Avenida de Mayo 1110');


insert Area  (nombre) values 
('Ciencia Ficcion'),
('Fantasia'),
('Motivacional'),
('Misterio'),
('Informática');

insert Libro(titulo, ISBN, paginas, id_editorial,id_area )
values ('La quinta montaña',9788408070672, 300, 1, 3),
('El señor de los anillos',8488543070672, 650, 4, 2),
('Viaje al centro de la tierra',1535726546853, 200, 5, 1),
('Sherlock Holmes',4238554564455, 315, 3, 4),
('Harry Potter y la piedra filosofal',682364258745, 412, 2, 2);

insert Autor_has( id_autor,id_libro)
values(1,1),
(2,5),
(3,4),
(4,2),
(5,3);

insert Estante(ubicacion)
values('Estante 1 fila A'),
('Estante 2 fila A'),
('Estante 3 fila B'),
('Estante 4 fila C'),
('Estante 5 fila C');


insert Ejemplar(id_libro,id_estante)
values(1,1),
(2,2),
(3,3),
(4,4),
(5,5);


 
insert usuario(nombre,primer_apellido,segundo_apellido,correo,pass,direccion,telefono,alta,es_admi)
values('Eric','Cuevas','Lagunas','blabla@gmail.com','Fi','alado de tu casa','123445678','true','false'),
('Eliel', 'Rodriguez', 'Villalobos', 'elielorgz03@gmail.com', 'Eliel-03', 'Fco I Madero #3 ProHogar', '368-61-19','true','true'),

('Miguel','Luna','Ortega','miguel_malo13@hotmail.com','miguelluna','calle Lazaro Cardenas #100 col 3 de mayo','7773600326','true','false')


update usuario set es_admi='true' where nombre='Eliel'-- actualiza es_admi a true


insert prestamo (id_usuario,id_ejemplar,fecha_salida,fecha_entrega) 
values(1,1,'2015-08-01', '2015-08-09')



----------------------------------------------------------------------CONSULTAS






select * from usuario



 


select * from Prestamo

select * from usuario;



select usuario.nombre from usuario where es_admi='true'-- es administrador

select Libro.titulo, Editorial.nombre as 'nombre editorial' from Libro join Editorial
on id_libro=Editorial.id_editorial
where Editorial.nombre='Salamandra' -- selecciona los libros de la editorial salamandra


select count(Libro.id_libro) as 'numero' from Editorial
join Libro
on Editorial.id_editorial=Libro.id_editorial where nombre='Terramar'  --selecciona cuantos libros hay de la editorial salamandra

select Libro.titulo from Libro join Ejemplar
on Libro.id_libro=Ejemplar.id_libro join Estante on
Estante.id_estante=Ejemplar.id_estante
where Estante.ubicacion='Estante 1 fila A'  ---------------------titulo del libro que esta en el Estante 1 fila A
select * from Autor

select * from libro

select * from editorial

select * from usuario
delete  usuario where id_usuario=4 -- borra un registro

select * from Area
alter table usuario alter column es_admi varchar(5)-- actualiza un capo de una tabla

select * from Libro
select * from Autor_has



select * from Autor where id_autor  in (select id_autor from Autor_has where id_libro = 15)




delete usuario -- borra los datos de una tabla



DBCC CHECKIDENT (Libro, RESEED,0) --reinicia un identity a cero