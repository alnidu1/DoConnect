select * from question;
insert into question value("May 5", "I need help","https://images.unsplash.com/photo-1503525537183-c84679c9147f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZGVwcmVzcyUyMGVtb2ppfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60","pending", "how to survive", "life", 1,2  );
INSERT INTO question (id, datetime, description_question, image_src, status, title, topic) VALUES (3,"April 2", "How to be better in coding","", "pending", "Skill Seeking", "development");
SELECT * FROM question WHERE description_question LIKE '%I%';
