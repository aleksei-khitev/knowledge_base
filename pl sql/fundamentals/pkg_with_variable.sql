CREATE OR REPLACE PACKAGE eso
IS
    resistance_cap NUMBER;
END eso;
/

BEGIN
    eso.resistance_cap := 33;
    DBMS_OUTPUT.PUT_LINE('resistance cap = ' || eso.resistance_cap);
END;
/