-- V2: Migrations para adicionar coluna de armas na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN ARMA VARCHAR(255);