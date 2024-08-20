/*ユーザーマスタ*/
CREATE TABLE IF NOT EXISTS users_table(
	userId CHAR(10) PRIMARY KEY,
	password VARCHAR(30),
	userName VARCHAR(30),
	email VARCHAR(30),
	birthday DATE,
	gender INT,
	createdAt DATETIME,
	updatedAt DATETIME,
	isDeleted TINYINT
);

/*タスク登録マスタ*/
CREATE TABLE IF NOT EXISTS tasks_table(
	taskId CHAR(10) PRIMARY KEY,
	userId CHAR(10),
	title VARCHAR(100),
	description TEXT,
	startDate DATE,
	deadline DATE,
	priority INT,
	status INT,
	createdAt DATETIME,
	updatedAt DATETIME,
	isDeleted TINYINT,
	FOREIGN KEY (userId) REFERENCES users_table(userId)
);

