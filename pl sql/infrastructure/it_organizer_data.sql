INSERT INTO Project(id, name) VALUES (0,'Main Project');
INSERT INTO Reference_Link(id, project_id, name, link) VALUES (0, 0, 'wiki', 'http://www.confluence.com/VeryImportantProject');
INSERT INTO Reference_Link(id, project_id, name, link) VALUES (1, 0, 'jira', 'http://www.jira.com/VIProj');
INSERT INTO Note(id, project_id, title, note) VALUES (0, 0, 'Environment set up', 'You need to install an plugin.');
INSERT INTO Note(id, project_id, title, note) VALUES (1, 0, 'Deployment', 'Use docker compose');
INSERT INTO Note(id, project_id, title, note) VALUES (2, 0, 'Stand Up', 'You need to prepare a report every morning.');

INSERT INTO Task_Priority(id, name) VALUES (0, 'Urgent and Important');
INSERT INTO Task_Priority(id, name) VALUES (1, 'Not Urgent  but Important');
INSERT INTO Task_Priority(id, name) VALUES (2, 'Urgent but Not Important');
INSERT INTO Task_Priority(id, name) VALUES (3, 'Trash');

select * from Project;