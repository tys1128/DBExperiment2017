# DBExperiment2017

Oracle课程设计

根目录DBExperiment2017为eclipse的workspace


        管理员     教师      学生
账号      admin   02030923  01170512
密码      admin   123456    123456

sqlplus远程连接teacher 
    teacher/teacher@//47.94.200.154:1521/orcl

教师课程查询
    select title,building,room_num,time_slot
    from course natural join section natural join teaches 
    where teaches.id='02030923';


学生课程查询
    select select title,grade,time_slot
    from course natural join section natural join takes 
    where takes.id='01170512';


管理员查询教师
    select *
    from instructor;
