CREATE TABLE Project (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Reference_Link (
    id INTEGER NOT NULL PRIMARY KEY,
    project_id INTEGER NOT NULL,
    name VARCHAR(100) NOT NULL,
    link VARCHAR(100) NOT NULL,
    FOREIGN KEY(project_id) REFERENCES Project(id)
);

CREATE TABLE Note (
    id INTEGER NOT NULL PRIMARY KEY,
    project_id INTEGER NOT NULL,
    title VARCHAR(100) NOT NULL,
    note VARCHAR(100) NOT NULL,
    FOREIGN KEY(project_id) REFERENCES Project(id)
);

CREATE TABLE Task_Priority (
    id INTEGER NOT NULL PRIMARY KEY,
    project_id INTEGER NOT NULL,
    name VARCHAR(100),
    FOREIGN KEY(project_id) REFERENCES Project(id)
);

CREATE TABLE Task_Statuses (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Task (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    project_id INTEGER NOT NULL,
    name VARCHAR(100),
    priority_id INTEGER,
    workspace VARCHAR(100),
    useful_info VARCHAR(100),
    estimation INTEGER,
    due_date TIMESTAMP,
    status_id INTEGER NOT NULL,
    FOREIGN KEY(project_id) REFERENCES Project(id),
    FOREIGN KEY(priority_id) REFERENCES Task_Priority(id),
    FOREIGN KEY(status_id) REFERENCES Task_Statuses(id)
);

CREATE TABLE Task_Link_Type (
    id INTEGER NOT NULL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Task_Link (
    id INTEGER NOT NULL PRIMARY KEY,
    task_id INTEGER NOT NULL,
    type_id INTEGER NOT NULL,
    name VARCHAR(100),
    link VARCHAR(100) NOT NULL,
    FOREIGN KEY(task_id) REFERENCES Task(id),
    FOREIGN KEY(type_id) REFERENCES Task_Link_Type(id)
);

CREATE TABLE Task_Progress (
    id INTEGER NOT NULL PRIMARY KEY,
    task_id INTEGER NOT NULL,
    status_date date,
    status VARCHAR(100) NOT NULL,
    FOREIGN KEY(task_id) REFERENCES Task(id)
);