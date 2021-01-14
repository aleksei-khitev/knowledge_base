BEGIN
    DBMS_OUTPUT.PUT_LINE('Simplest anon block. Sys date = ' || SYSDATE);
END;
/

DECLARE
    l_current_date VARCHAR2(9);
BEGIN
    l_current_date := SYSDATE;
    DBMS_OUTPUT.PUT_LINE('Anon block with declaration. Sys date = ' || l_current_date);
END;
/

DECLARE
    l_current_date VARCHAR2(9);
BEGIN
    l_current_date := SYSDATE;
    DBMS_OUTPUT.PUT_LINE('Anon block with declaration and exception. Sys date = ' || l_current_date);
EXCEPTION
    WHEN VALUE_ERROR
    THEN
        DBMS_OUTPUT.PUT_LINE('Проблемы с местом для стандартного вывода даты');
END;
/