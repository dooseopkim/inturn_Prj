-- users
ALTER TABLE `users`
	DROP FOREIGN KEY `FK_icon_TO_users`; -- icon -> users

-- career
ALTER TABLE `career`
	DROP FOREIGN KEY `FK_users_TO_career`; -- users -> career

-- job
ALTER TABLE `job`
	DROP FOREIGN KEY `FK_users_TO_job`; -- users -> job

-- introduce
ALTER TABLE `introduce`
	DROP FOREIGN KEY `FK_users_TO_introduce`; -- users -> introduce

-- review
ALTER TABLE `review`
	DROP FOREIGN KEY `FK_users_TO_review`; -- users -> review

-- portfolio
ALTER TABLE `portfolio`
	DROP FOREIGN KEY `FK_users_TO_portfolio`; -- users -> portfolio

-- reply
ALTER TABLE `reply`
	DROP FOREIGN KEY `FK_users_TO_reply`; -- users -> reply

-- reply
ALTER TABLE `reply`
	DROP FOREIGN KEY `FK_freeBoard_TO_reply`; -- freeBoard -> reply

-- reply
ALTER TABLE `reply`
	DROP FOREIGN KEY `FK_counselBoard_TO_reply`; -- counselBoard -> reply

-- mentorboard
ALTER TABLE `mentorboard`
	DROP FOREIGN KEY `FK_users_TO_mentorboard`; -- users -> mentorboard

-- counselBoard
ALTER TABLE `counselBoard`
	DROP FOREIGN KEY `FK_users_TO_counselBoard`; -- users -> counselBoard

-- educational_level
ALTER TABLE `educational_level`
	DROP FOREIGN KEY `FK_users_TO_educational_level`; -- users -> educational_level

-- certificate
ALTER TABLE `certificate`
	DROP FOREIGN KEY `FK_users_TO_certificate`; -- users -> certificate

-- mentoring
ALTER TABLE `mentoring`
	DROP FOREIGN KEY `FK_counselBoard_TO_mentoring`; -- counselBoard -> mentoring

-- mentoring
ALTER TABLE `mentoring`
	DROP FOREIGN KEY `FK_mentorboard_TO_mentoring`; -- mentorboard -> mentoring

-- freeBoard
ALTER TABLE `freeBoard`
	DROP FOREIGN KEY `FK_users_TO_freeBoard`; -- users -> freeBoard

-- files
ALTER TABLE `files`
	DROP FOREIGN KEY `FK_fileGroup_TO_files`; -- fileGroup -> files

-- fileGroup
ALTER TABLE `fileGroup`
	DROP FOREIGN KEY `FK_freeBoard_TO_fileGroup`; -- freeBoard -> fileGroup

-- fileGroup
ALTER TABLE `fileGroup`
	DROP FOREIGN KEY `FK_qnaBoard_TO_fileGroup`; -- qnaBoard -> fileGroup

-- dic_select
ALTER TABLE `dic_select`
	DROP FOREIGN KEY `FK_dictionary_TO_dic_select`; -- dictionary -> dic_select

-- dic_select
ALTER TABLE `dic_select`
	DROP FOREIGN KEY `FK_users_TO_dic_select`; -- users -> dic_select

-- qnaBoard
ALTER TABLE `qnaBoard`
	DROP FOREIGN KEY `FK_users_TO_qnaBoard`; -- users -> qnaBoard

-- users
ALTER TABLE `users`
	DROP PRIMARY KEY; -- users 기본키

-- career
ALTER TABLE `career`
	DROP PRIMARY KEY; -- career 기본키

-- job
ALTER TABLE `job`
	DROP PRIMARY KEY; -- job 기본키

-- introduce
ALTER TABLE `introduce`
	DROP PRIMARY KEY; -- introduce 기본키

-- icon
ALTER TABLE `icon`
	DROP PRIMARY KEY; -- icon 기본키

-- dictionary
ALTER TABLE `dictionary`
	DROP PRIMARY KEY; -- dictionary 기본키

-- review
ALTER TABLE `review`
	DROP PRIMARY KEY; -- review 기본키

-- portfolio
ALTER TABLE `portfolio`
	DROP PRIMARY KEY; -- portfolio 기본키

-- reply
ALTER TABLE `reply`
	DROP PRIMARY KEY; -- reply 기본키

-- mentorboard
ALTER TABLE `mentorboard`
	DROP PRIMARY KEY; -- mentorboard 기본키

-- counselBoard
ALTER TABLE `counselBoard`
	DROP PRIMARY KEY; -- counselBoard 기본키

-- educational_level
ALTER TABLE `educational_level`
	DROP PRIMARY KEY; -- educational_level 기본키

-- certificate
ALTER TABLE `certificate`
	DROP PRIMARY KEY; -- certificate 기본키

-- mentoring
ALTER TABLE `mentoring`
	DROP PRIMARY KEY; -- mentoring 기본키

-- freeBoard
ALTER TABLE `freeBoard`
	DROP PRIMARY KEY; -- freeBoard 기본키

-- files
ALTER TABLE `files`
	DROP PRIMARY KEY; -- files 기본키

-- fileGroup
ALTER TABLE `fileGroup`
	DROP PRIMARY KEY; -- fileGroup 기본키

-- qnaBoard
ALTER TABLE `qnaBoard`
	DROP PRIMARY KEY; -- qnaBoard 기본키

-- users
DROP TABLE IF EXISTS `users` RESTRICT;

-- career
DROP TABLE IF EXISTS `career` RESTRICT;

-- job
DROP TABLE IF EXISTS `job` RESTRICT;

-- introduce
DROP TABLE IF EXISTS `introduce` RESTRICT;

-- icon
DROP TABLE IF EXISTS `icon` RESTRICT;

-- dictionary
DROP TABLE IF EXISTS `dictionary` RESTRICT;

-- review
DROP TABLE IF EXISTS `review` RESTRICT;

-- portfolio
DROP TABLE IF EXISTS `portfolio` RESTRICT;

-- reply
DROP TABLE IF EXISTS `reply` RESTRICT;

-- mentorboard
DROP TABLE IF EXISTS `mentorboard` RESTRICT;

-- counselBoard
DROP TABLE IF EXISTS `counselBoard` RESTRICT;

-- educational_level
DROP TABLE IF EXISTS `educational_level` RESTRICT;

-- certificate
DROP TABLE IF EXISTS `certificate` RESTRICT;

-- mentoring
DROP TABLE IF EXISTS `mentoring` RESTRICT;

-- freeBoard
DROP TABLE IF EXISTS `freeBoard` RESTRICT;

-- files
DROP TABLE IF EXISTS `files` RESTRICT;

-- fileGroup
DROP TABLE IF EXISTS `fileGroup` RESTRICT;

-- dic_select
DROP TABLE IF EXISTS `dic_select` RESTRICT;

-- qnaBoard
DROP TABLE IF EXISTS `qnaBoard` RESTRICT;