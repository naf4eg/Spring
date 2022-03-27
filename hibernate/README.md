Select * from instructor left join instructor_detail on instructor.id = instructor_detail.id;

select * from instructor_detail

truncate instructor_detail restart identity CASCADE;