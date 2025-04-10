-- 코드를 입력하세요
SELECT b.category CATEGORY, sum(sales) TOTAL_SALES
FROM BOOK b
 JOIN BOOK_SALES bs
ON b.book_id = bs.book_id
where year(bs.sales_date) = '2022'
and month(bs.sales_date) = '01'
GROUP BY b.category
order by 1