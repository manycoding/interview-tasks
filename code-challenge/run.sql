\x
SELECT DISTINCT ON (department)
	id, name, department, salary
FROM employee
ORDER BY department, salary DESC, id
;
-- \x
-- SELECT COUNT(DISTINCT department)
-- 	department
-- FROM employee
-- ;
-- \x
-- SELECT MAX(DISTINCT salary)
-- FROM employee
-- ;
