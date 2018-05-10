use userapp;
create table user (user_id bigint not null auto_increment, user_email_id varchar(255), user_name varchar(255), user_password varchar(255), primary key (user_id)) engine=MyISAM;
INSERT INTO `userapp`.`user`
(`user_id`,
`user_email_id`,
`user_name`,
`user_password`)
VALUES
(1,'test@email.com','test','test');
INSERT INTO `userapp`.`user`
(`user_id`,
`user_email_id`,
`user_name`,
`user_password`)
VALUES
(2,'test2@email.com','test2','test2');
create table userapp_config (config_id integer not null auto_increment, config_description varchar(255), config_message varchar(255), config_name varchar(255), config_value integer, config_visible_in_website bit, primary key (config_id)) engine=MyISAM;
INSERT INTO `userapp`.`userapp_config`
(`config_id`,
`config_description`,
`config_message`,
`config_name`,
`config_value`,
`config_visible_in_website`)
VALUES
(1,'This configuration tells whether the website is under maintenance or not. If it is under maintenance then config-value=1.', 'The website is under maintenance, sorry for the inconvenience.','website_maintenance_status',0,1);