INSERT INTO Task_Link_Type(id, name) VALUES (0, 'Jira');
INSERT INTO Task_Link_Type(id, name) VALUES (1, 'Wiki');

INSERT INTO Task(id, project_id, name, priority_id, useful_info, status_id, estimation)
    VALUES (3, 0, 'Move info to the new wiki', 1, '', 1, 8);

INSERT INTO Task_Link(id, task_id, type_id, name, link)
    VALUES (0, 3, 0, 'Story', 'http://jira.some_org.com/CODE-3312');
INSERT INTO Task_Link(id, task_id, type_id, name, link)
    VALUES (1, 3, 1, 'Wiki to move', 'http://confluence.some_org.com/important_info');
INSERT INTO Task_Link(id, task_id, type_id, name, link)
    VALUES (2, 3, 1, 'Target Wiki', 'http://mediawiki.some_org.com/important_info');