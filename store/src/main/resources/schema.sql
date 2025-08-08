CREATE TABLE IF NOT EXISTS TDS_TB_FERRAMENTAS (
    id_produto VARCHAR(36) PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    marca_produto VARCHAR(100) NOT NULL,
    quantidade_produto INT NOT NULL,
    preco_produto DOUBLE PRECISION NOT NULL
);
