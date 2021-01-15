CREATE OR REPLACE PROCEDURE calc_totals
IS
    l_year_total NUMBER;
BEGIN
    l_year_total := 5;
    DBMS_OUTPUT.PUT_LINE('Количество лет = ' || l_year_total);

    /* Начало вложенного блока */
    DECLARE
        l_month_total NUMBER;
    BEGIN
        l_month_total := l_year_total / 12;
        DBMS_OUTPUT.PUT_LINE('Количество месяцев = ' || l_month_total);
    END set_l_month_total;
    /* Конец вложенного блока */

END;
/

execute calc_totals