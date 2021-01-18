CREATE OR REPLACE PACKAGE eso
IS
    resistance_cap NUMBER := 33;
END eso;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('resistance cap = ' || eso.resistance_cap);
END;
/