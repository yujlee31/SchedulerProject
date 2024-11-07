# SchedulerProject

## API 명세서
|기능|method|url|request|response|status|
|----|---|---|---|---|---|
|신규일정 생성|`POST`  |/api/schedules              |요청 body  |등록 정보      |201: 정상 등록|
|전체일정 조회|`GET`   |/api/schedules              |요청 param |다건 응답 정보  |200: 정상 조회|
|선택일정 조회|`GET`   |/api/schedules/{schedule_id}|요청 param |단건 응답 정보  |200: 정상 조회|
|선택일정 수정|`PATCH` |/api/schedules/{schedule_id}|요청 body  |수정 정보      |200: 정상 수정|
|선택일정 삭제|`DELETE`|/api/schedules/{schedule_id}|요청 param |삭제 정보      |204: 정상 삭제|

<details>
  <summary>신규일정 생성</summary>
<table>
<tr>
<td>  </td> <td> Request </td> <td> Response </td>
</tr>
<tr>
<td> Start Line </td>
<td> POST  /api/schedules  HTTP/1.1</td>
<td> HTTP/1.1  201  Created </td>
</tr>
<tr>
<td> Header </td>
<td>Content-Type:application/json</td>
<td>Content-Type:application/json</td>
</tr>
<tr>
<td> Empty Line </td>
<td></td>
<td></td>
</tr>
<tr>
<td> Message Body</td>
<td>

```json
{
	"title" : "제목",
	"content" : "내용",
	"passwd" : "비밀번호",
	"userid" : "작성자"
	}
```
 
</td>
<td>

```json
{
	"id" : "번호",
	"title" : "제목",
	"content" : "내용",
	"passwd" : "비밀번호",
	"userid" : "작성자",
	"regtime" : "생성일시",
	"edittime" : "수정일시"
	}
```
 
</td>
</tr>
</table>
</details>


<details>
  <summary>전체일정 조회</summary>
<table>
<tr>
<td>  </td> <td> Request </td> <td> Response </td>
</tr>
<tr>
<td> Start Line </td>
<td> GET  /api/schedules  HTTP/1.1</td>
<td> HTTP/1.1  200  OK </td>
</tr>
<tr>
<td> Header </td>
<td>Host:localhost:8080</td>
<td>Content-Type:application/json</td>
</tr>
<tr>
<td> Empty Line </td>
<td></td>
<td></td>
</tr>
<tr>
<td> Message Body</td>
<td>
 
</td>
<td>

```json
{
	"id" : "번호",
	"title" : "제목",
	"content" : "내용",
	"passwd" : "비밀번호",
	"userid" : "작성자",
	"regtime" : "생성일시",
	"edittime" : "수정일시"
	}
```
 
</td>
</tr>
</table>
</details>


<details>
  <summary>선택일정 조회</summary>
<table>
<tr>
<td>  </td> <td> Request </td> <td> Response </td>
</tr>
<tr>
<td> Start Line </td>
<td> GET  /api/schedules?id={id}  HTTP/1.1</td>
<td> HTTP/1.1  200  OK </td>
</tr>
<tr>
<td> Header </td>
<td>Host:localhost:8080</td>
<td>Content-Type:application/json</td>
</tr>
<tr>
<td> Empty Line </td>
<td></td>
<td></td>
</tr>
<tr>
<td> Message Body</td>
<td>
 
</td>
<td>

```json
{
	"id" : "번호",
	"title" : "제목",
	"content" : "내용",
	"passwd" : "비밀번호",
	"userid" : "작성자",
	"regtime" : "생성일시",
	"edittime" : "수정일시"
	}
```
 
</td>
</tr>
</table>
</details>


<details>
  <summary>선택일정 수정</summary>
<table>
<tr>
<td>  </td> <td> Request </td> <td> Response </td>
</tr>
<tr>
<td> Start Line </td>
<td> PATCH  /api/schedules?id={id}  HTTP/1.1</td>
<td> HTTP/1.1  200  OK </td>
</tr>
<tr>
<td> Header </td>
<td>Content-Type:application/json</td>
<td>Content-Type:application/json</td>
</tr>
<tr>
<td> Empty Line </td>
<td></td>
<td></td>
</tr>
<tr>
<td> Message Body</td>
<td>

```json
{
	"title" : "제목",
	"content" : "내용",
	"userid" : "작성자"
	}
```
 
</td>
<td>

```json
{
	"id" : "번호",
	"title" : "제목",
	"content" : "내용",
	"passwd" : "비밀번호",
	"userid" : "작성자",
	"regtime" : "생성일시",
	"edittime" : "수정일시"
	}
```
 
</td>
</tr>
</table>
</details>


<details>
  <summary>선택일정 삭제</summary>
<table>
<tr>
<td>  </td> <td> Request </td> <td> Response </td>
</tr>
<tr>
<td> Start Line </td>
<td> DELETE  /api/schedules?id={id}  HTTP/1.1</td>
<td> HTTP/1.1  200  OK </td>
</tr>
<tr>
<td> Header </td>
<td>Host: localhost:8080</td>
<td></td>
</tr>
<tr>
<td> Empty Line </td>
<td></td>
<td></td>
</tr>
<tr>
<td> Message Body</td>
<td></td>
<td></td>
</tr>
</table>
</details>

---
## ERD
![ERD](erd_SchedulerProject.png)
https://www.erdcloud.com/d/sJoeoXvDutmdC4neW


---
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
-->
use schedule;

# CREATE TABLE memo
# (
#     id       BIGINT       AUTO_INCREMENT PRIMARY KEY COMMENT '메모 식별자',
#     title    VARCHAR(100) NOT NULL COMMENT '제목',
#     contents TEXT COMMENT '내용'
# );

CREATE TABLE schedule
(
    id       BIGINT AUTO_INCREMENT primary key comment '일정 식별자',
    title    varchar(100) NOT NULL COMMENT '제목',
    content  TEXT COMMENT '내용',
    user_id  bigint not null comment '작성자',
    passwd   varchar(50)  NOT NULL COMMENT '작성글 비밀번호',
    regtime  datetime comment '등록일시',
    edittime datetime comment '수정일시'
);

CREATE TABLE user
(
    user_id     bigint  primary key comment '유저 식별자',
    name        varchar(50) not null comment '이름',
    email       varchar(100) not null comment '이메일',
    regtime  datetime comment '등록일시',
    edittime datetime comment '수정일시'
);

ALTER TABLE `schedule` ADD CONSTRAINT `FK_user_TO_schedule_1` FOREIGN KEY (
                                                                           `user_id`
    )
    REFERENCES `user` (
                       `user_id`
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
