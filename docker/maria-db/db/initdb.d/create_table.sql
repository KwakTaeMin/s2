CREATE TABLE `chat_content` (
        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '메시지 고유 번호 PK',
        `user_name` varchar(200) NOT NULL COMMENT '유저 이름',
        `message` text COMMENT '메시지 내용',
        `message_date` varchar(200) NOT NULL DEFAULT '1' COMMENT '메시지 발송 날짜',
        PRIMARY KEY (`id`),
        UNIQUE KEY `uk_chat` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='메시지 내용';