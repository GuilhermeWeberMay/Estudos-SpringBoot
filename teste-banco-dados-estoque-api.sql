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

/* V3__drop_column_unidade_categoria.sql*/
alter table categoria drop column unidade_medida;

/* V4__alter_categoria_to_Categoria*/
alter table categoria rename to Categoria;

/* V5__insert_categoria */
insert into categoria (descricao) values ('Vestuário'), ('Calçados'), ('Acessórios');

/* V6__create_table_produto*/
create table produto(
	id int not null auto_increment,
    nome varchar(50) not null,
    descricao varchar(200),
    preco decimal(10,2) not null,
    id_categoria int not null,
    primary key (id)
);

alter table produto add constraint fk_produto_categoria foreign key (id_categoria) references categoria (id);