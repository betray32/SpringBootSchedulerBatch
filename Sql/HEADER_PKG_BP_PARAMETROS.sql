create or replace PACKAGE PKG_PARAM_SPRINGBATCH
AS
-- Package header

  -- Autor  : CCONTRERASC
  -- Fecha : 20190731
  -- Objetivo :Obtener los valores asociados a la tabla parametrica de para SpringBatch de notificaciones
PROCEDURE USP_PARAM_NOTIFICACIONES
                                (
                                  ENABLED OUT INTEGER,
                                  FIXEDRATE OUT INTEGER,
                                  FIXEDDELAY OUT INTEGER,
                                  ESTADO OUT VARCHAR2
                                );
                                


END PKG_PARAM_SPRINGBATCH;
