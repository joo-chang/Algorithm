-- 코드를 입력하세요
SELECT floor(price/10000) * 10000 price_group, count(*) products from product group by price_group order by price_group