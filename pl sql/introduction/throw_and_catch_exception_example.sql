CREATE OR REPLACE PROCEDURE throw_and_catch_exception
IS
    l_some_custom_exception EXCEPTION;
BEGIN
    IF 0 = 0
    THEN
        RAISE l_some_custom_exception;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND
    THEN
        DBMS_OUTPUT.PUT_LINE('not found exception');
        RAISE;
    WHEN l_some_custom_exception
    THEN
        DBMS_OUTPUT.PUT_LINE('custom exception');
        RAISE;
END;

EXECUTE throw_and_catch_exception();