-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(*) count
FROM ANIMAL_INS
WHERE ANIMAL_TYPE IN ('CAT', 'DOG')
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;