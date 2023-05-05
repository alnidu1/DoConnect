#table structure

INSERT INTO answer (description_answer, img_src, status, datetime, question_id, aapproved_id, acreated_id)
VALUES ('[description_answer_value]', '[img_src_value]', '[status_value]', '[datetime_value]', [question_id_value], [aapproved_id_value], [acreated_id_value]);
INSERT INTO user (name, username, password, email, userType) VALUES ('John Doe', 'johndoe', 'password', 'johndoe@example.com', 'regular');


select * from question;
insert into question value("May 5", "I need help","https://images.unsplash.com/photo-1503525537183-c84679c9147f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZGVwcmVzcyUyMGVtb2ppfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60","pending", "how to survive", "life", 1,2  );
INSERT INTO question (id, datetime, description_question, image_src, status, title, topic) VALUES (3,"April 2", "How to be better in coding","", "pending", "Skill Seeking", "development");
SELECT * FROM question WHERE description_question LIKE '%I%';
SELECT * FROM question WHERE description_question LIKE %:keyword%