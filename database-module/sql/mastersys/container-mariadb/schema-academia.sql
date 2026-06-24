-- =============================================================
--  SCHEMA: Sistema de Gerenciamento de Academia
--  Banco:  MariaDB (10.5+)
-- =============================================================

-- Garante uso correto de charset e engine
SET NAMES utf8mb4;
SET time_zone = '-03:00';  -- Horário de Brasília (UTC-3)

-- Cria se não existir e seleciona o banco academia
CREATE DATABASE IF NOT EXISTS academia;
USE academia;

-- =============================================================
-- 1. ALUNOS
--    Dados pessoais, contato e endereço do aluno.
-- =============================================================
CREATE TABLE alunos (
    id               BIGINT          NOT NULL AUTO_INCREMENT,
    nome             VARCHAR(150)    NOT NULL                    COMMENT 'Nome completo do aluno.',
    data_nascimento  DATE                                        COMMENT 'Data de nascimento.',
    genero           ENUM('M', 'F')                             COMMENT 'Gênero: M = Masculino, F = Feminino.',
    cpf              VARCHAR(14)     UNIQUE                      COMMENT 'CPF no formato 000.000.000-00.',
    telefone         VARCHAR(30)                                 COMMENT 'Telefone fixo.',
    celular          VARCHAR(30)                                 COMMENT 'Celular / WhatsApp.',
    email            VARCHAR(150)    UNIQUE                      COMMENT 'E-mail único do aluno.',
    observacao       TEXT                                        COMMENT 'Observações livres.',
    -- Endereço
    endereco         VARCHAR(150)                                COMMENT 'Logradouro.',
    numero           VARCHAR(20)                                 COMMENT 'Número do imóvel.',
    complemento      VARCHAR(100)                                COMMENT 'Apartamento, bloco etc.',
    bairro           VARCHAR(100)                                COMMENT 'Bairro.',
    cidade           VARCHAR(100)                                COMMENT 'Cidade.',
    estado           CHAR(2)                                     COMMENT 'UF (sigla de 2 letras).',
    cep              VARCHAR(9)                                  COMMENT 'CEP no formato 00000-000.',
    -- Auditoria
    criado_em        DATETIME        NOT NULL DEFAULT CURRENT_TIMESTAMP   COMMENT 'Preenchido automaticamente na inserção.',
    atualizado_em    DATETIME        ON UPDATE CURRENT_TIMESTAMP          COMMENT 'Atualizado automaticamente pelo MariaDB a cada UPDATE.',

    PRIMARY KEY (id)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Cadastro de alunos da academia.';

-- Índices de alunos
CREATE INDEX idx_alunos_nome ON alunos (nome);
CREATE INDEX idx_alunos_cpf  ON alunos (cpf);


-- =============================================================
-- 2. MODALIDADES
--    Modalidades oferecidas (ex: Jiu-Jitsu, Muay Thai, Natação).
-- =============================================================
CREATE TABLE modalidades (
    id        BIGINT          NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(100)    NOT NULL UNIQUE              COMMENT 'Nome da modalidade (único).',
    descricao TEXT                                         COMMENT 'Descrição da modalidade.',
    ativa     TINYINT(1)      NOT NULL DEFAULT 1           COMMENT '1 = ativa, 0 = desativada. FALSE não exclui histórico.',

    PRIMARY KEY (id)
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Modalidades esportivas disponíveis na academia.';


-- =============================================================
-- 3. GRADUACOES
--    Níveis/faixas de cada modalidade.
-- =============================================================
CREATE TABLE graduacoes (
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    modalidade_id  BIGINT       NOT NULL                   COMMENT 'FK para modalidades.',
    nome           VARCHAR(100) NOT NULL                   COMMENT 'Nome da faixa/nível.',
    ordem          SMALLINT     NOT NULL DEFAULT 0         COMMENT 'Posição na hierarquia; 0 = iniciante.',

    PRIMARY KEY (id),
    UNIQUE KEY uq_graduacoes_modalidade_nome (modalidade_id, nome),
    CONSTRAINT fk_graduacoes_modalidade
        FOREIGN KEY (modalidade_id) REFERENCES modalidades (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Graduações (faixas/níveis) de cada modalidade.';


-- =============================================================
-- 4. PLANOS
--    Planos de pagamento associados a uma modalidade.
-- =============================================================
CREATE TABLE planos (
    id             BIGINT          NOT NULL AUTO_INCREMENT,
    modalidade_id  BIGINT          NOT NULL                COMMENT 'FK para modalidades.',
    nome           VARCHAR(100)    NOT NULL                COMMENT 'Nome do plano.',
    descricao      TEXT                                    COMMENT 'Descrição do plano.',
    valor_mensal   DECIMAL(10, 2)  NOT NULL                COMMENT 'Valor em reais (R$). Não pode ser negativo.',
    ativo          TINYINT(1)      NOT NULL DEFAULT 1      COMMENT '1 = ativo, 0 = inativo.',

    PRIMARY KEY (id),
    UNIQUE KEY uq_planos_modalidade_nome (modalidade_id, nome),
    CONSTRAINT chk_planos_valor_mensal
        CHECK (valor_mensal >= 0),
    CONSTRAINT fk_planos_modalidade
        FOREIGN KEY (modalidade_id) REFERENCES modalidades (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Planos de pagamento por modalidade.';


-- =============================================================
-- 5. MATRICULAS
--    Vínculo principal do aluno com a academia.
-- =============================================================
CREATE TABLE matriculas (
    id                BIGINT       NOT NULL AUTO_INCREMENT,
    aluno_id          BIGINT       NOT NULL                COMMENT 'FK para alunos.',
    data_matricula    DATE         NOT NULL DEFAULT (CURRENT_DATE)  COMMENT 'Data de início da matrícula.',
    dia_vencimento    SMALLINT     NOT NULL                COMMENT 'Dia do mês para vencimento das faturas (1–28).',
    data_encerramento DATE                                 COMMENT 'Data de encerramento; NULL = matrícula em aberto.',
    status            ENUM('ATIVA','ENCERRADA','CANCELADA')
                                   NOT NULL DEFAULT 'ATIVA' COMMENT 'ATIVA | ENCERRADA | CANCELADA.',
    -- Auditoria
    criado_em         DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT 'Preenchido automaticamente na inserção.',
    atualizado_em     DATETIME     ON UPDATE CURRENT_TIMESTAMP         COMMENT 'Atualizado automaticamente pelo MariaDB a cada UPDATE.',

    PRIMARY KEY (id),
    CONSTRAINT chk_matriculas_dia_vencimento
        CHECK (dia_vencimento BETWEEN 1 AND 28),
    CONSTRAINT chk_matriculas_datas
        CHECK (data_encerramento IS NULL OR data_encerramento >= data_matricula),
    CONSTRAINT fk_matriculas_aluno
        FOREIGN KEY (aluno_id) REFERENCES alunos (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Matrícula ativa ou histórica de um aluno.';

-- Índices de matrículas
CREATE INDEX idx_matriculas_aluno  ON matriculas (aluno_id);
CREATE INDEX idx_matriculas_status ON matriculas (status);


-- =============================================================
-- 6. MATRICULAS_MODALIDADES
--    Modalidades cursadas dentro de uma matrícula.
-- =============================================================
CREATE TABLE matriculas_modalidades (
    id             BIGINT  NOT NULL AUTO_INCREMENT,
    matricula_id   BIGINT  NOT NULL  COMMENT 'FK para matriculas.',
    modalidade_id  BIGINT  NOT NULL  COMMENT 'FK para modalidades.',
    graduacao_id   BIGINT  NOT NULL  COMMENT 'FK para graduacoes.',
    plano_id       BIGINT  NOT NULL  COMMENT 'FK para planos.',
    data_inicio    DATE    NOT NULL DEFAULT (CURRENT_DATE)  COMMENT 'Data de início nesta modalidade.',
    data_fim       DATE              COMMENT 'Data de encerramento; NULL = ainda ativa.',

    PRIMARY KEY (id),
    UNIQUE KEY uq_mat_mod (matricula_id, modalidade_id),
    CONSTRAINT chk_mat_mod_datas
        CHECK (data_fim IS NULL OR data_fim >= data_inicio),
    CONSTRAINT fk_mat_mod_matricula
        FOREIGN KEY (matricula_id) REFERENCES matriculas (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_mat_mod_modalidade
        FOREIGN KEY (modalidade_id) REFERENCES modalidades (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_mat_mod_graduacao
        FOREIGN KEY (graduacao_id) REFERENCES graduacoes (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_mat_mod_plano
        FOREIGN KEY (plano_id) REFERENCES planos (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Modalidades vinculadas a cada matrícula, com plano e graduação atuais.';

-- Índices de matriculas_modalidades
CREATE INDEX idx_mat_mod_matricula  ON matriculas_modalidades (matricula_id);
CREATE INDEX idx_mat_mod_modalidade ON matriculas_modalidades (modalidade_id);


-- =============================================================
-- 7. FATURAS_MATRICULAS
--    Cobranças mensais geradas por matrícula.
-- =============================================================
CREATE TABLE faturas_matriculas (
    id                  BIGINT          NOT NULL AUTO_INCREMENT,
    matricula_id        BIGINT          NOT NULL                    COMMENT 'FK para matriculas.',
    data_vencimento     DATE            NOT NULL                    COMMENT 'Data de vencimento da fatura.',
    valor               DECIMAL(10, 2)  NOT NULL                    COMMENT 'Valor original da fatura (R$).',
    data_pagamento      DATETIME                                    COMMENT 'Data e hora do pagamento.',
    valor_pago          DECIMAL(10, 2)                              COMMENT 'Valor efetivamente pago (pode diferir do original).',
    data_cancelamento   DATETIME                                    COMMENT 'Data e hora do cancelamento.',
    status              ENUM('ABERTA','PAGA','CANCELADA','VENCIDA')
                                        NOT NULL DEFAULT 'ABERTA'   COMMENT 'ABERTA | PAGA | CANCELADA | VENCIDA.',

    PRIMARY KEY (id),
    UNIQUE KEY uq_faturas_matricula_vencimento (matricula_id, data_vencimento),
    CONSTRAINT chk_faturas_valor
        CHECK (valor >= 0),
    CONSTRAINT chk_faturas_valor_pago
        CHECK (valor_pago IS NULL OR valor_pago >= 0),
    CONSTRAINT chk_faturas_paga
        CHECK (status <> 'PAGA'      OR data_pagamento    IS NOT NULL),
    CONSTRAINT chk_faturas_cancelada
        CHECK (status <> 'CANCELADA' OR data_cancelamento IS NOT NULL),
    CONSTRAINT fk_faturas_matricula
        FOREIGN KEY (matricula_id) REFERENCES matriculas (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Faturas mensais de cada matrícula.';

-- Índices de faturas_matriculas
CREATE INDEX idx_faturas_matricula  ON faturas_matriculas (matricula_id);
CREATE INDEX idx_faturas_vencimento ON faturas_matriculas (data_vencimento);
CREATE INDEX idx_faturas_status     ON faturas_matriculas (status);


-- =============================================================
-- 8. ASSIDUIDADE
--    Registro de presença (entrada/saída) de cada aluno.
-- =============================================================
CREATE TABLE assiduidade (
    id             BIGINT    NOT NULL AUTO_INCREMENT,
    matricula_id   BIGINT    NOT NULL  COMMENT 'FK para matriculas.',
    modalidade_id  BIGINT              COMMENT 'FK para modalidades (qual aula foi frequentada).',
    data_entrada   DATETIME  NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT 'Data e hora de entrada.',
    data_saida     DATETIME            COMMENT 'Data e hora de saída; NULL = ainda presente.',

    PRIMARY KEY (id),
    CONSTRAINT chk_assiduidade_saida
        CHECK (data_saida IS NULL OR data_saida > data_entrada),
    CONSTRAINT fk_assiduidade_matricula
        FOREIGN KEY (matricula_id) REFERENCES matriculas (id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    CONSTRAINT fk_assiduidade_modalidade
        FOREIGN KEY (modalidade_id) REFERENCES modalidades (id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
) ENGINE=InnoDB
  DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Registro de entrada e saída de alunos por aula/visita.';

-- Índices de assiduidade
CREATE INDEX idx_assiduidade_matricula ON assiduidade (matricula_id);
CREATE INDEX idx_assiduidade_entrada   ON assiduidade (data_entrada);


