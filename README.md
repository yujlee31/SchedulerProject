# SchedulerProject

## API 명세서
|기능|method|url|request|response|status|
|----|---|---|---|---|---|
|신규일정 생성|`POST`  |/api/schedules              |요청 body  |등록 정보      |200: 정상 등록, 400: 비정상 값|
|전체일정 조회|`GET`   |/api/schedules              |요청 param |다건 응답 정보  |200: 정상 조회|
|선택일정 조회|`GET`   |/api/schedules/{schedule_id}|요청 param |단건 응답 정보  |200: 정상 조회, 404: 일정이 사라짐|
|선택일정 수정|`PUT`   |/api/schedules/{schedule_id}|요청 body  |수정 정보      |200: 정상 수정, 400: 비정상 값, 404: 일정이 사라짐|
|선택일정 삭제|`DELETE`|/api/schedules/{schedule_id}|요청 param |삭제 정보      |200: 정상 삭제, 404: 일정이 사라짐|


## ERD
https://www.erdcloud.com/d/sJoeoXvDutmdC4neW


## SQL
```sql
-- 테이블 생성 QUERY from ERDCLOUD
CREATE TABLE `schedule` (
	`id`	int(10)	NOT NULL,
	`userid`	int(10)	NOT NULL,
	`title`	varchar(50)	NULL,
	`content`	varchar(200)	NULL,
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
INSERT INTO SCHEDULE (PASSWD, TITLE, CONTENT, USERID, REGTIME, EDITTIME)
	       VALUE (:PASSWD, :TITLE, :CONTENT, :USERID, SYSDATE(), SYSDATE())


-- 전체 일정 조회 QUERY
SELECT ID, PASSWD, TITLE, CONTENT, USERID, REGTIME, EDITTIME
  FROM SCHEDULE
 WHERE DATE(EDITTIME) = :EDITTIME
   AND USERID = :USERID
 ORDER BY EDITTIME DESC


-- 선택 일정 조회 QUERY
SELECT ID, PASSWD, TITLE, CONTENT, USERID, REGTIME, EDITTIME
  FROM SCHEDULE
 WHERE ID = :ID


-- 선택 일정 수정 QUERY
UPDATE SCHEDULE
   SET TITLE = :TITLE,
       CONTENT = :CONTENT,
       USERID = :USERID,
       EDITTIME = SYSDATE()
 WHERE ID = :ID


-- 선택 일정 삭제 QUERY
DELETE SCHEDULE
 WHERE ID = :ID
```
