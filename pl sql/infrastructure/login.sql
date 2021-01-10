-- Количество строк выходных данных инструкции SELECT
-- перед повторным выводом заголовков
SET PAGESIZE 999

-- Ширина выводимой строки в символах
SET LINESIZE 250

-- Включение вывода сообщений DBMS_OUTPUT.
-- В версиях, предшествующих Oracle Database 10g Release 2,
-- вместо UNLIMITED следует использовать значение 1000000.
SET SERVEROUTPUT ON SIZE UNLIMITED FORMAT WRAPPED

-- Замена внешнего текстового редактора
DEFINE _EDITOR = "C:\Program Files\Notepad++\notepad++.exe"

-- Форматирование столбцов, извлекаемых из словаря данных
COLUMN segment_name FORMAT A30 WORD_WRAP
COLUMN object_name FORMAT A30 WORD_WRAP

-- Настройка приглашения (работает в SQL*Plus Oracle9i и выше)
SET SQLPROMPT "_USER'@'_CONNECT_IDENTIFIER > "