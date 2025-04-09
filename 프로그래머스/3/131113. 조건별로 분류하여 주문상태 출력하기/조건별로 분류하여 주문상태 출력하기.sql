-- 코드를 입력하세요
SELECT order_id, product_id, date_format(out_date, '%Y-%m-%d') out_date, 
case 
when datediff('2022-05-01', out_date) >= 0 then '출고완료'
when datediff('2022-05-01', out_date) < 0 then '출고대기'
ELSE '출고미정'
END as 출고여부
FROM food_order
order by order_id