create database erp_db;
use erp_db;
create table item_estoque(
    id INT PRIMARY KEY,
    descricao VARCHAR(200),
    quantidade INT,
    data_hora_ultima_atualizacao DATE
);
create table produto(
    id INT PRIMARY KEY,
    descricao VARCHAR(200),
    valor_unitario VARCHAR(200),
    data_hora_ultima_atualizacao DATE
);
create table item_pedido(
    id INT PRIMARY KEY,
    id_produto INT references produto(id),
    quantidade INT,
    FOREIGN KEY(id_produto) references produto(id)
);
create table forma_pagamento(
    id INT PRIMARY KEY,
    descricao VARCHAR(200),
    codigo VARCHAR(10),
    data_hora_ultima_atualizacao DATE
);
create table pedido(
    id INT PRIMARY KEY,
    id_item_pedido INT references item_pedido(id),
    data_hora_pedido DATE,
    id_forma_pagamento INT references forma_pagamento(id),
    pagamento_aprovado BOOLEAN,
    FOREIGN KEY(id_item_pedido) references item_pedido(id),
    FOREIGN KEY(id_forma_pagamento) references forma_pagamento(id)
);