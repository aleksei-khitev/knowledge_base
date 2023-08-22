CREATE OR REPLACE PROCEDURE three_values_logic (flag IN BOOLEAN)
IS
BEGIN
    IF flag
    THEN
        DBMS_OUTPUT.PUT_LINE('Then branch. Condition = ' || diutil.bool_to_int(flag));
    ELSE
        DBMS_OUTPUT.PUT_LINE('Else branch. Condition = ' || diutil.bool_to_int(flag));
    END IF;
END;
/

execute three_values_logic(TRUE);
execute three_values_logic(FALSE);
execute three_values_logic(NULL);