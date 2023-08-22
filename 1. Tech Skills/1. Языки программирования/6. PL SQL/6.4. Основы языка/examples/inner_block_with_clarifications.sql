CREATE OR REPLACE PROCEDURE calc_totals
IS
    l_year_total NUMBER;
    l_owner_block VARCHAR2(20);
BEGIN
    l_year_total := 5;
    l_owner_block := 'PROCEDURE';
    DBMS_OUTPUT.PUT_LINE('years count = ' || calc_totals.l_year_total);

    /* Начало вложенного блока */
    <<local_block>>
    DECLARE
        l_month_total NUMBER;
        l_owner_block VARCHAR2(20);
    BEGIN
        local_block.l_month_total := calc_totals.l_year_total / 12;
        DBMS_OUTPUT.PUT_LINE('Months count = ' || local_block.l_month_total);

        l_owner_block := 'LOCAL BLOCK';
        DBMS_OUTPUT.PUT_LINE('l_owner_block = ' || l_owner_block);
        DBMS_OUTPUT.PUT_LINE('calc_totals.l_owner_block = ' || calc_totals.l_owner_block);
    END set_l_month_total;
    /* Конец вложенного блока */

END;
/

execute calc_totals