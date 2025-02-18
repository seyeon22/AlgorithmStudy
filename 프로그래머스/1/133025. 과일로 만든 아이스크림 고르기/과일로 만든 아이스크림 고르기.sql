-- 아이스크림의 맛 조회
-- 상반기 아이스크림의 총 주문량 > 3000 && 주 성분이 과일인 아이스크림 맛
-- 총주문량 큰 순서대로 조회
SELECT f.FLAVOR FROM FIRST_HALF as f JOIN ICECREAM_INFO as i ON f.FLAVOR=i.FLAVOR
WHERE f.TOTAL_ORDER>3000 AND i.INGREDIENT_TYPE='fruit_based'
ORDER BY TOTAL_ORDER desc;