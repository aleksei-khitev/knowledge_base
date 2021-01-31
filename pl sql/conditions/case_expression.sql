CREATE OR REPLACE PROCEDURE bonus_to_salary(good_calls IN NUMBER)
IS
    l_addition_to_salary NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Good calls = ' || good_calls);
    l_addition_to_salary :=
        CASE
            WHEN good_calls >= 98 THEN 3000
            WHEN good_calls >= 97 THEN 2000
            WHEN good_calls >= 96 THEN 1000
            ELSE 0
        END;
    DBMS_OUTPUT.PUT_LINE('Addition to salary for good calls = ' || l_addition_to_salary);
END;
/

EXEC bonus_to_salary(98.1);
EXEC bonus_to_salary(97.5);
EXEC bonus_to_salary(95);