-- 코드를 입력하세요
SELECT b.user_id, b.nickname, sum(a.price) total_sales from used_goods_board a inner join used_goods_user b on a.writer_id = b.user_id
where a.status = 'DONE' group by a.writer_id having total_sales >= 700000 order by 3;