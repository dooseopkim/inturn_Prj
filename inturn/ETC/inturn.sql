drop user inturn cascade;

create user inturn identified by 1234;
grant dba to inturn;
conn inturn/1234;

drop table users;
drop table job;
drop table career;
drop table educational_level;
drop table certificate;
drop table introduce;
drop table mentorBoard;
drop table review;
drop table counselStatus;
drop table counselBoard;
drop table replyBoard;
drop table csBoard;
drop table freeBoard;
drop table fileGroup;
drop table files;

/**********************************/
/* Table Name: users */
/**********************************/
CREATE TABLE users(
		id                            		VARCHAR2(20)		 NULL ,
		pw                            		VARCHAR2(100)		 NOT NULL,
		name                          		VARCHAR2(20)		 NOT NULL,
		phone                         		VARCHAR2(15)		 NOT NULL,
		birthday                      		DATE		 NOT NULL,
		type                          		VARCHAR2(20)		 NOT NULL
);

/**********************************/
/* Table Name: job */
/**********************************/
CREATE TABLE job(
		job_num                       		NUMBER		 NULL ,
		position                      		VARCHAR2(30)		 NOT NULL,
		kinds                         		VARCHAR2(30)		 NOT NULL,
		duty                          		VARCHAR2(100)		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL
);

/**********************************/
/* Table Name: career */
/**********************************/
CREATE TABLE career(
		num                           		NUMBER		 NULL ,
		company_name                  		VARCHAR2(30)		 NULL ,
		department_name               		VARCHAR2(50)		 NULL ,
		join_date                     		DATE		 NULL ,
		retirement_date               		DATE		 NULL ,
		id                            		VARCHAR2(20)		 NULL 
);

/**********************************/
/* Table Name: educational_level */
/**********************************/
CREATE TABLE educational_level(
		num                           		NUMBER		 NULL ,
		degree_level                  		VARCHAR2(30)		 NULL ,
		school_name                   		VARCHAR2(30)		 NULL ,
		admission_date                		DATE		 NULL ,
		graduation_date               		DATE		 NULL ,
		current_status                		VARCHAR2(30)		 NULL ,
		major                         		VARCHAR2(30)		 NULL ,
		avg_credit                    		DOUBLE PRECISION		 NULL ,
		total_credit                  		DOUBLE PRECISION		 NULL ,
		id                            		VARCHAR2(20)		 NULL 
);

/**********************************/
/* Table Name: certificate */
/**********************************/
CREATE TABLE certificate(
		num                           		NUMBER		 NULL ,
		certificate_name              		VARCHAR2(100)		 NULL ,
		published_by_license          		VARCHAR2(100)		 NULL ,
		Acquisition_date              		DATE		 NULL ,
		id                            		VARCHAR2(20)		 NULL 
);

/**********************************/
/* Table Name: introduce */
/**********************************/
CREATE TABLE introduce(
		num                           		NUMBER		 NULL ,
		title                         		VARCHAR2(200)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL 
);

/**********************************/
/* Table Name: mentorBoard */
/**********************************/
CREATE TABLE mentorBoard(
		num                           		NUMBER		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		dicNum                        		NUMBER		 NOT NULL,
		regDate                       		DATE		 NOT NULL
);

/**********************************/
/* Table Name: review */
/**********************************/
CREATE TABLE review(
		num                           		NUMBER		 NOT NULL,
		dicNum                        		NUMBER		 NOT NULL,
		id                            		VARCHAR2(20)		 NOT NULL,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		score                         		DOUBLE PRECISION		 NOT NULL,
		earn_id                       		VARCHAR2(40)		 NOT NULL
);

/**********************************/
/* Table Name: counselStatus */
/**********************************/
CREATE TABLE counselStatus(
		counselNum                    		NUMBER		 NOT NULL,
		mentee_id                     		VARCHAR2(20)		 NOT NULL,
		mentor_id                     		VARCHAR2(20)		 NOT NULL,
		status                        		VARCHAR2(10)		 NOT NULL
);


/**********************************/
/* Table Name: counselBoard */
/**********************************/
CREATE TABLE counselBoard(
		num                           		NUMBER		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		makePublic                    		VARCHAR(3)		 NOT NULL,
		dicNum                        		NUMBER		 NULL ,
		counselNum                    		NUMBER		 NOT NULL,
		regDate                       		DATE		 NOT NULL
);

/**********************************/
/* Table Name: replyBoard */
/**********************************/
CREATE TABLE replyBoard(
		num                           		NUMBER		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		regDate                       		DATE		 NOT NULL,
		parentNum                     		NUMBER		 NOT NULL,
		childCount                    		NUMBER		 NOT NULL,
		position                      		VARCHAR2(30)		 NOT NULL,
		freeBoardNum                  		NUMBER		 NOT NULL
);

/**********************************/
/* Table Name: csBoard */
/**********************************/
CREATE TABLE csBoard(
		csBoardNum                    		NUMBER		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		regDate                       		DATE		 NOT NULL,
		count                         		NUMBER		 NOT NULL,
		secret                        		VARCHAR2(3)		 NOT NULL,
		parentNum                     		VARCHAR2(10)		 NOT NULL,
		childCount                    		NUMBER		 NOT NULL,
		position                      		NUMBER		 NOT NULL
);

/**********************************/
/* Table Name: freeBoard */
/**********************************/
CREATE TABLE freeBoard(
		freeBoardNum                  		NUMBER		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL, 
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(4000)		 NOT NULL,
		regDate                       		DATE		 NOT NULL,
		count                         		NUMBER		 NOT NULL
);

/**********************************/
/* Table Name: fileGroup */
/**********************************/
CREATE TABLE fileGroup(
		fileGroupNum                  		NUMBER		 NOT NULL,
		freeBoardNum                  		NUMBER		 NULL ,
		csBoardNum                    		NUMBER		 NULL 
);

/**********************************/
/* Table Name: files */
/**********************************/
CREATE TABLE files(
		fileNum                       		NUMBER		 NOT NULL,
		fileName                      		VARCHAR2(100)		 NOT NULL,
		fileSize                      		NUMBER		 NOT NULL,
		fileHash                      		VARCHAR2(4000)		 NOT NULL,
		fileGroupNum                  		NUMBER		 NOT NULL
);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (id);

ALTER TABLE job ADD CONSTRAINT IDX_job_PK PRIMARY KEY (job_num);
ALTER TABLE job ADD CONSTRAINT IDX_job_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE career ADD CONSTRAINT IDX_career_PK PRIMARY KEY (num);
ALTER TABLE career ADD CONSTRAINT IDX_career_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE educational_level ADD CONSTRAINT IDX_educational_level_PK PRIMARY KEY (num);
ALTER TABLE educational_level ADD CONSTRAINT IDX_educational_level_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE certificate ADD CONSTRAINT IDX_certificate_PK PRIMARY KEY (num);
ALTER TABLE certificate ADD CONSTRAINT IDX_certificate_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE introduce ADD CONSTRAINT IDX_introduce_PK PRIMARY KEY (num);
ALTER TABLE introduce ADD CONSTRAINT IDX_introduce_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE mentorBoard ADD CONSTRAINT IDX_mentorBoard_PK PRIMARY KEY (num);
ALTER TABLE mentorBoard ADD CONSTRAINT IDX_mentorBoard_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE review ADD CONSTRAINT IDX_review_PK PRIMARY KEY (num);
ALTER TABLE review ADD CONSTRAINT IDX_review_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE counselStatus ADD CONSTRAINT IDX_counselStatus_PK PRIMARY KEY (counselNum);

ALTER TABLE counselBoard ADD CONSTRAINT IDX_counselBoard_PK PRIMARY KEY (num);
ALTER TABLE counselBoard ADD CONSTRAINT IDX_counselBoard_FK0 FOREIGN KEY (counselNum) REFERENCES counselStatus (counselNum);
ALTER TABLE counselBoard ADD CONSTRAINT IDX_counselBoard_FK1 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE freeBoard ADD CONSTRAINT IDX_freeBoard_PK PRIMARY KEY (freeBoardNum);
ALTER TABLE freeBoard ADD CONSTRAINT IDX_freeBoard_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE csBoard ADD CONSTRAINT IDX_csBoard_PK PRIMARY KEY (csBoardNum);
ALTER TABLE csBoard ADD CONSTRAINT IDX_csBoard_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE replyBoard ADD CONSTRAINT IDX_replyBoard_PK PRIMARY KEY (num);
ALTER TABLE replyBoard ADD CONSTRAINT IDX_replyBoard_FK0 FOREIGN KEY (freeBoardNum) REFERENCES freeBoard (freeBoardNum);
ALTER TABLE replyBoard ADD CONSTRAINT IDX_replyBoard_FK1 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE fileGroup ADD CONSTRAINT IDX_fileGroup_PK PRIMARY KEY (fileGroupNum);
ALTER TABLE fileGroup ADD CONSTRAINT IDX_fileGroup_FK0 FOREIGN KEY (csBoardNum) REFERENCES csBoard (csBoardNum);
ALTER TABLE fileGroup ADD CONSTRAINT IDX_fileGroup_FK1 FOREIGN KEY (freeBoardNum) REFERENCES freeBoard (freeBoardNum);

ALTER TABLE files ADD CONSTRAINT IDX_files_PK PRIMARY KEY (fileNum);
ALTER TABLE files ADD CONSTRAINT IDX_files_FK0 FOREIGN KEY (fileGroupNum) REFERENCES fileGroup (fileGroupNum);

