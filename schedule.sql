-- 테이블 생성 QUERY from ERDCLOUD
CREATE TABLE `schedule` (
	`id`	int(10)	NOT NULL,
	`userid`	int(10)	NOT NULL,
	`title`	varchar(50)	NULL,
	`memo`	varchar(200)	NULL,
	`passwd`	varchar(10)	NOT NULL,
	`regtime`	datetime	NULL,
	`edittime`	datetime	NULL
);

CREATE TABLE `user` (
	`id`	int(10)	NOT NULL,
	`name`	varchar(10)	NOT NULL,
	`email`	varchar(50)	NOT NULL,
	`regtime`	datetime	NULL,
	`edittime`	datetime	NULL
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`id`,
	`userid`
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`id`
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_user_TO_schedule_1` FOREIGN KEY (
	`userid`
)
REFERENCES `user` (
	`id`
);



-- 일정 생성 QUERY
INSERT INTO SCHEDULE (PASSWD, TITLE, MEMO, USERID, REGTIME, EDITTIME)
	       VALUE (:PASSWD, :TITLE, :MEMO, :USERID, SYSDATE(), SYSDATE())


-- 전체 일정 조회 QUERY
SELECT ID, PASSWD, TITLE, MEMO, USERID, REGTIME, EDITTIME
  FROM SCHEDULE
 WHERE DATE(EDITTIME) = :EDITTIME
   AND USERID = :USERID
 ORDER BY EDITTIME DESC


-- 선택 일정 조회 QUERY
SELECT ID, PASSWD, TITLE, MEMO, USERID, REGTIME, EDITTIME
  FROM SCHEDULE
 WHERE ID = :ID


-- 선택 일정 수정 QUERY
UPDATE SCHEDULE
   SET TITLE = :TITLE,
       MEMO = :MEMO,
       USERID = :USERID
       EDITTIME = SYSDATE()
 WHERE USERID = :


-- 선택 일정 삭제 QUERY
DELETE SCHEDULE
 WHERE ID = :ID
