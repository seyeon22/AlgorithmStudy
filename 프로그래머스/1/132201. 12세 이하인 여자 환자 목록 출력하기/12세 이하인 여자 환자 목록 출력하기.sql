-- 환자이름, 환자번호, 성별코드, 나이, 전화번호 조회
-- 전화번호 없는 경우 'NONE'으로 출력으로 출력
-- 12세 이하인 여자환자
-- 나이 기준으로 내림차순 정렬, 나이 같다면 환자 이름 기준으로 오름차순 정렬
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') as TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD='W'
ORDER BY AGE DESC, PT_NAME;