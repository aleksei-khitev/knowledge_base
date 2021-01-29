CREATE OR REPLACE PROCEDURE craft_shortcut_translator(craft_shortcut IN VARCHAR2)
IS
    invalid_craft_shortcut EXCEPTION;
BEGIN
    CASE craft_shortcut
    WHEN 'MS' THEN
        DBMS_OUTPUT.PUT_LINE('Metall Smith');
    WHEN 'T' THEN
        DBMS_OUTPUT.PUT_LINE('Tailor');
    ELSE
        RAISE invalid_craft_shortcut;
    END CASE;
END;
/

EXEC craft_shortcut_translator('MS');
EXEC craft_shortcut_translator('T');