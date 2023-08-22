DECLARE
    l_notes_count INTEGER;
BEGIN
    SELECT COUNT(*)
    INTO l_notes_count
    FROM Note
    WHERE project_id = 0;

    DBMS_OUTPUT.PUT_LINE(
        'У проекта  ' ||
        l_notes_count ||
        ' заметок');

    -- Я решил изменить написаие своего имени ...
    UPDATE Reference_Link
    SET link = REPLACE (link, 'confluence', 'mediawiki')
    WHERE link LIKE '%confluence%';
END;