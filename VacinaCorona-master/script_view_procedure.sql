#CRIAR VIEW
CREATE VIEW vw_info_vacinas
AS SELECT nome_vacina, estoque, governo.nome, empresa.nome_empresa
FROM vacina inner join governo on vacina.id_governo = governo.id_governo
            inner join empresa on vacina.id_empresa = empresa.id_empresa;

#CRIAR PROCEDURE
DELIMITER $$
CREATE PROCEDURE Carregar_view()
BEGIN
SELECT * FROM vw_info_vacinas;
END $$
DELIMITER ;

#CHAMAR PROCEDURE
CALL Carregar_view()