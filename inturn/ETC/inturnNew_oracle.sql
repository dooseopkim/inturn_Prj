/* users */
DROP TABLE users 
	CASCADE CONSTRAINTS;

/* career */
DROP TABLE career 
	CASCADE CONSTRAINTS;

/* job */
DROP TABLE job 
	CASCADE CONSTRAINTS;

/* introduce */
DROP TABLE introduce 
	CASCADE CONSTRAINTS;

/* icon */
DROP TABLE icon 
	CASCADE CONSTRAINTS;

/* dictionary */
DROP TABLE dictionary 
	CASCADE CONSTRAINTS;

/* review */
DROP TABLE review 
	CASCADE CONSTRAINTS;

/* portfolio */
DROP TABLE portfolio 
	CASCADE CONSTRAINTS;

/* reply */
DROP TABLE reply 
	CASCADE CONSTRAINTS;

/* mentorboard */
DROP TABLE mentorboard 
	CASCADE CONSTRAINTS;

/* counselBoard */
DROP TABLE counselBoard 
	CASCADE CONSTRAINTS;

/* educational_level */
DROP TABLE educational_level 
	CASCADE CONSTRAINTS;

/* certificate */
DROP TABLE certificate 
	CASCADE CONSTRAINTS;

/* mentoring */
DROP TABLE mentoring 
	CASCADE CONSTRAINTS;

/* freeBoard */
DROP TABLE freeBoard 
	CASCADE CONSTRAINTS;

/* files */
DROP TABLE files 
	CASCADE CONSTRAINTS;

/* fileGroup */
DROP TABLE fileGroup 
	CASCADE CONSTRAINTS;

/* dic_select */
DROP TABLE dic_select 
	CASCADE CONSTRAINTS;

/* users */
CREATE TABLE users (
	id VARCHAR2(30) NOT NULL, /* id */
	pw VARCHAR2(100) NOT NULL, /* pw */
	name VARCHAR2(20) NOT NULL, /* name */
	phone VARCHAR2(15), /* phone */
	email VARCHAR2(50) NOT NULL, /* email */
	birthday DATE NOT NULL, /* birthday */
	type VARCHAR2(20) NOT NULL, /* type */
	idx NUMBER NOT NULL, /* idx */
	icon_num NUMBER /* icon_num */
);

COMMENT ON TABLE users IS 'users';

COMMENT ON COLUMN users.id IS '아이디';

COMMENT ON COLUMN users.pw IS '비밀번호';

COMMENT ON COLUMN users.name IS '이름';

COMMENT ON COLUMN users.phone IS '연락처';

COMMENT ON COLUMN users.email IS '이메일';

COMMENT ON COLUMN users.birthday IS '생년월일';

COMMENT ON COLUMN users.type IS '타입';

COMMENT ON COLUMN users.idx IS '인덱스';

COMMENT ON COLUMN users.icon_num IS 'icon_num';

CREATE UNIQUE INDEX PK_users
	ON users (
		id ASC
	);

ALTER TABLE users
	ADD
		CONSTRAINT PK_users
		PRIMARY KEY (
			id
		);

/* career */
CREATE TABLE career (
	num NUMBER NOT NULL, /* num */
	company_num VARCHAR2(100), /* company_name */
	dept_name VARCHAR2(50), /* dept_name */
	indate DATE, /* indate */
	outdate DATE, /* outdate */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE career IS 'career';

COMMENT ON COLUMN career.num IS 'PK';

COMMENT ON COLUMN career.company_num IS '회사명';

COMMENT ON COLUMN career.dept_name IS '부서명';

COMMENT ON COLUMN career.indate IS '입사일';

COMMENT ON COLUMN career.outdate IS '퇴사일';

COMMENT ON COLUMN career.id IS '아이디';

CREATE UNIQUE INDEX PK_career
	ON career (
		num ASC
	);

ALTER TABLE career
	ADD
		CONSTRAINT PK_career
		PRIMARY KEY (
			num
		);

/* job */
CREATE TABLE job (
	job_num NUMBER NOT NULL, /* job_num */
	position VARCHAR2(100), /* position */
	kinds VARCHAR2(100), /* kinds */
	duty VARCHAR2(100), /* duty */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE job IS 'job';

COMMENT ON COLUMN job.job_num IS 'job_num';

COMMENT ON COLUMN job.position IS 'position';

COMMENT ON COLUMN job.kinds IS 'kinds';

COMMENT ON COLUMN job.duty IS 'duty';

COMMENT ON COLUMN job.id IS 'id';

CREATE UNIQUE INDEX PK_job
	ON job (
		job_num ASC
	);

ALTER TABLE job
	ADD
		CONSTRAINT PK_job
		PRIMARY KEY (
			job_num
		);

/* introduce */
CREATE TABLE introduce (
	introduce_num NUMBER NOT NULL, /* introduce_num */
	title VARCHAR2(200), /* title */
	content VARCHAR2(1000), /* content */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE introduce IS 'introduce';

COMMENT ON COLUMN introduce.introduce_num IS 'introduce_num';

COMMENT ON COLUMN introduce.title IS 'title';

COMMENT ON COLUMN introduce.content IS 'content';

COMMENT ON COLUMN introduce.id IS 'id';

CREATE UNIQUE INDEX PK_introduce
	ON introduce (
		introduce_num ASC
	);

ALTER TABLE introduce
	ADD
		CONSTRAINT PK_introduce
		PRIMARY KEY (
			introduce_num
		);

/* icon */
CREATE TABLE icon (
	icon_num NUMBER NOT NULL, /* icon_num */
	icon_src VARCHAR2(100) /* icon_src */
);

COMMENT ON TABLE icon IS 'icon';

COMMENT ON COLUMN icon.icon_num IS 'icon_num';

COMMENT ON COLUMN icon.icon_src IS 'icon_src';

CREATE UNIQUE INDEX PK_icon
	ON icon (
		icon_num ASC
	);

ALTER TABLE icon
	ADD
		CONSTRAINT PK_icon
		PRIMARY KEY (
			icon_num
		);

/* dictionary */
CREATE TABLE dictionary (
	dic_num NUMBER NOT NULL, /* dic_num */
	content VARCHAR2(100) /* content */
);

COMMENT ON TABLE dictionary IS 'dictionary';

COMMENT ON COLUMN dictionary.dic_num IS 'dic_num';

COMMENT ON COLUMN dictionary.content IS 'content';

CREATE UNIQUE INDEX PK_dictionary
	ON dictionary (
		dic_num ASC
	);

ALTER TABLE dictionary
	ADD
		CONSTRAINT PK_dictionary
		PRIMARY KEY (
			dic_num
		);

/* review */
CREATE TABLE review (
	review_num NUMBER NOT NULL, /* review_num */
	title VARCHAR2(200), /* title */
	content VARCHAR2(1000), /* content */
	score NUMBER, /* score */
	earn_id VARCHAR2(30), /* earn_id */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE review IS 'review';

COMMENT ON COLUMN review.review_num IS 'review_num';

COMMENT ON COLUMN review.title IS 'title';

COMMENT ON COLUMN review.content IS 'content';

COMMENT ON COLUMN review.score IS 'score';

COMMENT ON COLUMN review.earn_id IS 'earn_id';

COMMENT ON COLUMN review.id IS 'id';

CREATE UNIQUE INDEX PK_review
	ON review (
		review_num ASC
	);

ALTER TABLE review
	ADD
		CONSTRAINT PK_review
		PRIMARY KEY (
			review_num
		);

/* portfolio */
CREATE TABLE portfolio (
	portfolio_num NUMBER NOT NULL, /* portfolio_num */
	fileName VARCHAR2(100), /* fileName */
	fileSize NUMBER, /* fileSize */
	fileHash VARCHAR2(200), /* fileHash */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE portfolio IS 'portfolio';

COMMENT ON COLUMN portfolio.portfolio_num IS 'PK';

COMMENT ON COLUMN portfolio.fileName IS 'fileName';

COMMENT ON COLUMN portfolio.fileSize IS 'fileSize';

COMMENT ON COLUMN portfolio.fileHash IS 'fileHash';

COMMENT ON COLUMN portfolio.id IS 'id';

CREATE UNIQUE INDEX PK_portfolio
	ON portfolio (
		portfolio_num ASC
	);

ALTER TABLE portfolio
	ADD
		CONSTRAINT PK_portfolio
		PRIMARY KEY (
			portfolio_num
		);

/* reply */
CREATE TABLE reply (
	rb_num NUMBER NOT NULL, /* rb_num */
	fb_num NUMBER, /* fb_num */
	cb_num NUMBER, /* cb_num */
	title VARCHAR2(200), /* title */
	content VARCHAR2(1000), /* content */
	regDate DATE, /* regDate */
	parentNum NUMBER, /* parentNum */
	childCount NUMBER, /* childCount */
	position VARCHAR2(30), /* position */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE reply IS 'reply';

COMMENT ON COLUMN reply.rb_num IS 'rb_num';

COMMENT ON COLUMN reply.fb_num IS 'fb_num';

COMMENT ON COLUMN reply.cb_num IS 'cb_num';

COMMENT ON COLUMN reply.title IS 'title';

COMMENT ON COLUMN reply.content IS 'content';

COMMENT ON COLUMN reply.regDate IS 'regDate';

COMMENT ON COLUMN reply.parentNum IS 'parentNum';

COMMENT ON COLUMN reply.childCount IS 'childCount';

COMMENT ON COLUMN reply.position IS 'position';

COMMENT ON COLUMN reply.id IS 'id';

CREATE UNIQUE INDEX PK_reply
	ON reply (
		rb_num ASC
	);

ALTER TABLE reply
	ADD
		CONSTRAINT PK_reply
		PRIMARY KEY (
			rb_num
		);

/* mentorboard */
CREATE TABLE mentorboard (
	mb_num NUMBER NOT NULL, /* mb_num */
	title VARCHAR2(200), /* title */
	content VARCHAR2(1000), /* content */
	regDate DATE, /* regDate */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE mentorboard IS 'mentorboard';

COMMENT ON COLUMN mentorboard.mb_num IS 'PK';

COMMENT ON COLUMN mentorboard.title IS '제목';

COMMENT ON COLUMN mentorboard.content IS '내용';

COMMENT ON COLUMN mentorboard.regDate IS '등록일자';

COMMENT ON COLUMN mentorboard.id IS '아이디';

CREATE UNIQUE INDEX PK_mentorboard
	ON mentorboard (
		mb_num ASC
	);

ALTER TABLE mentorboard
	ADD
		CONSTRAINT PK_mentorboard
		PRIMARY KEY (
			mb_num
		);

/* counselBoard */
CREATE TABLE counselBoard (
	cb_num NUMBER NOT NULL, /* cb_num */
	title VARCHAR2(200), /* title */
	content VARCHAR2(1000), /* content */
	makePublic VARCHAR2(10), /* makePublic */
	regDate DATE, /* regDate */
	hit NUMBER, /* hit */
	id VARCHAR2(30), /* id */
	fileGroupNum NUMBER /* fileGroupNum */
);

COMMENT ON TABLE counselBoard IS 'counselBoard';

COMMENT ON COLUMN counselBoard.cb_num IS 'cb_num';

COMMENT ON COLUMN counselBoard.title IS 'title';

COMMENT ON COLUMN counselBoard.content IS 'content';

COMMENT ON COLUMN counselBoard.makePublic IS 'makePublic';

COMMENT ON COLUMN counselBoard.regDate IS 'regDate';

COMMENT ON COLUMN counselBoard.hit IS 'hit';

COMMENT ON COLUMN counselBoard.id IS 'id';

COMMENT ON COLUMN counselBoard.fileGroupNum IS 'fileGroupNum';

CREATE UNIQUE INDEX PK_counselBoard
	ON counselBoard (
		cb_num ASC
	);

ALTER TABLE counselBoard
	ADD
		CONSTRAINT PK_counselBoard
		PRIMARY KEY (
			cb_num
		);

/* educational_level */
CREATE TABLE educational_level (
	eduLevel_num NUMBER NOT NULL, /* eduLevel_num */
	degree_level VARCHAR2(10), /* degree_level */
	school_name VARCHAR2(50), /* school_name */
	admission_date DATE, /* admission_date */
	graduation_date DATE, /* graduation_date */
	current_status VARCHAR2(50), /* current_status */
	major VARCHAR2(100), /* major */
	avg_score NUMBER(3,2), /* avg_score */
	total_score NUMBER, /* total_score */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE educational_level IS 'educational_level';

COMMENT ON COLUMN educational_level.eduLevel_num IS 'PK';

COMMENT ON COLUMN educational_level.degree_level IS '학업수준';

COMMENT ON COLUMN educational_level.school_name IS '학교명';

COMMENT ON COLUMN educational_level.admission_date IS '입학일';

COMMENT ON COLUMN educational_level.graduation_date IS '졸업일';

COMMENT ON COLUMN educational_level.current_status IS '현재상태';

COMMENT ON COLUMN educational_level.major IS '전공';

COMMENT ON COLUMN educational_level.avg_score IS '평점';

COMMENT ON COLUMN educational_level.total_score IS '총점';

COMMENT ON COLUMN educational_level.id IS '아이디';

CREATE UNIQUE INDEX PK_educational_level
	ON educational_level (
		eduLevel_num ASC
	);

ALTER TABLE educational_level
	ADD
		CONSTRAINT PK_educational_level
		PRIMARY KEY (
			eduLevel_num
		);

/* certificate */
CREATE TABLE certificate (
	certificate_num NUMBER NOT NULL, /* certificate_num */
	certificate_name VARCHAR2(50), /* certificate_name */
	published_by_license VARCHAR2(100), /* published_by_license */
	acquisition_date DATE, /* acquisition_date */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE certificate IS 'certificate';

COMMENT ON COLUMN certificate.certificate_num IS 'certificate_num';

COMMENT ON COLUMN certificate.certificate_name IS 'certificate_name';

COMMENT ON COLUMN certificate.published_by_license IS 'published_by_license';

COMMENT ON COLUMN certificate.acquisition_date IS 'acquisition_date';

COMMENT ON COLUMN certificate.id IS 'id';

CREATE UNIQUE INDEX PK_certificate
	ON certificate (
		certificate_num ASC
	);

ALTER TABLE certificate
	ADD
		CONSTRAINT PK_certificate
		PRIMARY KEY (
			certificate_num
		);

/* mentoring */
CREATE TABLE mentoring (
	mentoring_num NUMBER NOT NULL, /* mentoring_num */
	cb_num NUMBER, /* cb_num */
	mb_num NUMBER, /* mb_num */
	status VARCHAR2(20), /* status */
	content VARCHAR2(1000) /* content */
);

COMMENT ON TABLE mentoring IS 'mentoring';

COMMENT ON COLUMN mentoring.mentoring_num IS 'mentoring_num';

COMMENT ON COLUMN mentoring.cb_num IS 'cb_num';

COMMENT ON COLUMN mentoring.mb_num IS 'mb_num';

COMMENT ON COLUMN mentoring.status IS 'status';

COMMENT ON COLUMN mentoring.content IS 'content';

CREATE UNIQUE INDEX PK_mentoring
	ON mentoring (
		mentoring_num ASC
	);

ALTER TABLE mentoring
	ADD
		CONSTRAINT PK_mentoring
		PRIMARY KEY (
			mentoring_num
		);

/* freeBoard */
CREATE TABLE freeBoard (
	fb_num NUMBER NOT NULL, /* fb_num */
	title VARCHAR2(200), /* title */
	content VARCHAR2(1000), /* content */
	regDate DATE, /* regDate */
	hit NUMBER, /* hit */
	id VARCHAR2(30), /* id */
	fileGroupNum NUMBER /* fileGroupNum */
);

COMMENT ON TABLE freeBoard IS 'freeBoard';

COMMENT ON COLUMN freeBoard.fb_num IS 'fb_num';

COMMENT ON COLUMN freeBoard.title IS 'title';

COMMENT ON COLUMN freeBoard.content IS 'content';

COMMENT ON COLUMN freeBoard.regDate IS 'regDate';

COMMENT ON COLUMN freeBoard.hit IS 'hit';

COMMENT ON COLUMN freeBoard.id IS 'id';

COMMENT ON COLUMN freeBoard.fileGroupNum IS 'fileGroupNum';

CREATE UNIQUE INDEX PK_freeBoard
	ON freeBoard (
		fb_num ASC
	);

ALTER TABLE freeBoard
	ADD
		CONSTRAINT PK_freeBoard
		PRIMARY KEY (
			fb_num
		);

/* files */
CREATE TABLE files (
	fileGroupNum NUMBER NOT NULL, /* fileGroupNum */
	file_num NUMBER NOT NULL, /* file_num */
	original_name VARCHAR2(50), /* original_name */
	fileName VARCHAR2(100), /* fileName */
	fileSize NUMBER, /* fileSize */
	fileHash VARCHAR2(200), /* fileHash */
	fileExtension VARCHAR2(20), /* fileExtension */
	regDate DATE /* regDate */
);

COMMENT ON TABLE files IS 'files';

COMMENT ON COLUMN files.fileGroupNum IS 'fileGroupNum';

COMMENT ON COLUMN files.file_num IS 'file_num';

COMMENT ON COLUMN files.original_name IS 'original_name';

COMMENT ON COLUMN files.fileName IS 'fileName';

COMMENT ON COLUMN files.fileSize IS 'fileSize';

COMMENT ON COLUMN files.fileHash IS 'fileHash';

COMMENT ON COLUMN files.fileExtension IS 'fileExtension';

COMMENT ON COLUMN files.regDate IS 'regDate';

CREATE UNIQUE INDEX PK_files
	ON files (
		fileGroupNum ASC,
		file_num ASC
	);

ALTER TABLE files
	ADD
		CONSTRAINT PK_files
		PRIMARY KEY (
			fileGroupNum,
			file_num
		);

/* fileGroup */
CREATE TABLE fileGroup (
	fileGroupNum NUMBER NOT NULL, /* fileGroupNum */
	fileGroupPath VARCHAR2(200) /* fileGroupPath */
);

COMMENT ON TABLE fileGroup IS 'fileGroup';

COMMENT ON COLUMN fileGroup.fileGroupNum IS 'fileGroupNum';

COMMENT ON COLUMN fileGroup.fileGroupPath IS 'fileGroupPath';

CREATE UNIQUE INDEX PK_fileGroup
	ON fileGroup (
		fileGroupNum ASC
	);

ALTER TABLE fileGroup
	ADD
		CONSTRAINT PK_fileGroup
		PRIMARY KEY (
			fileGroupNum
		);

/* dic_select */
CREATE TABLE dic_select (
	dic_num NUMBER, /* dic_num */
	id VARCHAR2(30) /* id */
);

COMMENT ON TABLE dic_select IS 'dic_select';

COMMENT ON COLUMN dic_select.dic_num IS 'dic_num';

COMMENT ON COLUMN dic_select.id IS 'id';

ALTER TABLE users
	ADD
		CONSTRAINT FK_icon_TO_users
		FOREIGN KEY (
			icon_num
		)
		REFERENCES icon (
			icon_num
		);

ALTER TABLE career
	ADD
		CONSTRAINT FK_users_TO_career
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE job
	ADD
		CONSTRAINT FK_users_TO_job
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE introduce
	ADD
		CONSTRAINT FK_users_TO_introduce
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE review
	ADD
		CONSTRAINT FK_users_TO_review
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE portfolio
	ADD
		CONSTRAINT FK_users_TO_portfolio
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_users_TO_reply
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_freeBoard_TO_reply
		FOREIGN KEY (
			fb_num
		)
		REFERENCES freeBoard (
			fb_num
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_counselBoard_TO_reply
		FOREIGN KEY (
			cb_num
		)
		REFERENCES counselBoard (
			cb_num
		);

ALTER TABLE mentorboard
	ADD
		CONSTRAINT FK_users_TO_mentorboard
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE counselBoard
	ADD
		CONSTRAINT FK_users_TO_counselBoard
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE counselBoard
	ADD
		CONSTRAINT FK_fileGroup_TO_counselBoard
		FOREIGN KEY (
			fileGroupNum
		)
		REFERENCES fileGroup (
			fileGroupNum
		);

ALTER TABLE educational_level
	ADD
		CONSTRAINT FK_users_TO_educational_level
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE certificate
	ADD
		CONSTRAINT FK_users_TO_certificate
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE mentoring
	ADD
		CONSTRAINT FK_counselBoard_TO_mentoring
		FOREIGN KEY (
			cb_num
		)
		REFERENCES counselBoard (
			cb_num
		);

ALTER TABLE mentoring
	ADD
		CONSTRAINT FK_mentorboard_TO_mentoring
		FOREIGN KEY (
			mb_num
		)
		REFERENCES mentorboard (
			mb_num
		);

ALTER TABLE freeBoard
	ADD
		CONSTRAINT FK_users_TO_freeBoard
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);

ALTER TABLE freeBoard
	ADD
		CONSTRAINT FK_fileGroup_TO_freeBoard
		FOREIGN KEY (
			fileGroupNum
		)
		REFERENCES fileGroup (
			fileGroupNum
		);

ALTER TABLE files
	ADD
		CONSTRAINT FK_fileGroup_TO_files
		FOREIGN KEY (
			fileGroupNum
		)
		REFERENCES fileGroup (
			fileGroupNum
		);

ALTER TABLE dic_select
	ADD
		CONSTRAINT FK_dictionary_TO_dic_select
		FOREIGN KEY (
			dic_num
		)
		REFERENCES dictionary (
			dic_num
		);

ALTER TABLE dic_select
	ADD
		CONSTRAINT FK_users_TO_dic_select
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);