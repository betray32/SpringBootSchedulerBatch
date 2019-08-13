-- Package BODY

  -- Autor  : CCONTRERASC
  -- Fecha : 20190731
  -- Objetivo :Obtener los valores asociados a la tabla parametrica de para SpringBatch
create or replace PACKAGE BODY PKG_PARAM_SPRINGBATCH
AS

-- Procedure para obtener los datos desde la tabla
PROCEDURE USP_PARAM_NOTIFICACIONES
                                (
                                  ENABLED OUT INTEGER,
                                  FIXEDRATE OUT INTEGER,
                                  FIXEDDELAY OUT INTEGER,
                                  ESTADO OUT VARCHAR2
                                )
 IS
	BEGIN 
	
		SELECT ENABLED, FIXEDRATE, FIXEDDELAY, ESTADO
		INTO ENABLED, FIXEDRATE, FIXEDDELAY, ESTADO
		FROM PARAMETRIZACION_SPRING_BATCH;

	END ;

	END PKG_PARAM_SPRINGBATCH;