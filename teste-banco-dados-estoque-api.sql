drop database if exists teste_banco_dados_estoque_api;
create database teste_banco_dados_estoque_api;
use teste_banco_dados_estoque_api;

/* V1__create_table_categoria.sql */
create table categoria
(
    id        int          not null auto_increment,
    descricao varchar(100) not null,
    primary key (id)
);

/* V2__create_column_unidade_categoria.sql*/
alter table categoria add column unidade_medida varchar(20);

/* V3__drop_column_unidade_categoria.sql */
alter table categoria drop column unidade_medida;

/* V4__alter_categoria_to_Categoria.sql */
alter table categoria rename to Categoria;

/* V5__insert_categoria.sql */
insert into categoria (descricao) values ('Vestuário'), ('Calçados'), ('Acessórios');

/* V6__create_table_produto.sql */
create table produto(
	id int not null auto_increment,
    nome varchar(50) not null,
    descricao varchar(200),
    preco decimal(10,2) not null,
    id_categoria int not null,
    primary key (id)
);

alter table produto add constraint fk_produto_categoria foreign key (id_categoria) references categoria (id);

/* V7__insert_produto.sql */
insert into produto (nome, descricao, preco, id_categoria) 
	values ('Calça', 'Calça Jeans', '250.00', '1'),
			('Tênis', 'Tennis runner', '450.00', '2'),
			 ('Camisa', 'Camisa Polo', '180.00', '1'),
		      ('Pulseira', 'Pulseira de Prata', '220.00', '3');
              
/* V8__create_table_fornecedor.sql */
create table fornecedor(
	id int not null auto_increment,
    nome varchar(50) not null,
    email varchar(100) not null,
    fone varchar(20) not null,
    primary key(id)
);

alter table produto add column id_fornecedor int not null;

set foreign_key_checks = 0;

alter table produto add constraint fk_produto_fornecedor foreign key(id_fornecedor) references fornecedor(id);
    
set foreign_key_checks = 1;