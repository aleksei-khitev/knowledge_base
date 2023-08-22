CREATE OR REPLACE PROCEDURE anything_critical (project_id IN Project.id%TYPE)
IS
    l_story_points_remaining NUMBER;
BEGIN
    l_story_points_remaining := 10;
    DBMS_OUTPUT.PUT_LINE('Запланированно ' || l_story_points_remaining || ' SP');

    UPDATE Task
    SET status_id = 0
    WHERE status_id < 2;
    DBMS_OUTPUT.PUT_LINE('Все задачи IN PROGRESS переведены в OPENED');

    FOR task IN (
        SELECT * FROM Task
        WHERE status_id < 2
        ORDER BY priority_id
    )  LOOP
        DBMS_OUTPUT.PUT_LINE('Текущий запас SP ' || l_story_points_remaining);
        IF l_story_points_remaining - task.estimation > 0
        THEN
            UPDATE Task t
            SET t.status_id = 1
            WHERE id = task.id;
            DBMS_OUTPUT.PUT_LINE('Задача с ID ' || task.id || ' переведена в IN PROGRESS');

            l_story_points_remaining := l_story_points_remaining - task.estimation;
        ELSE
            DBMS_OUTPUT.PUT_LINE('Осталось мало SP (' || l_story_points_remaining || ') - завершаемся');
            EXIT;
        END IF;
    END LOOP;
END anything_critical;

-- Для выполнения
EXECUTE anything_critical(0);