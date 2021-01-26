BEGIN
    <<outer_loop>>
    LOOP
        DBMS_OUTPUT.PUT_LINE('Outer Iteration');
        LOOP
            DBMS_OUTPUT.PUT_LINE('Inner Iteration');
            EXIT outer_loop;
        END LOOP;
    END LOOP;
END;
/