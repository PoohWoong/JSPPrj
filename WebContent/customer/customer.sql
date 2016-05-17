SELECT * FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC)
WHERE ROWNUM BETWEEN 1 AND 10;

SELECT * FROM NOTICE WHERE CODE='123';

SELECT NVL(MAX(TO_NUMBER(CODE)), 0)+1 CODE FROM NOTICE;    /*글번호 최대값 얻어오기 */

INSERT INTO NOTICE VALUE(CODE, '뭔가 있고', '귱귱', '내용', SYSDATE, 0);
SELECT * FROM "COMMENT"
INSERT INTO "COMMENT"(CODE, CONTENT, REGDATE, NOTICE_CODE) VALUES('3', '박대표 밥사줘', SYSDATE, '45')
COMMIT

UPDATE NOTICE SET TITLE,CONTENT WHERE CODE

UPDATE NOTICE SET 

SELECT * FROM NOTICE

SELECT * FROM MEMBER

SELECT N.*, M.AGE FROM NOTICE N INNER JOIN MEMBER M ON N.WRITER=M.MID 

DROP VIEW NOTICE_VIEW157

CREATE VIEW NOTICE_VIEW157
AS
SELECT ROWNUM NUM, NV.* FROM 
(
	SELECT N.CODE, N.TITLE, N.CONTENT, N.WRITER, N.REGDATE, N.HIT, M.NAME AS WRITER_NAME, COUNT(C.CODE) AS CMT_CNT 
	FROM NOTICE N 
		LEFT OUTER JOIN MEMBER M ON N.WRITER=M.MID
		LEFT OUTER JOIN "COMMENT" C ON N.CODE=C.NOTICE_CODE 
	GROUP BY N.CODE, N.TITLE, N. CONTENT, N.WRITER, N.REGDATE, N.HIT, M.NAME
	ORDER BY N.REGDATE  DESC
) NV

SELECT * FROM NOTICE_VIEW157

SELECT * FROM(SELECT ROWNUM NUM, NOTICE_VIEW157.* FROM NOTICE_VIEW157) WHERE NUM BETWEEN 11 AND 20 

SELECT * FROM NOTICE_VIEW157 WHERE NUM BETWEEN 11 AND 20

SELECT REMAINDER(19, 4), REMAINDER(19, 3) FROM DUAL;


SELECT * FROM NOTICE_VIEW WHERE TITLE LIKE '%%' AND ROWNUM BETWEEN 11 AND 20

SELECT * FROM (
	SELECT ROWNUM NUM, NOTICE_VIEW.* FROM NOTICE_VIEW
	WHERE TITLE LIKE '%e%'
	)
WHERE NUM BETWEEN 1 AND 10

SELECT * FROM (SELECT ROWNUM NUM, NOTICE_VIEW.* FROM NOTICE_VIEW)
WHERE CODE='42'