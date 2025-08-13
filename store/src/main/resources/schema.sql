DROP TABLE TDS_TB_FERRAMENTAS;
CREATE TABLE TDS_TB_FERRAMENTAS (
    id_produto VARCHAR(36) PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    tipo_produto VARCHAR(20) NOT NULL,
    classificacao_produto VARCHAR(20) NOT NULL,
    tamanho_produto DOUBLE PRECISION NOT NULL,
    preco_produto DECIMAL(10, 2) NOT NULL
);
