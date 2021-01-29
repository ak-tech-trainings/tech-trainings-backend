-- insert the student
insert into student(student_id, first_name, last_name, email, phone) values
  (1,'elon', 'musk', 'elonmusk@domain.com', '123456789'),
  (2,'jeff', 'bezos', 'jeffbezos@domain.com', '123456789');

-- insert the faculty
insert into faculty(faculty_id, first_name, last_name, email, phone) values
  (1,'elon', 'musk', 'elonmusk@domain.com', '123456789'),
  (2,'jeff', 'bezos', 'jeffbezos@domain.com', '123456789');

-- insert the course
insert into course(course_id, name, description, duration, fee) values
  (1,'java', 'description', 12, 20),
  (2,'.net', 'description', 12, 20),
  (3,'python', 'description', 10, 50),
  (4,'ruby', 'description', 10, 40),
  (5,'javascript', 'description', 10, 50);

-- insert the curriculum_details
insert into curriculum_details(course_id, curriculum) values
(1, 'oops'),
(1, 'Generics'),
(2, 'oops'),
(2, 'Exceptions');

-- insert student_course
insert into student_course(student_id, course_id) values
  (1, 1),
  (2, 2);

-- insert faculty_course
insert into faculty_course(faculty_id, course_id) values
  (1, 1),
  (2, 2);

-- insert address
insert into address(id, address_line1, address_line2, city, state, country, pin) values
(1, 'addressLine1', 'addressLine2', 'city', 'state', 'country', 'pin'),
(2, 'addressLine1', 'addressLine2', 'city', 'state', 'country', 'pin');

-- update student with address
update student set address_id=1 where student_id=1;
update student set address_id=1 where student_id=2;

-- update faculty with address
update faculty set address_id=2 where faculty_id=1;
update faculty set address_id=2 where faculty_id=2;


-- security data
insert into user(id, username, password, roles, enabled) values
(1, 'user', 'user', 'ROLE_USER', true),
(2, 'admin', 'admin', 'ROLE_ADMIN', true);