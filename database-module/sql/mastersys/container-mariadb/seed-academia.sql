-- =============================================================
--  SEED DATA: Sistema de Gerenciamento de Academia
--  Banco:     MariaDB (10.5+)
--  Gerado:    2026-06-22
-- =============================================================

SET NAMES utf8mb4;
SET time_zone = '-03:00';
USE academia;

-- =============================================================
-- LIMPEZA (ordem inversa de dependências)
-- =============================================================
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM assiduidade;
DELETE FROM faturas_matriculas;
DELETE FROM matriculas_modalidades;
DELETE FROM matriculas;
DELETE FROM planos;
DELETE FROM graduacoes;
DELETE FROM modalidades;
DELETE FROM alunos;
SET FOREIGN_KEY_CHECKS = 1;

-- Reseta os AUTO_INCREMENT
ALTER TABLE alunos                 AUTO_INCREMENT = 1;
ALTER TABLE modalidades            AUTO_INCREMENT = 1;
ALTER TABLE graduacoes             AUTO_INCREMENT = 1;
ALTER TABLE planos                 AUTO_INCREMENT = 1;
ALTER TABLE matriculas             AUTO_INCREMENT = 1;
ALTER TABLE matriculas_modalidades AUTO_INCREMENT = 1;
ALTER TABLE faturas_matriculas     AUTO_INCREMENT = 1;
ALTER TABLE assiduidade            AUTO_INCREMENT = 1;


-- =============================================================
-- 1. ALUNOS  (20 registros)
-- =============================================================
INSERT INTO alunos (nome, data_nascimento, genero, cpf, telefone, celular, email, observacao,
                    endereco, numero, complemento, bairro, cidade, estado, cep, criado_em)
VALUES
-- 1
('Carlos Eduardo Mendes',    '1995-03-14', 'M', '123.456.789-01', '021-2210-0001', '021-99100-0001', 'carlos.mendes@email.com',
 NULL,
 'Rua das Acácias',    '12',  NULL,         'Tijuca',          'Rio de Janeiro', 'RJ', '20521-050', '2024-01-10 09:00:00'),
-- 2
('Fernanda Lima Souza',      '2000-07-22', 'F', '234.567.890-02', NULL,            '021-99200-0002', 'fernanda.lima@email.com',
 'Alergia a látex — evitar luvas.',
 'Av. Brasil',         '4500','Apto 302',   'Penha',           'Rio de Janeiro', 'RJ', '21012-200', '2024-01-15 10:30:00'),
-- 3
('Rafael Torres Oliveira',   '1988-11-05', 'M', '345.678.901-03', '021-2210-0003', '021-99300-0003', 'rafael.torres@email.com',
 NULL,
 'Rua Visconde de Pirajá','88', NULL,       'Ipanema',         'Rio de Janeiro', 'RJ', '22410-003', '2024-02-01 08:00:00'),
-- 4
('Juliana Costa Ferreira',   '1993-05-30', 'F', '456.789.012-04', NULL,            '021-99400-0004', 'juliana.costa@email.com',
 NULL,
 'Rua Barata Ribeiro', '210','Bloco B',     'Copacabana',      'Rio de Janeiro', 'RJ', '22011-010', '2024-02-10 11:00:00'),
-- 5
('Thiago Alves Pereira',     '1999-09-18', 'M', '567.890.123-05', '021-2210-0005', '021-99500-0005', 'thiago.alves@email.com',
 'Pratica esportes competitivos externamente.',
 'Rua Siqueira Campos','33',  NULL,         'Copacabana',      'Rio de Janeiro', 'RJ', '22031-070', '2024-03-05 14:00:00'),
-- 6
('Mariana Gomes Silva',      '2003-01-11', 'F', '678.901.234-06', NULL,            '021-99600-0006', 'mariana.gomes@email.com',
 NULL,
 'Rua Pinheiro Machado','7', NULL,          'Laranjeiras',     'Rio de Janeiro', 'RJ', '22231-090', '2024-03-20 09:30:00'),
-- 7
('Bruno Nascimento Rocha',   '1991-06-25', 'M', '789.012.345-07', '021-2210-0007', '021-99700-0007', 'bruno.nascimento@email.com',
 NULL,
 'Av. Atlântica',      '1200','Cobertura',  'Copacabana',      'Rio de Janeiro', 'RJ', '22021-001', '2024-04-01 08:30:00'),
-- 8
('Larissa Dias Martins',     '1997-12-02', 'F', '890.123.456-08', NULL,            '021-99800-0008', 'larissa.dias@email.com',
 NULL,
 'Rua Conde de Bonfim','450', NULL,         'Tijuca',          'Rio de Janeiro', 'RJ', '20520-054', '2024-04-10 10:00:00'),
-- 9
('Pedro Henrique Carvalho',  '1985-08-14', 'M', '901.234.567-09', '021-2210-0009', '021-99900-0009', 'pedro.carvalho@email.com',
 'Hipertensão controlada — liberar atestado médico.',
 'Rua São Francisco Xavier','900',NULL,     'Maracanã',        'Rio de Janeiro', 'RJ', '20550-011', '2024-04-15 13:00:00'),
-- 10
('Amanda Ribeiro Teixeira',  '2001-04-08', 'F', '012.345.678-10', NULL,            '021-99000-0010', 'amanda.ribeiro@email.com',
 NULL,
 'Rua Humaitá',        '55',  NULL,         'Humaitá',         'Rio de Janeiro', 'RJ', '22261-001', '2024-05-02 09:00:00'),
-- 11
('Lucas Fernandes Batista',  '1996-02-19', 'M', '111.222.333-11', '021-2211-0011', '021-99111-0011', 'lucas.fernandes@email.com',
 NULL,
 'Rua Jardim Botânico', '300',NULL,         'Jardim Botânico', 'Rio de Janeiro', 'RJ', '22461-000', '2024-05-10 08:00:00'),
-- 12
('Camila Araújo Lopes',      '1990-10-27', 'F', '222.333.444-12', NULL,            '021-99222-0012', 'camila.araujo@email.com',
 NULL,
 'Rua Marquês de São Vicente','12',NULL,    'Gávea',           'Rio de Janeiro', 'RJ', '22451-040', '2024-05-20 10:30:00'),
-- 13
('Gabriel Santos Moreira',   '2002-03-31', 'M', '333.444.555-13', '021-2213-0013', '021-99333-0013', 'gabriel.santos@email.com',
 NULL,
 'Rua Almirante Alexandrino','1500',NULL,   'Santa Teresa',    'Rio de Janeiro', 'RJ', '20241-260', '2024-06-01 09:00:00'),
-- 14
('Isabela Nunes Freitas',    '1998-07-16', 'F', '444.555.666-14', NULL,            '021-99444-0014', 'isabela.nunes@email.com',
 NULL,
 'Rua Dois de Dezembro','180', NULL,        'Flamengo',        'Rio de Janeiro', 'RJ', '22220-041', '2024-06-10 11:00:00'),
-- 15
('Diego Barbosa Ramos',      '1987-01-23', 'M', '555.666.777-15', '021-2215-0015', '021-99555-0015', 'diego.barbosa@email.com',
 'Ex-atleta profissional de judô.',
 'Rua Paissandu',      '90',  NULL,         'Flamengo',        'Rio de Janeiro', 'RJ', '22210-080', '2024-07-05 08:00:00'),
-- 16
('Natália Campos Vieira',    '2004-09-09', 'F', '666.777.888-16', NULL,            '021-99666-0016', 'natalia.campos@email.com',
 'Menor de idade — autorização dos pais arquivada.',
 'Rua Xavier da Silveira','20',NULL,        'Copacabana',      'Rio de Janeiro', 'RJ', '22061-010', '2024-07-15 10:00:00'),
-- 17
('Vitor Hugo Melo',          '1992-05-04', 'M', '777.888.999-17', '021-2217-0017', '021-99777-0017', 'vitor.melo@email.com',
 NULL,
 'Rua General Glicério','33', NULL,         'Laranjeiras',     'Rio de Janeiro', 'RJ', '22245-120', '2024-08-01 09:30:00'),
-- 18
('Beatriz Fonseca Cunha',    '1994-11-28', 'F', '888.999.000-18', NULL,            '021-99888-0018', 'beatriz.fonseca@email.com',
 NULL,
 'Rua Senador Vergueiro','110',NULL,        'Flamengo',        'Rio de Janeiro', 'RJ', '22230-001', '2024-08-12 08:00:00'),
-- 19
('Rodrigo Pinto Azevedo',    '1983-04-17', 'M', '999.000.111-19', '021-2219-0019', '021-99999-0019', 'rodrigo.pinto@email.com',
 'Lesão no joelho esquerdo em 2022 — evitar impacto excessivo.',
 'Rua Assunção',       '77',  NULL,         'Botafogo',        'Rio de Janeiro', 'RJ', '22251-030', '2024-09-03 14:00:00'),
-- 20
('Tatiane Oliveira Cruz',    '2005-06-20', 'F', '000.111.222-20', NULL,            '021-90000-0020', 'tatiane.oliveira@email.com',
 'Menor de idade — autorização dos pais arquivada.',
 'Rua Santa Clara',    '300', 'Apto 101',   'Copacabana',      'Rio de Janeiro', 'RJ', '22041-010', '2024-09-10 09:00:00');


-- =============================================================
-- 2. MODALIDADES  (5 registros)
-- =============================================================
INSERT INTO modalidades (id, nome, descricao) VALUES
(1, 'Jiu-Jitsu Brasileiro',  'Arte marcial e esporte de combate focado em técnicas de grappling e finalização no solo.'),
(2, 'Muay Thai',              'Arte marcial tailandesa conhecida como a arte dos oito membros, utilizando punhos, cotovelos, joelhos e canelas.'),
(3, 'Boxe',                   'Esporte de combate que utiliza somente os punhos enluvados para golpear o adversário.'),
(4, 'Yoga',                   'Prática milenar que une posturas físicas, respiração e meditação para equilíbrio corpo-mente.'),
(5, 'Musculação',             'Treinamento resistido com pesos livres e equipamentos para hipertrofia, força e condicionamento.');


-- =============================================================
-- 3. GRADUAÇÕES
-- =============================================================
-- Jiu-Jitsu (id=1)
INSERT INTO graduacoes (modalidade_id, nome, ordem) VALUES
(1, 'Faixa Branca',   0),
(1, 'Faixa Cinza',    1),
(1, 'Faixa Amarela',  2),
(1, 'Faixa Laranja',  3),
(1, 'Faixa Verde',    4),
(1, 'Faixa Azul',     5),
(1, 'Faixa Roxa',     6),
(1, 'Faixa Marrom',   7),
(1, 'Faixa Preta',    8);

-- Muay Thai (id=2)
INSERT INTO graduacoes (modalidade_id, nome, ordem) VALUES
(2, 'Iniciante',      0),
(2, 'Básico',         1),
(2, 'Intermediário',  2),
(2, 'Avançado',       3),
(2, 'Lutador',        4);

-- Boxe (id=3)
INSERT INTO graduacoes (modalidade_id, nome, ordem) VALUES
(3, 'Iniciante',      0),
(3, 'Intermediário',  1),
(3, 'Avançado',       2),
(3, 'Amador',         3),
(3, 'Profissional',   4);

-- Yoga (id=4)
INSERT INTO graduacoes (modalidade_id, nome, ordem) VALUES
(4, 'Iniciante',      0),
(4, 'Praticante',     1),
(4, 'Avançado',       2),
(4, 'Instrutor',      3);

-- Musculação (id=5)
INSERT INTO graduacoes (modalidade_id, nome, ordem) VALUES
(5, 'Iniciante',      0),
(5, 'Intermediário',  1),
(5, 'Avançado',       2);


-- =============================================================
-- 4. PLANOS
-- =============================================================
-- Jiu-Jitsu (id=1)
INSERT INTO planos (modalidade_id, nome, descricao, valor_mensal, ativo) VALUES
(1, 'JJ Básico 2x',   'Jiu-Jitsu 2 vezes por semana.',        180.00, 1),
(1, 'JJ Standard 3x', 'Jiu-Jitsu 3 vezes por semana.',        240.00, 1),
(1, 'JJ Full',        'Jiu-Jitsu acesso ilimitado à semana.',  300.00, 1);

-- Muay Thai (id=2)
INSERT INTO planos (modalidade_id, nome, descricao, valor_mensal, ativo) VALUES
(2, 'MT Básico 2x',   'Muay Thai 2 vezes por semana.',         160.00, 1),
(2, 'MT Standard 3x', 'Muay Thai 3 vezes por semana.',         210.00, 1),
(2, 'MT Full',        'Muay Thai acesso ilimitado à semana.',   260.00, 1);

-- Boxe (id=3)
INSERT INTO planos (modalidade_id, nome, descricao, valor_mensal, ativo) VALUES
(3, 'Boxe Básico',    'Boxe 2 vezes por semana.',              150.00, 1),
(3, 'Boxe Avançado',  'Boxe 3 vezes por semana + sparring.',   220.00, 1);

-- Yoga (id=4)
INSERT INTO planos (modalidade_id, nome, descricao, valor_mensal, ativo) VALUES
(4, 'Yoga 2x',        'Yoga 2 vezes por semana.',              130.00, 1),
(4, 'Yoga Full',      'Yoga acesso ilimitado à semana.',        180.00, 1);

-- Musculação (id=5)
INSERT INTO planos (modalidade_id, nome, descricao, valor_mensal, ativo) VALUES
(5, 'Musculação Mensal', 'Acesso livre à sala de musculação.',  120.00, 1),
(5, 'Musculação + Personal', 'Musculação com 4 sessões/mês de personal trainer.', 320.00, 1);


-- =============================================================
-- 5. MATRÍCULAS  (15 registros)
-- =============================================================
INSERT INTO matriculas (id, aluno_id, data_matricula, dia_vencimento, data_encerramento, status, criado_em) VALUES
(1,  1,  '2024-01-10', 10, NULL,         'ATIVA',      '2024-01-10 09:00:00'),
(2,  2,  '2024-01-15', 15, NULL,         'ATIVA',      '2024-01-15 10:30:00'),
(3,  3,  '2024-02-01',  5, NULL,         'ATIVA',      '2024-02-01 08:00:00'),
(4,  4,  '2024-02-10', 10, NULL,         'ATIVA',      '2024-02-10 11:00:00'),
(5,  5,  '2024-03-05', 20, NULL,         'ATIVA',      '2024-03-05 14:00:00'),
(6,  6,  '2024-03-20', 20, NULL,         'ATIVA',      '2024-03-20 09:30:00'),
(7,  7,  '2024-04-01',  1, NULL,         'ATIVA',      '2024-04-01 08:30:00'),
(8,  8,  '2024-04-10', 10, NULL,         'ATIVA',      '2024-04-10 10:00:00'),
(9,  9,  '2024-04-15', 15, NULL,         'ATIVA',      '2024-04-15 13:00:00'),
(10, 10, '2024-05-02',  5, NULL,         'ATIVA',      '2024-05-02 09:00:00'),
(11, 11, '2024-05-10', 10, NULL,         'ATIVA',      '2024-05-10 08:00:00'),
(12, 12, '2024-05-20', 20, NULL,         'ATIVA',      '2024-05-20 10:30:00'),
(13, 13, '2024-06-01', 28, NULL,         'ATIVA',      '2024-06-01 09:00:00'),
-- Matrícula encerrada
(14, 14, '2024-06-10', 10, '2024-12-31', 'ENCERRADA',  '2024-06-10 11:00:00'),
-- Matrícula cancelada
(15, 15, '2024-07-05',  5, '2024-10-15', 'CANCELADA',  '2024-07-05 08:00:00');


-- =============================================================
-- 6. MATRICULAS_MODALIDADES
--    Referência de IDs de graduações e planos:
--
--    Jiu-Jitsu graduações: 1=Branca, 2=Cinza, 3=Amarela, 4=Laranja,
--                          5=Verde,  6=Azul,  7=Roxa,    8=Marrom, 9=Preta
--    Muay Thai graduações: 10=Iniciante,11=Básico,12=Intermediário,
--                          13=Avançado,14=Lutador
--    Boxe graduações:      15=Iniciante,16=Intermediário,17=Avançado,
--                          18=Amador,19=Profissional
--    Yoga graduações:      20=Iniciante,21=Praticante,22=Avançado,23=Instrutor
--    Musculação graduações:24=Iniciante,25=Intermediário,26=Avançado
--
--    Planos: 1=JJ Básico 2x, 2=JJ Standard 3x, 3=JJ Full,
--            4=MT Básico 2x, 5=MT Standard 3x, 6=MT Full,
--            7=Boxe Básico,  8=Boxe Avançado,
--            9=Yoga 2x,     10=Yoga Full,
--           11=Musculação Mensal, 12=Musculação+Personal
-- =============================================================
INSERT INTO matriculas_modalidades
    (matricula_id, modalidade_id, graduacao_id, plano_id, data_inicio, data_fim)
VALUES
-- Carlos: Jiu-Jitsu Faixa Azul, Full
(1,  1, 6,  3,  '2024-01-10', NULL),
-- Carlos também faz Musculação Intermediário, Mensal
(1,  5, 25, 11, '2024-03-01', NULL),
-- Fernanda: Yoga Praticante, Full
(2,  4, 21, 10, '2024-01-15', NULL),
-- Rafael: Muay Thai Avançado, Full
(3,  2, 13,  6, '2024-02-01', NULL),
-- Rafael também faz Boxe Intermediário, Avançado
(3,  3, 16,  8, '2024-04-01', NULL),
-- Juliana: Yoga Iniciante, 2x
(4,  4, 20,  9, '2024-02-10', NULL),
-- Thiago: Jiu-Jitsu Branca, Básico 2x
(5,  1, 1,   1, '2024-03-05', NULL),
-- Mariana: Musculação Iniciante, Mensal
(6,  5, 24, 11, '2024-03-20', NULL),
-- Bruno: Boxe Profissional, Avançado
(7,  3, 19,  8, '2024-04-01', NULL),
-- Larissa: Jiu-Jitsu Roxa, Standard 3x
(8,  1, 7,   2, '2024-04-10', NULL),
-- Pedro: Musculação Avançado, Personal
(9,  5, 26, 12, '2024-04-15', NULL),
-- Amanda: Yoga Iniciante, 2x
(10, 4, 20,  9, '2024-05-02', NULL),
-- Lucas: Muay Thai Intermediário, Standard 3x
(11, 2, 12,  5, '2024-05-10', NULL),
-- Camila: Jiu-Jitsu Cinza, Básico 2x
(12, 1, 2,   1, '2024-05-20', NULL),
-- Gabriel: Boxe Iniciante, Básico
(13, 3, 15,  7, '2024-06-01', NULL),
-- Isabela (encerrada): Yoga Praticante, Full — encerrada junto com matrícula
(14, 4, 21, 10, '2024-06-10', '2024-12-31'),
-- Diego (cancelada): Jiu-Jitsu Preta, Full — encerrada junto com cancelamento
(15, 1, 9,   3, '2024-07-05', '2024-10-15');


-- =============================================================
-- 7. FATURAS_MATRICULAS
--    Geradas mensalmente por matrícula ativa.
--    Faixas cobertas: jan/2024 a mai/2025 (conforme atividade).
-- =============================================================
INSERT INTO faturas_matriculas
    (matricula_id, data_vencimento, valor, data_pagamento, valor_pago, data_cancelamento, status)
VALUES
-- -------------------------------------------------------
-- Matrícula 1 – Carlos (JJ Full 300 + Musculação 120)
--   valor consolidado por simplicidade: 420,00/mês
-- -------------------------------------------------------
(1, '2024-02-10', 300.00, '2024-02-09 10:00:00', 300.00, NULL, 'PAGA'),
(1, '2024-03-10', 300.00, '2024-03-08 09:30:00', 300.00, NULL, 'PAGA'),
(1, '2024-04-10', 420.00, '2024-04-10 11:00:00', 420.00, NULL, 'PAGA'),  -- musculação entra em mar
(1, '2024-05-10', 420.00, '2024-05-09 10:00:00', 420.00, NULL, 'PAGA'),
(1, '2024-06-10', 420.00, '2024-06-10 08:45:00', 420.00, NULL, 'PAGA'),
(1, '2024-07-10', 420.00, '2024-07-09 09:00:00', 420.00, NULL, 'PAGA'),
(1, '2024-08-10', 420.00, '2024-08-08 10:15:00', 420.00, NULL, 'PAGA'),
(1, '2024-09-10', 420.00, '2024-09-10 09:00:00', 420.00, NULL, 'PAGA'),
(1, '2024-10-10', 420.00, '2024-10-09 11:00:00', 420.00, NULL, 'PAGA'),
(1, '2024-11-10', 420.00, '2024-11-08 09:30:00', 420.00, NULL, 'PAGA'),
(1, '2024-12-10', 420.00, '2024-12-10 10:00:00', 420.00, NULL, 'PAGA'),
(1, '2025-01-10', 420.00, '2025-01-09 08:30:00', 420.00, NULL, 'PAGA'),
(1, '2025-02-10', 420.00, '2025-02-10 11:00:00', 420.00, NULL, 'PAGA'),
(1, '2025-03-10', 420.00, '2025-03-09 09:00:00', 420.00, NULL, 'PAGA'),
(1, '2025-04-10', 420.00, '2025-04-10 10:30:00', 420.00, NULL, 'PAGA'),
(1, '2025-05-10', 420.00, NULL,                  NULL,   NULL, 'ABERTA'),

-- -------------------------------------------------------
-- Matrícula 2 – Fernanda (Yoga Full 180,00)
-- -------------------------------------------------------
(2, '2024-02-15', 180.00, '2024-02-14 09:00:00', 180.00, NULL, 'PAGA'),
(2, '2024-03-15', 180.00, '2024-03-15 10:00:00', 180.00, NULL, 'PAGA'),
(2, '2024-04-15', 180.00, '2024-04-13 09:30:00', 180.00, NULL, 'PAGA'),
(2, '2024-05-15', 180.00, '2024-05-15 11:00:00', 180.00, NULL, 'PAGA'),
(2, '2024-06-15', 180.00, '2024-06-14 09:00:00', 180.00, NULL, 'PAGA'),
(2, '2024-07-15', 180.00, '2024-07-15 10:30:00', 180.00, NULL, 'PAGA'),
(2, '2024-08-15', 180.00, '2024-08-14 09:00:00', 180.00, NULL, 'PAGA'),
(2, '2024-09-15', 180.00, NULL,                  NULL,   NULL, 'VENCIDA'),  -- inadimplente
(2, '2024-10-15', 180.00, NULL,                  NULL,   NULL, 'VENCIDA'),
(2, '2024-11-15', 180.00, '2024-11-20 14:00:00', 360.00, NULL, 'PAGA'),    -- pagou dois juntos
(2, '2024-12-15', 180.00, '2024-12-14 09:30:00', 180.00, NULL, 'PAGA'),
(2, '2025-01-15', 180.00, '2025-01-15 10:00:00', 180.00, NULL, 'PAGA'),
(2, '2025-02-15', 180.00, '2025-02-14 09:00:00', 180.00, NULL, 'PAGA'),
(2, '2025-03-15', 180.00, '2025-03-15 11:30:00', 180.00, NULL, 'PAGA'),
(2, '2025-04-15', 180.00, '2025-04-14 09:00:00', 180.00, NULL, 'PAGA'),
(2, '2025-05-15', 180.00, NULL,                  NULL,   NULL, 'ABERTA'),

-- -------------------------------------------------------
-- Matrícula 3 – Rafael (MT Full 260 + Boxe Avançado 220 = 480)
-- -------------------------------------------------------
(3, '2024-03-05', 260.00, '2024-03-04 09:00:00', 260.00, NULL, 'PAGA'),
(3, '2024-04-05', 260.00, '2024-04-05 10:00:00', 260.00, NULL, 'PAGA'),
(3, '2024-05-05', 480.00, '2024-05-04 09:30:00', 480.00, NULL, 'PAGA'),  -- Boxe entra em abr
(3, '2024-06-05', 480.00, '2024-06-04 10:00:00', 480.00, NULL, 'PAGA'),
(3, '2024-07-05', 480.00, '2024-07-05 09:00:00', 480.00, NULL, 'PAGA'),
(3, '2024-08-05', 480.00, '2024-08-04 11:00:00', 480.00, NULL, 'PAGA'),
(3, '2024-09-05', 480.00, '2024-09-05 09:30:00', 480.00, NULL, 'PAGA'),
(3, '2024-10-05', 480.00, '2024-10-04 10:00:00', 480.00, NULL, 'PAGA'),
(3, '2024-11-05', 480.00, '2024-11-05 09:00:00', 480.00, NULL, 'PAGA'),
(3, '2024-12-05', 480.00, '2024-12-04 09:30:00', 480.00, NULL, 'PAGA'),
(3, '2025-01-05', 480.00, '2025-01-05 10:00:00', 480.00, NULL, 'PAGA'),
(3, '2025-02-05', 480.00, '2025-02-04 09:00:00', 480.00, NULL, 'PAGA'),
(3, '2025-03-05', 480.00, '2025-03-05 11:00:00', 480.00, NULL, 'PAGA'),
(3, '2025-04-05', 480.00, '2025-04-04 09:30:00', 480.00, NULL, 'PAGA'),
(3, '2025-05-05', 480.00, NULL,                  NULL,   NULL, 'ABERTA'),

-- -------------------------------------------------------
-- Matrícula 5 – Thiago (JJ Básico 2x 180,00)
-- -------------------------------------------------------
(5, '2024-04-20', 180.00, '2024-04-19 10:00:00', 180.00, NULL, 'PAGA'),
(5, '2024-05-20', 180.00, '2024-05-20 09:30:00', 180.00, NULL, 'PAGA'),
(5, '2024-06-20', 180.00, '2024-06-19 10:00:00', 180.00, NULL, 'PAGA'),
(5, '2024-07-20', 180.00, '2024-07-20 09:00:00', 180.00, NULL, 'PAGA'),
(5, '2024-08-20', 180.00, NULL,                  NULL,   NULL, 'VENCIDA'),
(5, '2024-09-20', 180.00, '2024-09-25 15:00:00', 360.00, NULL, 'PAGA'),  -- regularizou
(5, '2024-10-20', 180.00, '2024-10-19 10:00:00', 180.00, NULL, 'PAGA'),
(5, '2024-11-20', 180.00, '2024-11-20 09:30:00', 180.00, NULL, 'PAGA'),
(5, '2024-12-20', 180.00, '2024-12-19 10:00:00', 180.00, NULL, 'PAGA'),
(5, '2025-01-20', 180.00, '2025-01-19 09:00:00', 180.00, NULL, 'PAGA'),
(5, '2025-02-20', 180.00, '2025-02-20 10:30:00', 180.00, NULL, 'PAGA'),
(5, '2025-03-20', 180.00, '2025-03-19 09:00:00', 180.00, NULL, 'PAGA'),
(5, '2025-04-20', 180.00, '2025-04-20 10:00:00', 180.00, NULL, 'PAGA'),
(5, '2025-05-20', 180.00, NULL,                  NULL,   NULL, 'ABERTA'),

-- -------------------------------------------------------
-- Matrícula 9 – Pedro (Musculação + Personal 320,00)
-- -------------------------------------------------------
(9, '2024-05-15', 320.00, '2024-05-14 09:00:00', 320.00, NULL, 'PAGA'),
(9, '2024-06-15', 320.00, '2024-06-14 09:30:00', 320.00, NULL, 'PAGA'),
(9, '2024-07-15', 320.00, '2024-07-15 10:00:00', 320.00, NULL, 'PAGA'),
(9, '2024-08-15', 320.00, '2024-08-14 09:00:00', 320.00, NULL, 'PAGA'),
(9, '2024-09-15', 320.00, '2024-09-13 10:30:00', 320.00, NULL, 'PAGA'),
(9, '2024-10-15', 320.00, '2024-10-15 09:00:00', 320.00, NULL, 'PAGA'),
(9, '2024-11-15', 320.00, '2024-11-14 11:00:00', 320.00, NULL, 'PAGA'),
(9, '2024-12-15', 320.00, '2024-12-14 09:30:00', 320.00, NULL, 'PAGA'),
(9, '2025-01-15', 320.00, '2025-01-15 10:00:00', 320.00, NULL, 'PAGA'),
(9, '2025-02-15', 320.00, '2025-02-14 09:00:00', 320.00, NULL, 'PAGA'),
(9, '2025-03-15', 320.00, '2025-03-14 10:30:00', 320.00, NULL, 'PAGA'),
(9, '2025-04-15', 320.00, '2025-04-15 09:00:00', 320.00, NULL, 'PAGA'),
(9, '2025-05-15', 320.00, NULL,                  NULL,   NULL, 'ABERTA'),

-- -------------------------------------------------------
-- Matrícula 14 – Isabela (encerrada em 31/12/2024, Yoga Full 180)
-- -------------------------------------------------------
(14, '2024-07-10', 180.00, '2024-07-09 09:00:00', 180.00, NULL,                  'PAGA'),
(14, '2024-08-10', 180.00, '2024-08-10 10:00:00', 180.00, NULL,                  'PAGA'),
(14, '2024-09-10', 180.00, '2024-09-09 09:30:00', 180.00, NULL,                  'PAGA'),
(14, '2024-10-10', 180.00, '2024-10-10 11:00:00', 180.00, NULL,                  'PAGA'),
(14, '2024-11-10', 180.00, '2024-11-09 09:00:00', 180.00, NULL,                  'PAGA'),
(14, '2024-12-10', 180.00, '2024-12-10 10:00:00', 180.00, NULL,                  'PAGA'),
-- Fatura de jan/2025 cancelada junto com encerramento
(14, '2025-01-10', 180.00, NULL,                  NULL,   '2025-01-02 08:00:00', 'CANCELADA'),

-- -------------------------------------------------------
-- Matrícula 15 – Diego (cancelada em out/2024, JJ Full 300)
-- -------------------------------------------------------
(15, '2024-08-05', 300.00, '2024-08-04 09:00:00', 300.00, NULL,                  'PAGA'),
(15, '2024-09-05', 300.00, '2024-09-05 10:00:00', 300.00, NULL,                  'PAGA'),
(15, '2024-10-05', 300.00, NULL,                  NULL,   '2024-10-16 08:00:00', 'CANCELADA');


-- =============================================================
-- 8. ASSIDUIDADE  (registros de presença — ~30 entradas)
-- =============================================================
INSERT INTO assiduidade (matricula_id, modalidade_id, data_entrada, data_saida) VALUES
-- Carlos – Jiu-Jitsu
(1, 1, '2025-04-01 19:00:00', '2025-04-01 20:30:00'),
(1, 1, '2025-04-03 19:00:00', '2025-04-03 20:30:00'),
(1, 1, '2025-04-07 19:00:00', '2025-04-07 20:45:00'),
(1, 5, '2025-04-02 07:00:00', '2025-04-02 08:30:00'),  -- musculação manhã
(1, 1, '2025-04-10 19:00:00', '2025-04-10 20:30:00'),
(1, 5, '2025-04-09 07:00:00', '2025-04-09 08:30:00'),
-- Carlos – ainda presente (sem saída)
(1, 1, '2025-05-05 19:00:00', NULL),

-- Fernanda – Yoga
(2, 4, '2025-04-02 08:00:00', '2025-04-02 09:00:00'),
(2, 4, '2025-04-05 08:00:00', '2025-04-05 09:00:00'),
(2, 4, '2025-04-09 08:00:00', '2025-04-09 09:00:00'),
(2, 4, '2025-04-12 08:00:00', '2025-04-12 09:00:00'),

-- Rafael – Muay Thai e Boxe
(3, 2, '2025-04-01 18:00:00', '2025-04-01 19:30:00'),
(3, 3, '2025-04-03 18:00:00', '2025-04-03 19:30:00'),
(3, 2, '2025-04-07 18:00:00', '2025-04-07 19:30:00'),
(3, 3, '2025-04-10 18:00:00', '2025-04-10 19:30:00'),
(3, 2, '2025-04-14 18:00:00', '2025-04-14 19:45:00'),

-- Thiago – Jiu-Jitsu
(5, 1, '2025-04-01 20:00:00', '2025-04-01 21:15:00'),
(5, 1, '2025-04-04 20:00:00', '2025-04-04 21:15:00'),
(5, 1, '2025-04-08 20:00:00', '2025-04-08 21:30:00'),
(5, 1, '2025-04-11 20:00:00', '2025-04-11 21:15:00'),

-- Pedro – Musculação
(9, 5, '2025-04-01 06:30:00', '2025-04-01 08:00:00'),
(9, 5, '2025-04-03 06:30:00', '2025-04-03 08:00:00'),
(9, 5, '2025-04-07 06:30:00', '2025-04-07 08:15:00'),
(9, 5, '2025-04-10 06:30:00', '2025-04-10 08:00:00'),
(9, 5, '2025-04-14 06:30:00', '2025-04-14 08:10:00'),

-- Bruno – Boxe
(7, 3, '2025-04-02 17:00:00', '2025-04-02 18:30:00'),
(7, 3, '2025-04-05 17:00:00', '2025-04-05 18:30:00'),
(7, 3, '2025-04-09 17:00:00', '2025-04-09 18:45:00'),
(7, 3, '2025-04-12 17:00:00', '2025-04-12 18:30:00'),

-- Larissa – Jiu-Jitsu
(8, 1, '2025-04-02 19:30:00', '2025-04-02 21:00:00'),
(8, 1, '2025-04-05 19:30:00', '2025-04-05 21:00:00'),
(8, 1, '2025-04-09 19:30:00', '2025-04-09 21:15:00');
