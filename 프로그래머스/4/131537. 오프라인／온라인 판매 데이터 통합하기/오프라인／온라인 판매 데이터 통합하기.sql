-- 코드를 입력하세요
with shop as (SELECT sales_date, product_id, user_id, sales_amount from online_sale where sales_date like '2022-03%' union all select sales_date, product_id, null as user_id, sales_amount from offline_sale where sales_date like '2022-03%')

select 
    date_format(sales_date, '%Y-%m-%d') sales_date,
    product_id,
    user_id,
    sales_amount
from
    shop
order by
    sales_date,
    product_id,
    user_id;