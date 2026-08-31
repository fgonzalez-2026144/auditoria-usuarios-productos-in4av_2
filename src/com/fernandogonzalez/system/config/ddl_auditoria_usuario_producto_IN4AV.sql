drop database auditoria_usuario_producto_IN4AV;
create database auditoria_usuario_producto_IN4AV;
use  auditoria_usuario_producto_IN4AV;

create table User(
	name varchar(50) NOT NULL check( length(name)<=50),
	lastname varchar(50) NOT NULL check( length(lastname)<=50),
    email varchar(50) NOT NULL check( length(email)<=50),
    user varchar(25) NOT NULL check( length(user)<=25),
	password  varchar(16) NOT NULL check( length(password)<=16),
    id_user varchar(36) NOT NULL,
    constraint pk_user primary key (id_user)
);
# Uso de constraint para validar estructura e informacion
# CREAR
Delimiter $$
	create procedure sp_create_users(in name_p varchar(50),
										in lastname_p varchar(50),
                                        in email_p varchar(50),
                                        in user_p varchar(25),
                                        in password_p varchar(16))
begin
	insert into User(name, lastname, email, user, password, id_user)
		values (name_p, lastname_p, email_p, user_p, password_p, uuid());
end $$
Delimiter ;

call sp_create_users("a","a","a@","a","a123");
select * from User