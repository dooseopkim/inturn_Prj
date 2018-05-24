SET foreign_key_checks = 0;

-- users
DROP TABLE IF EXISTS users;

-- career
DROP TABLE IF EXISTS career;

-- job
DROP TABLE IF EXISTS job;

-- introduce
DROP TABLE IF EXISTS introduce;

-- icon
DROP TABLE IF EXISTS icon;

-- dictionary
DROP TABLE IF EXISTS dictionary;

-- review
DROP TABLE IF EXISTS review;

-- portfolio
DROP TABLE IF EXISTS portfolio;

-- reply
DROP TABLE IF EXISTS reply;

-- mentorboard
DROP TABLE IF EXISTS mentorboard;

-- counselBoard
DROP TABLE IF EXISTS counselBoard;

-- educational_level
DROP TABLE IF EXISTS educational_level;

-- certificate
DROP TABLE IF EXISTS certificate;

-- mentoring
DROP TABLE IF EXISTS mentoring;

-- freeBoard
DROP TABLE IF EXISTS freeBoard;

-- files
DROP TABLE IF EXISTS files;

-- fileGroup
DROP TABLE IF EXISTS fileGroup;

-- replyGroup
DROP TABLE IF EXISTS TABLE18;

-- dic_select
DROP TABLE IF EXISTS dic_select;

SET foreign_key_checks = 1;
-- users
CREATE TABLE users (
	id       VARCHAR(30)  NOT NULL COMMENT '아이디', -- id
	pw       VARCHAR(100) NOT NULL COMMENT '비밀번호', -- pw
	name     VARCHAR(20)  NOT NULL COMMENT '이름', -- name
	phone    VARCHAR(15)  NULL     COMMENT '연락처', -- phone
	email    VARCHAR(50)  NOT NULL COMMENT '이메일', -- email
	birthday DATE         NOT NULL COMMENT '생년월일', -- birthday
	type     VARCHAR(20)  NOT NULL COMMENT '타입', -- type
	idx      INT          NOT NULL COMMENT '인덱스', -- idx
	icon_num INT          NULL     COMMENT 'icon_num' -- icon_num
)
COMMENT 'users';

-- users
ALTER TABLE users
	ADD CONSTRAINT PK_users -- users 기본키
		PRIMARY KEY (
			id -- id
		);

-- career
CREATE TABLE career (
	num         INT          NOT NULL COMMENT 'PK', -- num
	company_num VARCHAR(100) NULL     COMMENT '회사명', -- company_name
	dept_name   VARCHAR(50)  NULL     COMMENT '부서명', -- dept_name
	indate      DATE         NULL     COMMENT '입사일', -- indate
	outdate     DATE         NULL     COMMENT '퇴사일', -- outdate
	id          VARCHAR(30)  NULL     COMMENT '아이디' -- id
)
COMMENT 'career';

-- career
ALTER TABLE career
	ADD CONSTRAINT PK_career -- career 기본키
		PRIMARY KEY (
			num -- num
		);

-- job
CREATE TABLE job (
	job_num  INT          NOT NULL COMMENT 'job_num', -- job_num
	position VARCHAR(100) NULL     COMMENT 'position', -- position
	kinds    VARCHAR(100) NULL     COMMENT 'kinds', -- kinds
	duty     VARCHAR(100) NULL     COMMENT 'duty', -- duty
	id       VARCHAR(30)  NULL     COMMENT 'id' -- id
)
COMMENT 'job';

-- job
ALTER TABLE job
	ADD CONSTRAINT PK_job -- job 기본키
		PRIMARY KEY (
			job_num -- job_num
		);

-- introduce
CREATE TABLE introduce (
	introduce_num INT           NOT NULL COMMENT 'introduce_num', -- introduce_num
	title         VARCHAR(200)  NULL     COMMENT 'title', -- title
	content       VARCHAR(1000) NULL     COMMENT 'content', -- content
	id            VARCHAR(30)   NULL     COMMENT 'id' -- id
)
COMMENT 'introduce';

-- introduce
ALTER TABLE introduce
	ADD CONSTRAINT PK_introduce -- introduce 기본키
		PRIMARY KEY (
			introduce_num -- introduce_num
		);

-- icon
CREATE TABLE icon (
	icon_num INT          NOT NULL COMMENT 'icon_num', -- icon_num
	icon_src VARCHAR(100) NULL     COMMENT 'icon_src' -- icon_src
)
COMMENT 'icon';

-- icon
ALTER TABLE icon
	ADD CONSTRAINT PK_icon -- icon 기본키
		PRIMARY KEY (
			icon_num -- icon_num
		);

-- dictionary
CREATE TABLE dictionary (
	dic_num INT          NOT NULL COMMENT 'dic_num', -- dic_num
	content VARCHAR(100) NULL     COMMENT 'content' -- content
)
COMMENT 'dictionary';

-- dictionary
ALTER TABLE dictionary
	ADD CONSTRAINT PK_dictionary -- dictionary 기본키
		PRIMARY KEY (
			dic_num -- dic_num
		);

-- review
CREATE TABLE review (
	review_num INT           NOT NULL COMMENT 'review_num', -- review_num
	title      VARCHAR(200)  NULL     COMMENT 'title', -- title
	content    VARCHAR(1000) NULL     COMMENT 'content', -- content
	score      INT           NULL     COMMENT 'score', -- score
	earn_id    VARCHAR(30)   NULL     COMMENT 'earn_id', -- earn_id
	id         VARCHAR(30)   NULL     COMMENT 'id' -- id
)
COMMENT 'review';

-- review
ALTER TABLE review
	ADD CONSTRAINT PK_review -- review 기본키
		PRIMARY KEY (
			review_num -- review_num
		);

-- portfolio
CREATE TABLE portfolio (
	portfolio_num INT          NOT NULL COMMENT 'PK', -- portfolio_num
	fileName      VARCHAR(100) NULL     COMMENT 'fileName', -- fileName
	fileSize      INT          NULL     COMMENT 'fileSize', -- fileSize
	fileHash      VARCHAR(200) NULL     COMMENT 'fileHash', -- fileHash
	id            VARCHAR(30)  NULL     COMMENT 'id' -- id
)
COMMENT 'portfolio';

-- portfolio
ALTER TABLE portfolio
	ADD CONSTRAINT PK_portfolio -- portfolio 기본키
		PRIMARY KEY (
			portfolio_num -- portfolio_num
		);

-- reply
CREATE TABLE reply (
	rb_num     INT           NOT NULL COMMENT 'rb_num', -- rb_num
	fb_num     INT           NULL     COMMENT 'fb_num', -- fb_num
	cb_num     INT           NULL     COMMENT 'cb_num', -- cb_num
	title      VARCHAR(200)  NULL     COMMENT 'title', -- title
	content    VARCHAR(1000) NULL     COMMENT 'content', -- content
	regDate    DATE          NULL     COMMENT 'regDate', -- regDate
	parentNum  INT           NULL     COMMENT 'parentNum', -- parentNum
	childCount INT           NULL     COMMENT 'childCount', -- childCount
	position   VARCHAR(30)   NULL     COMMENT 'position', -- position
	id         VARCHAR(30)   NULL     COMMENT 'id' -- id
)
COMMENT 'reply';

-- reply
ALTER TABLE reply
	ADD CONSTRAINT PK_reply -- reply 기본키
		PRIMARY KEY (
			rb_num -- rb_num
		);

-- mentorboard
CREATE TABLE mentorboard (
	mb_num  INT           NOT NULL COMMENT 'PK', -- mb_num
	title   VARCHAR(200)  NULL     COMMENT '제목', -- title
	content VARCHAR(1000) NULL     COMMENT '내용', -- content
	regDate DATE          NULL     COMMENT '등록일자', -- regDate
	id      VARCHAR(30)   NULL     COMMENT '아이디' -- id
)
COMMENT 'mentorboard';

-- mentorboard
ALTER TABLE mentorboard
	ADD CONSTRAINT PK_mentorboard -- mentorboard 기본키
		PRIMARY KEY (
			mb_num -- mb_num
		);

-- counselBoard
CREATE TABLE counselBoard (
	cb_num       INT           NOT NULL COMMENT 'cb_num', -- cb_num
	title        VARCHAR(200)  NULL     COMMENT 'title', -- title
	content      VARCHAR(1000) NULL     COMMENT 'content', -- content
	makePublic   VARCHAR(10)   NULL     COMMENT 'makePublic', -- makePublic
	regDate      DATE          NULL     COMMENT 'regDate', -- regDate
	hit          INT           NULL     COMMENT 'hit', -- hit
	id           VARCHAR(30)   NULL     COMMENT 'id', -- id
	fileGroupNum INT           NULL     COMMENT 'fileGroupNum' -- fileGroupNum
)
COMMENT 'counselBoard';

-- counselBoard
ALTER TABLE counselBoard
	ADD CONSTRAINT PK_counselBoard -- counselBoard 기본키
		PRIMARY KEY (
			cb_num -- cb_num
		);

-- educational_level
CREATE TABLE educational_level (
	eduLevel_num    INT          NOT NULL COMMENT 'PK', -- eduLevel_num
	degree_level    VARCHAR(10)  NULL     COMMENT '학업수준', -- degree_level
	school_name     VARCHAR(50)  NULL     COMMENT '학교명', -- school_name
	admission_date  DATE         NULL     COMMENT '입학일', -- admission_date
	graduation_date DATE         NULL     COMMENT '졸업일', -- graduation_date
	current_status  VARCHAR(50)  NULL     COMMENT '현재상태', -- current_status
	major           VARCHAR(100) NULL     COMMENT '전공', -- major
	avg_score       DECIMAL(3,2) NULL     COMMENT '평점', -- avg_score
	total_score     INT          NULL     COMMENT '총점', -- total_score
	id              VARCHAR(30)  NULL     COMMENT '아이디' -- id
)
COMMENT 'educational_level';

-- educational_level
ALTER TABLE educational_level
	ADD CONSTRAINT PK_educational_level -- educational_level 기본키
		PRIMARY KEY (
			eduLevel_num -- eduLevel_num
		);

-- certificate
CREATE TABLE certificate (
	certificate_num      INT          NOT NULL COMMENT 'certificate_num', -- certificate_num
	certificate_name     VARCHAR(50)  NULL     COMMENT 'certificate_name', -- certificate_name
	published_by_license VARCHAR(100) NULL     COMMENT 'published_by_license', -- published_by_license
	acquisition_date     DATE         NULL     COMMENT 'acquisition_date', -- acquisition_date
	id                   VARCHAR(30)  NULL     COMMENT 'id' -- id
)
COMMENT 'certificate';

-- certificate
ALTER TABLE certificate
	ADD CONSTRAINT PK_certificate -- certificate 기본키
		PRIMARY KEY (
			certificate_num -- certificate_num
		);

-- mentoring
CREATE TABLE mentoring (
	mentoring_num INT           NOT NULL COMMENT 'mentoring_num', -- mentoring_num
	cb_num        INT           NULL     COMMENT 'cb_num', -- cb_num
	mb_num        INT           NULL     COMMENT 'mb_num', -- mb_num
	status        VARCHAR(20)   NULL     COMMENT 'status', -- status
	content       VARCHAR(1000) NULL     COMMENT 'content' -- content
)
COMMENT 'mentoring';

-- mentoring
ALTER TABLE mentoring
	ADD CONSTRAINT PK_mentoring -- mentoring 기본키
		PRIMARY KEY (
			mentoring_num -- mentoring_num
		);

-- freeBoard
CREATE TABLE freeBoard (
	fb_num       INT           NOT NULL COMMENT 'fb_num', -- fb_num
	title        VARCHAR(200)  NULL     COMMENT 'title', -- title
	content      VARCHAR(1000) NULL     COMMENT 'content', -- content
	regDate      DATE          NULL     COMMENT 'regDate', -- regDate
	hit          INT           NULL     COMMENT 'hit', -- hit
	id           VARCHAR(30)   NULL     COMMENT 'id', -- id
	fileGroupNum INT           NULL     COMMENT 'fileGroupNum' -- fileGroupNum
)
COMMENT 'freeBoard';

-- freeBoard
ALTER TABLE freeBoard
	ADD CONSTRAINT PK_freeBoard -- freeBoard 기본키
		PRIMARY KEY (
			fb_num -- fb_num
		);

<<<<<<< HEAD
-- files
CREATE TABLE files (
	fileGroupNum  INT          NOT NULL COMMENT 'fileGroupNum', -- fileGroupNum
	file_num      INT          NOT NULL COMMENT 'file_num', -- file_num
	original_name VARCHAR(50)  NULL     COMMENT 'original_name', -- original_name
	fileName      VARCHAR(100) NULL     COMMENT 'fileName', -- fileName
	fileSize      INT          NULL     COMMENT 'fileSize', -- fileSize
	fileHash      VARCHAR(200) NULL     COMMENT 'fileHash', -- fileHash
	fileExtension VARCHAR(20)  NULL     COMMENT 'fileExtension', -- fileExtension
	regDate       DATE         NULL     COMMENT 'regDate' -- regDate
)
COMMENT 'files';

-- files
ALTER TABLE files
	ADD CONSTRAINT PK_files -- files 기본키
		PRIMARY KEY (
			file_num      -- file_num
		);

=======
>>>>>>> branch 'master' of https://github.com/dooseopkim/inturn_Prj.git
-- fileGroup
CREATE TABLE fileGroup (
	fileGroupNum  INT          NOT NULL COMMENT 'fileGroupNum', -- fileGroupNum
	fileGroupPath VARCHAR(200) NULL     COMMENT 'fileGroupPath' -- fileGroupPath
)
COMMENT 'fileGroup';

-- fileGroup
ALTER TABLE fileGroup
	ADD CONSTRAINT PK_fileGroup -- fileGroup 기본키
		PRIMARY KEY (
			fileGroupNum -- fileGroupNum
		);

-- files
CREATE TABLE files (
	file_num      INT          NOT NULL COMMENT 'file_num', -- file_num
	original_name VARCHAR(50)  NULL     COMMENT 'original_name', -- original_name
	fileName      VARCHAR(100) NULL     COMMENT 'fileName', -- fileName
	fileSize      INT          NULL     COMMENT 'fileSize', -- fileSize
	fileHash      VARCHAR(200) NULL     COMMENT 'fileHash', -- fileHash
	fileExtension VARCHAR(20)  NULL     COMMENT 'fileExtension', -- fileExtension
	fileGroupNum  INT          NULL COMMENT 'fileGroupNum', -- fileGroupNum
	regDate       DATE         NULL     COMMENT 'regDate' -- regDate
)
COMMENT 'files';

ALTER TABLE files
	ADD CONSTRAINT PK_files -- files 기본키
		PRIMARY KEY (
			file_num      -- file_num
		);

-- dic_select
CREATE TABLE dic_select (
	dic_num INT         NULL COMMENT 'dic_num', -- dic_num
	id      VARCHAR(30) NULL COMMENT 'id' -- id
)
COMMENT 'dic_select';

-- users
ALTER TABLE users
	ADD CONSTRAINT FK_icon_TO_users -- icon -> users
		FOREIGN KEY (
			icon_num -- icon_num
		)
		REFERENCES icon ( -- icon
			icon_num -- icon_num
		);

-- career
ALTER TABLE career
	ADD CONSTRAINT FK_users_TO_career -- users -> career
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- job
ALTER TABLE job
	ADD CONSTRAINT FK_users_TO_job -- users -> job
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- introduce
ALTER TABLE introduce
	ADD CONSTRAINT FK_users_TO_introduce -- users -> introduce
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- review
ALTER TABLE review
	ADD CONSTRAINT FK_users_TO_review -- users -> review
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- portfolio
ALTER TABLE portfolio
	ADD CONSTRAINT FK_users_TO_portfolio -- users -> portfolio
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- reply
ALTER TABLE reply
	ADD CONSTRAINT FK_users_TO_reply -- users -> reply
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- reply
ALTER TABLE reply
	ADD CONSTRAINT FK_freeBoard_TO_reply -- freeBoard -> reply
		FOREIGN KEY (
			fb_num -- fb_num
		)
		REFERENCES freeBoard ( -- freeBoard
			fb_num -- fb_num
		);

-- reply
ALTER TABLE reply
	ADD CONSTRAINT FK_counselBoard_TO_reply -- counselBoard -> reply
		FOREIGN KEY (
			cb_num -- cb_num
		)
		REFERENCES counselBoard ( -- counselBoard
			cb_num -- cb_num
		);

-- mentorboard
ALTER TABLE mentorboard
	ADD CONSTRAINT FK_users_TO_mentorboard -- users -> mentorboard
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- counselBoard
ALTER TABLE counselBoard
	ADD CONSTRAINT FK_users_TO_counselBoard -- users -> counselBoard
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- counselBoard
ALTER TABLE counselBoard
	ADD CONSTRAINT FK_fileGroup_TO_counselBoard -- fileGroup -> counselBoard
		FOREIGN KEY (
			fileGroupNum -- fileGroupNum
		)
		REFERENCES fileGroup ( -- fileGroup
			fileGroupNum -- fileGroupNum
		);

-- educational_level
ALTER TABLE educational_level
	ADD CONSTRAINT FK_users_TO_educational_level -- users -> educational_level
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- certificate
ALTER TABLE certificate
	ADD CONSTRAINT FK_users_TO_certificate -- users -> certificate
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- mentoring
ALTER TABLE mentoring
	ADD CONSTRAINT FK_counselBoard_TO_mentoring -- counselBoard -> mentoring
		FOREIGN KEY (
			cb_num -- cb_num
		)
		REFERENCES counselBoard ( -- counselBoard
			cb_num -- cb_num
		);

-- mentoring
ALTER TABLE mentoring
	ADD CONSTRAINT FK_mentorboard_TO_mentoring -- mentorboard -> mentoring
		FOREIGN KEY (
			mb_num -- mb_num
		)
		REFERENCES mentorboard ( -- mentorboard
			mb_num -- mb_num
		);

-- freeBoard
ALTER TABLE freeBoard
	ADD CONSTRAINT FK_users_TO_freeBoard -- users -> freeBoard
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);

-- freeBoard
ALTER TABLE freeBoard
	ADD CONSTRAINT FK_fileGroup_TO_freeBoard -- fileGroup -> freeBoard
		FOREIGN KEY (
			fileGroupNum -- fileGroupNum
		)
		REFERENCES fileGroup ( -- fileGroup
			fileGroupNum -- fileGroupNum
		);

-- files
ALTER TABLE files
	ADD CONSTRAINT FK_fileGroup_TO_files -- fileGroup -> files
		REFERENCES fileGroup ( -- fileGroup
			fileGroupNum -- fileGroupNum
		);

-- dic_select
ALTER TABLE dic_select
	ADD CONSTRAINT FK_dictionary_TO_dic_select -- dictionary -> dic_select
		FOREIGN KEY (
			dic_num -- dic_num
		)
		REFERENCES dictionary ( -- dictionary
			dic_num -- dic_num
		);

-- dic_select
ALTER TABLE dic_select
	ADD CONSTRAINT FK_users_TO_dic_select -- users -> dic_select
		FOREIGN KEY (
			id -- id
		)
		REFERENCES users ( -- users
			id -- id
		);