Select * from instructor left join instructor_detail on instructor.id = instructor_detail.id;

select * from instructor_detail

truncate instructor_detail restart identity CASCADE;

select * from instructor
join course on instructor.id = course.instructor_id
join instructor_detail on instructor.id = instructor_detail.id