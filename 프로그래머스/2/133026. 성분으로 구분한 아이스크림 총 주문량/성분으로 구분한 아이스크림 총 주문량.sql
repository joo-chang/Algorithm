-- 코드를 입력하세요
select i.ingredient_type, SUM(total_order) TOTAL_ORDER from first_half f INNER JOIN icecream_info i ON f.flavor = i.flavor group by i.ingredient_type;