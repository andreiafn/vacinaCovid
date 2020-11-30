create table efeitos_colaterais
(
    idefeitos_colaterais int auto_increment
        primary key,
    comum                varchar(45) not null,
    incomum              varchar(45) not null,
    raro                 varchar(45) not null,
    descricao            varchar(45) null
);

create table empresa
(
    id_empresa   int auto_increment
        primary key,
    nome_empresa varchar(45) not null
);

create table fases_vacina
(
    idfases_vacina int         not null
        primary key,
    fase1          varchar(45) not null,
    fase2          varchar(45) not null,
    fase3          varchar(45) not null,
    fase4          varchar(45) not null
);

create table funcionários
(
    idFuncionários int         not null
        primary key,
    nome           varchar(45) not null,
    endereço       varchar(45) not null,
    id_empresa     int         not null,
    constraint funcionários_empresa_id_empresa_fk
        foreign key (id_empresa) references empresa (id_empresa)
);

create index fk_Funcionários_Empresa_idx
    on funcionários (id_empresa);

create table governo
(
    id_governo int auto_increment
        primary key,
    nome       varchar(45) not null
);

create table pais_teste
(
    id_pais_teste     int auto_increment
        primary key,
    nome              varchar(45) not null,
    num_participantes varchar(45) not null
);

create table local_aplicação
(
    id_local      int         not null,
    instituição   varchar(45) not null,
    estado        varchar(45) not null,
    id_pais_teste int         not null,
    primary key (id_local, id_pais_teste),
    constraint local_aplicação_pais_teste_id_pais_teste_fk
        foreign key (id_pais_teste) references pais_teste (id_pais_teste)
);

create index fk_local_aplicação_país_Teste1_idx
    on local_aplicação (id_pais_teste);

create table vacina
(
    idvacina       int         not null
        primary key,
    nome_vacina    varchar(45) not null,
    estoque        varchar(45) not null,
    id_fase_vacina int         null,
    id_governo     int         null,
    id_empresa     int         null,
    constraint vacina_empresa_id_empresa_fk
        foreign key (id_empresa) references empresa (id_empresa),
    constraint vacina_fases_vacina_idfases_vacina_fk
        foreign key (id_fase_vacina) references fases_vacina (idfases_vacina),
    constraint vacina_governo_id_governo_fk
        foreign key (id_governo) references governo (id_governo)
);

create table pesquisadores
(
    idpesquisadores int         not null
        primary key,
    nome            varchar(45) not null,
    idade           int         not null,
    email           varchar(45) not null,
    cargo           varchar(45) not null,
    idvacina        int         null,
    constraint pesquisadores_vacina_idvacina_fk
        foreign key (idvacina) references vacina (idvacina)
);

create table vacina_has_efeitos_colaterais
(
    idvacina             int not null,
    idefeitos_colaterais int not null,
    primary key (idvacina, idefeitos_colaterais),
    constraint vacina_has_efeitos_colaterais_fk
        foreign key (idefeitos_colaterais) references efeitos_colaterais (idefeitos_colaterais),
    constraint vacina_has_efeitos_colaterais_vacina_idvacina_fk
        foreign key (idvacina) references vacina (idvacina)
);

create index fk_Vacina_has_efeitos_colaterais_Vacina1_idx
    on vacina_has_efeitos_colaterais (idvacina);

create index fk_Vacina_has_efeitos_colaterais_efeitos_colaterais1_idx
    on vacina_has_efeitos_colaterais (idefeitos_colaterais);

create table vacina_has_país_teste
(
    idvacina      int not null,
    id_pais_teste int not null,
    primary key (idvacina, id_pais_teste),
    constraint vacina_has_país_teste_pais_teste_id_pais_teste_fk
        foreign key (id_pais_teste) references pais_teste (id_pais_teste),
    constraint vacina_has_país_teste_vacina_idvacina_fk
        foreign key (idvacina) references vacina (idvacina)
);

create index fk_Vacina_has_país_Teste_país_Teste1_idx
    on vacina_has_país_teste (id_pais_teste);

create table voluntario
(
    idvoluntario  int auto_increment
        primary key,
    nome          varchar(45) not null,
    idade         varchar(45) not null,
    comorbidades  varchar(45) not null,
    id_pais_teste int         null,
    constraint voluntario_pais_teste_id_pais_teste_fk
        foreign key (id_pais_teste) references pais_teste (id_pais_teste)
);


