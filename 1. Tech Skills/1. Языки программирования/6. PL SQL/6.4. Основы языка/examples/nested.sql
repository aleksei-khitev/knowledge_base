CREATE OR REPLACE PROCEDURE calculate_bonus (good_calls IN NUMBER, averall_calls IN NUMBER)
IS
    bonus_low_border NUMBER := 95;
    good_calls_percentage NUMBER;

    PROCEDURE compute_percentage
    IS
    BEGIN
        good_calls_percentage := good_calls * 100 / averall_calls;
    END compute_percentage;
BEGIN
    compute_percentage;
    DBMS_OUTPUT.PUT_LINE('Percentage of good calls = ' || good_calls_percentage);
    IF good_calls_percentage >= bonus_low_border
    THEN
        DBMS_OUTPUT.PUT_LINE('Bonus accepted');
    ELSE
        DBMS_OUTPUT.PUT_LINE('No bonus');
    END IF;
END calculate_bonus;
/

EXECUTE calculate_bonus(94, 100);