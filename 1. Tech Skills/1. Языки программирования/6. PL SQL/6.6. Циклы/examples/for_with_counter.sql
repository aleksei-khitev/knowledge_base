CREATE OR REPLACE PROCEDURE simple_counter(min_border IN INTEGER, max_border IN INTEGER)
IS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Borders = [' || min_border || ', ' || max_border || ']');
    DBMS_OUTPUT.PUT_LINE('Iteration with normal order');
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    FOR iterator_variable IN min_border .. max_border
    LOOP
        DBMS_OUTPUT.PUT_LINE('Iterator Value = ' || iterator_variable);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    DBMS_OUTPUT.PUT_LINE('Iteration with reverse order');
    DBMS_OUTPUT.PUT_LINE('---------------------------');
    FOR iterator_variable IN REVERSE min_border .. max_border
    LOOP
        DBMS_OUTPUT.PUT_LINE('Iterator Value = ' || iterator_variable);
    END LOOP;
END;
/

EXEC simple_counter(1, 5)