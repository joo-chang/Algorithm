-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, DATE_FORMAT(b.PUBLISHED_DATE , '%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK b LEFT JOIN AUTHOR a ON a.AUTHOR_ID = b.AUTHOR_ID
WHERE b.CATEGORY = "경제" ORDER BY b.PUBLISHED_DATE;