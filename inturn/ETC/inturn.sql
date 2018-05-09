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
		duty                          		VARCHAR2(100)		 NOT NULL
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
		job_num                       		NUMBER		 NULL ,
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
		content                       		VARCHAR2(1000)		 NOT NULL,
		id                            		VARCHAR2(20)		 NULL 
);

ALTER TABLE users ADD CONSTRAINT IDX_users_PK PRIMARY KEY (id);

ALTER TABLE job ADD CONSTRAINT IDX_job_PK PRIMARY KEY (job_num);

ALTER TABLE career ADD CONSTRAINT IDX_career_PK PRIMARY KEY (num);
ALTER TABLE career ADD CONSTRAINT IDX_career_FK0 FOREIGN KEY (id) REFERENCES users (id);
ALTER TABLE career ADD CONSTRAINT IDX_career_FK1 FOREIGN KEY (job_num) REFERENCES job (job_num);

ALTER TABLE educational_level ADD CONSTRAINT IDX_educational_level_PK PRIMARY KEY (num);
ALTER TABLE educational_level ADD CONSTRAINT IDX_educational_level_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE certificate ADD CONSTRAINT IDX_certificate_PK PRIMARY KEY (num);
ALTER TABLE certificate ADD CONSTRAINT IDX_certificate_FK0 FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE introduce ADD CONSTRAINT IDX_introduce_PK PRIMARY KEY (num);
ALTER TABLE introduce ADD CONSTRAINT IDX_introduce_FK0 FOREIGN KEY (id) REFERENCES users (id);

