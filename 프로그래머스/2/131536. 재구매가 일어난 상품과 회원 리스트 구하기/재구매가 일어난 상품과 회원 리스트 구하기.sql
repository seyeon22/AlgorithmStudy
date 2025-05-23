-- 동일한 회원이 동일한 상품 재구매한 데이터 구하기
-- 재구매한 회원 Id, 재구매한 상품 ID 출력
-- 회원 ID 기준으로 오름차순 정렬, 회원 ID 같다면 상품 ID 기준으로 내림차순 정렬
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(PRODUCT_ID)>1
ORDER BY USER_ID, PRODUCT_ID desc;