CREATE OR REPLACE PROCEDURE multiply
IS
    l_multiplier NUMBER := 0.9;
BEGIN
    <<outer_block>>
    DECLARE
        l_multiplier NUMBER := 0.8;
    BEGIN

        DECLARE
            l_multiplier NUMBER := 0.7;
        BEGIN
            DBMS_OUTPUT.PUT_LINE('nested multiplier = ' || l_multiplier);
            DBMS_OUTPUT.PUT_LINE('outer multiplier = ' || outer_block.l_multiplier);
            DBMS_OUTPUT.PUT_LINE('procedure multiplier = ' || multiply.l_multiplier);
        END;
    END outer_block;
    /* Конец вложенного блока */

END;
/

execute multiply