CREATE TABLE topicos (
                        id BIGINT NOT NULL AUTO_INCREMENT,
                        titulo VARCHAR(200) NOT NULL,
                        mensagem VARCHAR(255) NOT NULL,
                        autor VARCHAR(255) NOT NULL,
                        curso VARCHAR(255) NOT NULL,
                        dataCriacao DATETIME NOT NULL,
                        PRIMARY KEY (id)
);