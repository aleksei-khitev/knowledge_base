INSERT INTO Project(id, name) VALUES (0,'Main Project');
INSERT INTO Reference_Link(id, project_id, name, link) VALUES (0, 0, 'wiki', 'http://www.confluence.com/VeryImportantProject');
INSERT INTO Reference_Link(id, project_id, name, link) VALUES (1, 0, 'jira', 'http://www.jira.com/VIProj');
INSERT INTO Note(id, project_id, title, note) VALUES (0, 0, 'Environment set up', 'You need to install an plugin.');
INSERT INTO Note(id, project_id, title, note) VALUES (1, 0, 'Deployment', 'Use docker compose');
INSERT INTO Note(id, project_id, title, note) VALUES (2, 0, 'Stand Up', 'You need to prepare a report every morning.');

INSERT INTO Task_Priority(id, project_id, name) VALUES (0, 0, 'Urgent and Important');
INSERT INTO Task_Priority(id, project_id, name) VALUES (1, 0, 'Not Urgent  but Important');
INSERT INTO Task_Priority(id, project_id, name) VALUES (2, 0, 'Urgent but Not Important');
INSERT INTO Task_Priority(id, project_id, name) VALUES (3, 0, 'Trash');

INSERT INTO Task_Statuses(id, name) VALUES (0, 'Opened');
INSERT INTO Task_Statuses(id, name) VALUES (1, 'In Progress');
INSERT INTO Task_Statuses(id, name) VALUES (2, 'Blocked');
INSERT INTO Task_Statuses(id, name) VALUES (3, 'Done');

INSERT INTO Task(id, project_id, name, priority_id, useful_info, status_id, estimation)
    VALUES (0, 0, 'Update version number', 2, 'New release is 21.1.1', 3, 2);
INSERT INTO Task(id, project_id, name, priority_id, useful_info, status_id, estimation)
    VALUES (1, 0, 'Configure Docker Compose for local environment', 1, 'Dockerfiles can be found in configs', 0, 4);
INSERT INTO Task(id, project_id, name, priority_id, useful_info, status_id, estimation)
    VALUES (2, 0, 'Investigate memory issue', 0, 'Logs and dump were attached', 1, 8);


select * from Project;