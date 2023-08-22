CREATE OR REPLACE PROCEDURE iterate_through_tasks
IS
BEGIN
    FOR task_rec IN (SELECT * FROM task)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Task name ' || task_rec.name);
    END LOOP;
END;
/

EXEC iterate_through_tasks()