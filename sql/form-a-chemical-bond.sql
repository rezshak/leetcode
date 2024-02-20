-- https://leetcode.com/problems/form-a-chemical-bond/

select
    e1.symbol as Metal, 
    e2.symbol as Nonmetal
from 
    Elements e1
join 
    Elements e2
where 
    e1.type = 'Metal' and e2.type = 'Nonmetal';
