-- ITEM_ID, ITEM_NAME, RARITY 출력
-- 아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템
-- 아이템 ID 기준으로 내림차순 정렬
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT t.ITEM_ID FROM ITEM_TREE AS t JOIN ITEM_INFO AS i ON t.PARENT_ITEM_ID=i.ITEM_ID WHERE PARENT_ITEM_ID IS NOT NULL AND i.RARITY='RARE')
ORDER BY ITEM_ID DESC;
-- 부모 아이템이 NULL이 아니고 부모 아이템의 RARITY='RARE'인 것