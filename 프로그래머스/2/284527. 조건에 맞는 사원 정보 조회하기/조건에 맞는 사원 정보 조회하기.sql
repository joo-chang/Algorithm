select sum(g.score) score, g.emp_no, e.emp_name, e.position, e.email from hr_employees e right join hr_grade g on e.emp_no = g.emp_no group by 2 order by 1 desc limit 1;