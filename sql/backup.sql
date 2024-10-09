-- MariaDB dump 10.19-11.1.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: OnlineExamSystem
-- ------------------------------------------------------
-- Server version	11.1.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Current Database: `OnlineExamSystem`
--

CREATE DATABASE /*!32312 IF NOT EXISTS */ `OnlineExamSystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;

USE `OnlineExamSystem`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin`
(
    `adminId`   INT(9) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
    `adminName` VARCHAR(20) DEFAULT NULL COMMENT '姓名',
    `sex`       VARCHAR(2)  DEFAULT NULL COMMENT '性别',
    `phone`     VARCHAR(11) DEFAULT NULL COMMENT '电话号码',
    `email`     VARCHAR(20) DEFAULT NULL COMMENT '电子邮箱',
    `password`  CHAR(65)    DEFAULT NULL COMMENT '密码',
    `cardId`    VARCHAR(18) DEFAULT NULL COMMENT '身份证号',
    `role`      VARCHAR(1)  DEFAULT NULL COMMENT '身份',
    PRIMARY KEY (`adminId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='管理员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin`
    DISABLE KEYS */;
INSERT INTO `admin`
VALUES (1, 'bryan', '男', '11111111111', '2427443849@qq.com',
        '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '111111111111111111', '0');
/*!40000 ALTER TABLE `admin`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_manage`
--

DROP TABLE IF EXISTS `exam_manage`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_manage`
(
    `examCode`    INT(9) NOT NULL AUTO_INCREMENT COMMENT '考试编号',
    `description` VARCHAR(50)  DEFAULT NULL COMMENT '该次考试介绍',
    `source`      VARCHAR(20)  DEFAULT NULL COMMENT '课程名称',
    `paperId`     INT(10)      DEFAULT NULL COMMENT '试卷编号',
    `examDate`    VARCHAR(10)  DEFAULT NULL COMMENT '考试日期',
    `totalTime`   INT(3)       DEFAULT NULL COMMENT '持续时长',
    `grade`       VARCHAR(10)  DEFAULT NULL COMMENT '年级',
    `term`        VARCHAR(10)  DEFAULT NULL COMMENT '学期',
    `major`       VARCHAR(20)  DEFAULT NULL COMMENT '专业',
    `institute`   VARCHAR(20)  DEFAULT NULL COMMENT '学院',
    `totalScore`  INT(4)       DEFAULT NULL COMMENT '总分',
    `type`        VARCHAR(255) DEFAULT NULL COMMENT '考试类型',
    `tips`        VARCHAR(255) DEFAULT NULL COMMENT '考生须知',
    PRIMARY KEY (`examCode`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20190014
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='考试管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_manage`
--

LOCK TABLES `exam_manage` WRITE;
/*!40000 ALTER TABLE `exam_manage`
    DISABLE KEYS */;
INSERT INTO `exam_manage`
VALUES (20190001, '2019年上期期末考试', '计算机网络', 1001, '2019-03-21', 120, '2018', '1', '计算机科学与技术',
        '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190002, '2019年上期期末考试', '数据库理论', 1002, '2019-03-07', 90, '2018', '2', '网络工程', '软件工程学院',
        100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190003, '2018年下期期末考试', '数据结构', 1003, '2019-02-27', 90, '2017', '1', '软件工程', '软件工程学院',
        100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190005, '2018年上期期末考试', '计算机导论', 1004, '2019-03-14', 90, '2018', '1', '计算机科学与技术',
        '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190006, '2017年上期期末考试', '软件工程', 1005, '2019-03-21', 120, '2018', '1', '计算机科学与技术',
        '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190007, '2018年上期期末考试', '操作系统', 1006, '2019-03-13', 120, '2018', '2', '计算机科学与技术',
        '软件工程学院', 100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190008, '2018年下期期末考试', 'C语言', 1007, '2019-03-13', 120, '2018', '1', '信息工程', '软件工程学院', 100,
        '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190009, '2018年上期期末考试', '高等数学', 1008, '2019-03-07', 90, '2018', '1', '信息工程', '软件工程学院',
        100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190010, '2018年上期期末考试', '计算机网络', 1010, '2019-03-07', 90, '2017', '1', '信息工程', '软件工程学院',
        100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。'),
       (20190013, '2018年下期期末考试', '数据库理论', 1015, '2019-02-27', 120, '2017', '1', '软件工程', '软件工程学员',
        100, '期末考试', '快乐千万条，学习第一条，平时不努力，考试两行泪。');
/*!40000 ALTER TABLE `exam_manage`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fill_question`
--

DROP TABLE IF EXISTS `fill_question`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fill_question`
(
    `questionId` INT(9) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
    `subject`    VARCHAR(20)  DEFAULT NULL COMMENT '考试科目',
    `question`   VARCHAR(255) DEFAULT NULL COMMENT '试题内容',
    `answer`     VARCHAR(255) DEFAULT NULL COMMENT '正确答案',
    `analysis`   VARCHAR(255) DEFAULT NULL COMMENT '题目解析',
    `score`      INT(2)       DEFAULT 2 COMMENT '分数',
    `level`      VARCHAR(5)   DEFAULT NULL COMMENT '难度等级',
    `section`    VARCHAR(20)  DEFAULT NULL COMMENT '所属章节',
    PRIMARY KEY (`questionId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10031
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='填空题题库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fill_question`
--

LOCK TABLES `fill_question` WRITE;
/*!40000 ALTER TABLE `fill_question`
    DISABLE KEYS */;
INSERT INTO `fill_question`
VALUES (10000, '计算机网络', '从计算机网络系统组成的角度看，计算机网络可以分为()和()', '通信子网资源子网', NULL, 2, '3',
        NULL),
       (10001, '计算机网络', '收发电子邮件，属于ISO/OSI RM中 ()层的功能。', '应用', NULL, 2, '1', NULL),
       (10002, '计算机网络',
        '在TCP/IP层次模型中与OSI参考模型第四层相对应的主要协议有()和(),其中后者提供无连接的不可靠传输服',
        'TCP（传输控制协议） UDP（用户数据报协议） ', NULL, 2, '2', NULL),
       (10003, '计算机网络', '计算机网络中常用的三种有线媒体是 (),()和 ()', '同轴电缆.双绞线 光纤', NULL, 2, '1', NULL),
       (10004, '计算机网络', '国内最早的四大网络包括原邮电部的ChinaNet. 原电子部的ChinaGBN. 教育部的()和中科院的CSTnet',
        'CERnet (或中国教育科研网)', NULL, 2, '4', NULL),
       (10005, '计算机网络',
        '复盖一个国家，地区或几个洲的计算机网络称为()，在同一建筑或复盖几公里内范围的网络称为()，而介于两者之间的是()',
        ' 广域网       局域网     城域网', NULL, 2, '1', NULL),
       (10006, '计算机网络', 'Outlook等常用电子邮件软件接收邮件使用的协议是(),发送邮件时使用的协议是()',
        'POP3    SMTP    ', NULL, 2, '1', NULL),
       (10007, '计算机网络', '通信系统中，称调制前的电信号为()信号，调制后的信号为调制信号', '基带', NULL, 2, '1', NULL),
       (10008, '计算机网络', '按照IPV4标准,IP地址205.3.127.13属于()类地址', 'C', NULL, 2, '1', NULL),
       (10009, '计算机网络', '计算机网络采用()技术，而传统电话网络则采用()技术', '分组交换电路交换', NULL, 2, '1', NULL),
       (10010, '计算机网络', '计算机内传输的信号是()，而公用电话系统的传输系统只能传输()', '数字信号模拟信号', NULL, 2,
        '1', NULL),
       (10011, '计算机网络', '通信系统中，称调制前的电信号为()，调制后的信号叫()。', '基带信号调制信号', NULL, 2, '1',
        NULL),
       (10012, '计算机网络', 'IP地址分()和()两个部分', '网络号主机号', NULL, 2, '1', NULL),
       (10013, '计算机网络', ' IP地址协议作网间网中()层协议，提供无连接的数据报传输机制，IP数据报也分为()和()两个部分',
        '网络报头数据区', NULL, 2, '2', NULL),
       (10014, '计算机网络', '()是一个简单的远程终端协议。', 'TELNET', NULL, 2, '1', NULL),
       (10015, '计算机网络',
        '在同一个系统内，相邻层之间交换信息的连接点称之为()，而低层模块向高层提供功能性的支持称之为()。', '接口服务', NULL,
        2, '1', NULL),
       (10016, '计算机网络', 'Internet广泛使用的电子邮件传送协议是()', 'SMTP', NULL, 2, '1', NULL),
       (10017, '计算机网络', '按交换方式来分类，计算机网络可以分为电路交换网，  报文交换网  和()三种', '分组交换网', NULL,
        2, '3', NULL),
       (10018, '计算机网络', 'Intranet分层结构包括网络、(),应用三个层次。', '服务', NULL, 2, '1', NULL),
       (10019, '计算机网络', 'WWW上的每一个网页都有一个独立的地址，这些地址称为  ()', '统一资源定位器/URL ', NULL, 2,
        '2', NULL),
       (10020, '计算机网络', '分组交换网中，附加信息用来在网络中进行路由选择、() 和流量控制', '差错纠正  ', NULL, 2, '4',
        NULL),
       (10021, '计算机网络', '根据IEEE802模型的标准将数据链路层划分为LLC子层和 ()子层。', ' MAC ', NULL, 2, '3', NULL),
       (10022, '计算机网络', '据交换的路由信息的不同，路由算法可以分为两大类：  ()  和链路状态算法', '距离向量算法', NULL,
        2, '3', NULL),
       (10023, '计算机网络',
        '假定某信道受奈氏准则限制的最高码元速率为2000码元/秒。如果采用振幅调制，把码元的振幅划分为16个不同等级来传送，那么可以获得的数据率为 () b/s。',
        '80000 ', NULL, 2, '5', NULL),
       (10024, '计算机网络',
        '交换型以太网系统中的 ()  ，以其为核心联接站点或者网段，端口之间帧的输入和输出已不再受到CSMA/CD媒体访问控制协议的约束。',
        '以太网交换器 ', NULL, 2, '5', NULL),
       (10025, '计算机网络', '局域网络参考模型是以 ()标准为基础的', 'IEEE802', NULL, 2, '5', NULL),
       (10026, '计算机网络', '路由器的核心是 () 。', ' 路由表', NULL, 2, '3', NULL),
       (10027, '计算机网络', '若 HDLC 帧数据段中出现比特串“ 01011111110 ”，则比特填充后的输出为()', '10111110110', NULL,
        2, '5', NULL),
       (10028, '计算机网络', '数字调制的三种基本形式：移幅键控法ASK、 ()、移相键控法PSK', '移频键控法FSK', NULL, 2, '5',
        NULL),
       (10029, '计算机网络', '在计算机网络中，()协议用于将域名解析为IP地址？', 'DNS', '', 2, '1', ''),
       (10030, '计算机网络', '测试()', '题目', '无', 2, '1', '测试题目');
/*!40000 ALTER TABLE `fill_question`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `judge_question`
--

DROP TABLE IF EXISTS `judge_question`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `judge_question`
(
    `questionId` INT(9) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
    `subject`    VARCHAR(20)  DEFAULT NULL COMMENT '考试科目',
    `question`   VARCHAR(255) DEFAULT NULL COMMENT '试题内容',
    `answer`     VARCHAR(255) DEFAULT NULL COMMENT '正确答案',
    `analysis`   VARCHAR(255) DEFAULT NULL COMMENT '题目解析',
    `score`      INT(2)       DEFAULT 2 COMMENT '分数',
    `level`      VARCHAR(1)   DEFAULT NULL COMMENT '难度等级',
    `section`    VARCHAR(20)  DEFAULT NULL COMMENT '所属章节',
    PRIMARY KEY (`questionId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10016
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='判断题题库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `judge_question`
--

LOCK TABLES `judge_question` WRITE;
/*!40000 ALTER TABLE `judge_question`
    DISABLE KEYS */;
INSERT INTO `judge_question`
VALUES (10001, '计算机网络', '与有线网相比,无线网的数据传输率一般相对较慢', 'T', NULL, 2, '1', ''),
       (10002, '计算机网络', 'OSI参考模型中,不同节点的同等层具有不同的功能', 'F', NULL, 2, '1', NULL),
       (10003, '计算机网络', '普通电脑不能作为服务器', 'F', NULL, 2, '1', NULL),
       (10004, '计算机网络', '没有网线的电脑不能连入互联网', 'F', NULL, 2, '1', NULL),
       (10005, '计算机网络', '网卡必须安装驱动程序', 'T', NULL, 2, '2', NULL),
       (10006, '计算机网络', 'UTP为屏蔽双绞线', 'F', NULL, 2, '2', NULL),
       (10007, '计算机网络', '网络接口卡又称为网卡,它是构成网络的基本部件', 'T', NULL, 2, '2', NULL),
       (10008, '计算机网络', '无线AP可以成倍地扩展网络覆盖范围', 'T', NULL, 2, '3', NULL),
       (10009, '计算机网络', 'SMTP是一组用于由源地址到目的地址传送邮件的协议', 'T', NULL, 2, '4', NULL),
       (10010, '计算机网络', '任务管理器可以关闭所有的进程', 'F', NULL, 2, '3', NULL),
       (10011, '计算机网络', '利用BT下载时,用户越多,下载速度越快', 'T', NULL, 2, '2', NULL),
       (10012, '计算机网络', 'INTERNET上向朋友发送电子邮件,必须知道对方的真实姓名和家庭住址', 'F', NULL, 2, '1', NULL),
       (10013, '计算机网络', '在计算机网络中，UDP协议提供可靠的数据传输服务。', 'F',
        '错误。UDP（用户数据报协议）是一种无连接协议，它不提供可靠的数据传输服务。UDP将数据报发送到目标，但不保证数据报的可靠性，也不提供重传机制或错误恢复功能。相比之下，TCP（传输控制协议）提供可靠的数据传输，具有连接建立、数据分段、重传等功能，用于确保数据的完整性和可靠性。',
        2, '1', '网络协议'),
       (10014, '计算机网络', '在计算机网络中，IP地址是用于标识计算机硬件的唯一标识符。', 'T',
        '正确。IP地址（Internet Protocol Address）是用于标识计算机硬件在网络中的唯一标识符。它是分配给每台计算机或设备的数字地址，用于在网络中路由和传递数据。 IP地址可以分为IPv4和IPv6两种格式，但无论哪种格式，它们都是用来唯一标识网络中的设备的。',
        2, '1', '网络基础'),
       (10015, '计算机网络', '测试', 'T', '测试', 2, '1', '测试');
/*!40000 ALTER TABLE `judge_question`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message`
(
    `id`      INT(9) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
    `title`   VARCHAR(20)  DEFAULT NULL COMMENT '标题',
    `content` VARCHAR(255) DEFAULT NULL COMMENT '留言内容',
    `time`    DATE         DEFAULT NULL COMMENT '留言时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='留言表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message`
    DISABLE KEYS */;
INSERT INTO `message`
VALUES (1, '关于数学考试成绩的疑问', '你们的数学考试成绩都出来了吗？我刚查了一下，感觉自己考得不太好，有点担心。',
        '2019-09-05'),
       (2, '项目遇到Bug', '我最近遇到了一些困难，无法解决一个bug。有人能帮我看看我的代码吗？', '2023-09-27');
/*!40000 ALTER TABLE `message`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper_manage`
--

DROP TABLE IF EXISTS `paper_manage`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper_manage`
(
    `paperId`      INT(9) DEFAULT NULL COMMENT '试卷编号',
    `questionType` INT(1) DEFAULT NULL COMMENT '题目类型',
    `questionId`   INT(9) DEFAULT NULL COMMENT '题目编号'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='试卷管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper_manage`
--

LOCK TABLES `paper_manage` WRITE;
/*!40000 ALTER TABLE `paper_manage`
    DISABLE KEYS */;
INSERT INTO `paper_manage`
VALUES (1001, 1, 10013),
       (1001, 1, 10005),
       (1001, 1, 10001),
       (1001, 1, 10004),
       (1001, 1, 10000),
       (1001, 1, 10016),
       (1001, 1, 10032),
       (1001, 1, 10025),
       (1001, 1, 10030),
       (1001, 1, 10017),
       (1001, 1, 10027),
       (1001, 1, 10023),
       (1001, 1, 10014),
       (1001, 1, 10009),
       (1001, 1, 10008),
       (1001, 1, 10011),
       (1001, 1, 10010),
       (1001, 1, 10021),
       (1001, 1, 10022),
       (1001, 1, 10026),
       (1001, 2, 10017),
       (1001, 2, 10012),
       (1001, 2, 10004),
       (1001, 2, 10005),
       (1001, 2, 10003),
       (1001, 2, 10008),
       (1001, 2, 10020),
       (1001, 2, 10013),
       (1001, 2, 10006),
       (1001, 2, 10015),
       (1001, 3, 10002),
       (1001, 3, 10009),
       (1001, 3, 10003),
       (1001, 3, 10005),
       (1001, 3, 10004),
       (1001, 3, 10012),
       (1001, 3, 10011),
       (1001, 3, 10006),
       (1001, 3, 10008),
       (1001, 3, 10001),
       (1004, 1, 10026),
       (1004, 1, 10030),
       (1004, 1, 10013),
       (1004, 1, 10014),
       (1004, 1, 10010),
       (1004, 1, 10000),
       (1004, 1, 10018),
       (1004, 1, 10007),
       (1004, 1, 10016),
       (1004, 1, 10015),
       (1004, 2, 10025),
       (1004, 2, 10011),
       (1004, 2, 10014),
       (1004, 2, 10012),
       (1004, 2, 10029),
       (1004, 2, 10005),
       (1004, 2, 10017),
       (1004, 2, 10026),
       (1004, 2, 10008),
       (1004, 2, 10023),
       (1004, 3, 10010),
       (1004, 3, 10011),
       (1004, 3, 10007),
       (1004, 3, 10012),
       (1004, 3, 10006),
       (1004, 3, 10002),
       (1004, 3, 10004),
       (1004, 3, 10009),
       (1004, 3, 10005),
       (1004, 3, 10008),
       (1001, 1, 10033),
       (1001, 1, 10034),
       (1001, 1, 10035),
       (1001, 2, 10030),
       (1001, 3, 10015);
/*!40000 ALTER TABLE `paper_manage`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply`
(
    `messageId` INT(255)     DEFAULT NULL COMMENT '留言编号',
    `replyId`   INT(9) NOT NULL AUTO_INCREMENT COMMENT '回复编号',
    `reply`     VARCHAR(255) DEFAULT NULL COMMENT '内容',
    `replyTime` DATE         DEFAULT NULL COMMENT '回复时间',
    PRIMARY KEY (`replyId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='留言回复表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply`
    DISABLE KEYS */;
INSERT INTO `reply`
VALUES (1, 1, '我数学成绩还可以，如果你有什么不懂的地方，可以问我。我们一起学习进步！', '2019-04-16'),
       (1, 2, '我也查了成绩，我的数学成绩也不理想。不过，别太担心，我们可以一起复习，互相帮助提高。', '2019-09-05'),
       (2, 3, '当然可以！请分享你的代码，我们会一起帮你找到问题并提供解决方案。', '2023-09-27');
/*!40000 ALTER TABLE `reply`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `score`
(
    `scoreId`    INT(9)      NOT NULL AUTO_INCREMENT COMMENT '分数编号',
    `examCode`   INT(9)      DEFAULT NULL COMMENT '考试编号',
    `studentId`  INT(9)      DEFAULT NULL COMMENT '学号',
    `subject`    VARCHAR(20) NOT NULL COMMENT '课程名称',
    `ptScore`    INT(5)      DEFAULT NULL COMMENT '平时成绩',
    `etScore`    INT(5)      DEFAULT NULL COMMENT '期末成绩',
    `score`      INT(5)      DEFAULT NULL COMMENT '总成绩',
    `answerDate` VARCHAR(10) DEFAULT NULL COMMENT '答题日期',
    PRIMARY KEY (`scoreId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 35
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='成绩管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score`
    DISABLE KEYS */;
INSERT INTO `score`
VALUES (4, 20190001, 20154084, '计算机网络', NULL, NULL, 70, '2019-04-03'),
       (14, 20190002, 20154084, '数据库理论', NULL, NULL, 78, '2019-04-20'),
       (15, 20190002, 20154084, '数据库理论', NULL, 80, 80, '2019-04-20'),
       (16, 20190002, 20154084, '数据库理论', NULL, 83, 83, '2019-04-20'),
       (17, 20190001, 20154001, '计算机网络', NULL, 74, 74, '2019-04-13'),
       (18, 20190001, 20154001, '计算机网络', NULL, 70, 70, '2019-04-10'),
       (19, 20190001, 20155003, '计算机网络', NULL, 86, 86, '2019-04-14'),
       (20, 20190001, 20155007, '计算机网络', NULL, 90, 90, '2019-04-11'),
       (21, 20190001, 20155007, '计算机网络', NULL, 92, 92, '2019-04-12'),
       (22, 20190001, 20155008, '计算机网络', NULL, 80, 80, '2019-04-12'),
       (23, 20190001, 20155003, '计算机网络', NULL, 90, 90, '2019-04-13'),
       (24, 20190001, 20155008, '计算机网络', NULL, 88, 88, '2019-04-14'),
       (27, 20190001, 20154084, '计算机网络', NULL, 80, 80, '2019-04-25'),
       (30, 20190001, 20154084, '计算机网络', NULL, 0, 0, '2019-04-29'),
       (31, 20190001, 20154084, '计算机网络', NULL, 0, 0, '2019-09-06'),
       (32, 20190001, 20155003, '计算机网络', NULL, 0, NULL, '2023-09-25'),
       (33, 20190001, 20155003, '计算机网络', NULL, 0, NULL, '2023-09-25'),
       (34, 20190001, 20155003, '计算机网络', NULL, 4, NULL, '2023-09-25');
/*!40000 ALTER TABLE `score`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selection_question`
--

DROP TABLE IF EXISTS `selection_question`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selection_question`
(
    `questionId`  INT(9) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
    `subject`     VARCHAR(20)  DEFAULT NULL COMMENT '考试科目',
    `question`    VARCHAR(255) DEFAULT NULL COMMENT '问题题目',
    `answerA`     VARCHAR(255) DEFAULT NULL COMMENT '选项A',
    `answerB`     VARCHAR(255) DEFAULT NULL COMMENT '选项B',
    `answerC`     VARCHAR(255) DEFAULT NULL COMMENT '选项C',
    `answerD`     VARCHAR(255) DEFAULT NULL COMMENT '选项D',
    `rightAnswer` VARCHAR(10)  DEFAULT NULL COMMENT '正确答案',
    `analysis`    VARCHAR(255) DEFAULT NULL COMMENT '题目解析',
    `score`       INT(2)       DEFAULT 2 COMMENT '分数',
    `section`     VARCHAR(20)  DEFAULT NULL COMMENT '所属章节',
    `level`       VARCHAR(1)   DEFAULT NULL COMMENT '难度等级',
    PRIMARY KEY (`questionId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10036
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='选择题题库表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selection_question`
--

LOCK TABLES `selection_question` WRITE;
/*!40000 ALTER TABLE `selection_question`
    DISABLE KEYS */;
INSERT INTO `selection_question`
VALUES (10000, '计算机网络', 'DNS 服务器和DHCP服务器的作用是（）', '将IP地址翻译为计算机名，为客户机分配IP地址',
        '将IP地址翻译为计算机名、解析计算机的MAC地址', '将计算机名翻译为IP地址、为客户机分配IP地址',
        '将计算机名翻译为IP地址、解析计算机的MAC地址', 'C', NULL, 2, '应用层', '2'),
       (10001, '计算机网络', 'HTTP协议通常使用什么协议进行传输（）', 'ARP', 'DHCP', 'UDP', 'TCP', 'D', NULL, 2, '应用层',
        '2'),
       (10003, '计算机网络', '查看DNS缓存记录的命令（）', 'ipconfig/displaydns', 'nslookup', 'ipconfig/release',
        'ipconfig/flushdns', 'A', NULL, 2, '应用层', '3'),
       (10004, '计算机网络', 'DHCP(        )报文的目的IP地址为255.255.255.255', 'DhcpDisover', 'DhcpOffer', 'DhcpAck',
        'DhcpNack', 'A', NULL, 2, '应用层', '2'),
       (10005, '计算机网络', '下列地址中，（  ）不是DHCP服务器分配的IP地址', '196.254.109.100', '169.254.12.42',
        '69.254.48.45', '96.254.54.15', 'B', NULL, 2, '应用层', '2'),
       (10006, '计算机网络', 'DHCP通常可以为客户端自动配置哪些网络参数（）', 'IP，掩码，网关，DNS', 'IP，掩码，域名，SMTP',
        '网关，掩码，浏览器，FTP', 'IP，网关，DNS，服务器', 'A', NULL, 2, '应用层', '2'),
       (10007, '计算机网络', 'DNS服务器在名称解析过程中正确的查询顺序为（）',
        '本地缓存记录→区域记录→转发域名服务器→根域名服务器', '区域记录→本地缓存记录→转发域名服务器→根域名服务器',
        '本地缓存记录→区域记录→根域名服务器→转发域名服务器', '区域记录→本地缓存记录→根域名服务器→转发域名服务器', 'A',
        NULL, 2, '应用层', '3'),
       (10008, '计算机网络', '在TCP/IP协议中，序号小于（  ）的端口称为熟知端口(well-known port)。', '1024', '64', '256',
        '128', 'A', NULL, 2, '传输层', '1'),
       (10009, '计算机网络', '在Internet上用TCP/IP播放视频，想用传输层的最快协议，以减少时延，要使用（ ）',
        'UDP协议的低开销特性', 'UDP协议的高开销特性', 'TCP协议的低开销特性', 'TCP协议的高开销特性', 'A', NULL, 2,
        '传输层', '2'),
       (10010, '计算机网络', '在TCP协议中采用（ ）来区分不同的应用进程', '端口号', 'IP地址', '协议类型', 'MAC地址', 'A',
        NULL, 2, '传输层', '3'),
       (10011, '计算机网络', '可靠的传输协议中的“可靠”指的是（ ）', '使用面向连接的会话', '使用“尽力而为”的传输',
        '使用滑动窗口来维持可靠性', '使用确认重传机制来确保传输的数据不丢失', 'D', NULL, 2, '传输层', '2'),
       (10012, '计算机网络', '假设拥塞窗口为50KB，接收窗口为80KB，TCP能够发送的最大字节数为（ ）', '50KB', '80KB', '130KB',
        '30KB', 'A', NULL, 2, '传输层', '4'),
       (10013, '计算机网络',
        '主机A向主机B发送一个（SYN=1，seq=2000）的TCP报文，期望与主机B建立连接，若主机B接受连接请求，则主机B发送的正确有TCP报文可能是（ ）',
        '（SYN=0,ACK=0,seq=2001,ack=2001）', '（SYN=1,ACK=1,seq=2000,ack=2000）', '•	C.（SYN=1,ACK=1,seq=2001,ack=2001）',
        '（SYN=0,ACK=1,seq=2000,ack=2000）', 'C', NULL, 2, '传输层', '2'),
       (10014, '计算机网络',
        '主机A向主机B连续发送了两个TCP报文段，其序号分别为70和100。试问： （1）第一个报文段携带了（）个字节的数据？', ' 70',
        '30', '100', '170', 'B', NULL, 2, '传输层', '3'),
       (10015, '计算机网络', 'PCM脉码调制的过程（ ）', '采样、量化、编码', '量化、编码、采样', '编码、量化、采样',
        '采样、编码、量化', 'A', NULL, 2, '物理层', '4'),
       (10016, '计算机网络', '若某采用4相位调制的通信链路的数据传输速率为2400bps，则该链路的波特率为（）', '600Baud',
        '1200Baud', '4800Baud', '9600Baud', 'B', NULL, 2, '物理层', '1'),
       (10017, '计算机网络', '以下关于数据传输速率的描述中，错误的是( )',
        '数据传输速率表示每秒钟传输构成数据代码的二进制比特数', '对于二进制数据，数据传输速率为S=1/T (bps)',
        '常用的数据传输速率单位有: 1Mbps=1.024×106bps', '数据传输速率是描述数据传输系统性能的重要技术指标之一', 'C',
        NULL, 2, '物理层', '2'),
       (10018, '计算机网络', '以下关于时分多路复用概念的描述中，错误的是.(  ).',
        '时分多路复用将线路使用的时间分成多个时间片', '时分多路复用分为同步时分多路复用与统计时分多路复用',
        '时分多路复用使用“帧”与数据链路层“帧”的概念、作用是不同的', '统计时分多路复用将时间片预先分配给各个信道', 'D',
        NULL, 2, '物理层', '2'),
       (10019, '计算机网络', '1000BASE-T标准支持的传输介质是（）', '双绞线', '同轴电缆', '光纤', '无线电', 'A', NULL, 2,
        '物理层', '1'),
       (10020, '计算机网络', '一个以太网交换机，读取整个数据帧，对数据帧进行差错校验后再转发出去，这种交换方式称为 （）',
        '直通交换', '无碎片交换', '无差错交换', '存储转发交换', 'D', NULL, 2, '数据链路层', '2'),
       (10021, '计算机网络', '关于VLAN，下面的描述中正确的是（）', '一个新的交换机没有配置VLAN',
        '通过配置VLAN减少了冲突域的数量', '一个VLAN不能跨越多个交换机', '各个VLAN属于不同的广播域', 'D', NULL, 2,
        '数据链路层', '2'),
       (10022, '计算机网络', '以太网协议中使用物理地址作用是什么？', '.用于不同子网中的主机进行通信',
        '作为第二层设备的唯一标识', '用于区别第二层第三层的协议数据单元', '保存主机可检测未知的远程设备', 'B', NULL, 2,
        '数据链路层', '2'),
       (10023, '计算机网络',
        '以太网采用的CSMA/CD协议，当冲突发生时要通过二进制指数后退算法计算后退延时， 关于这个算法，以下论述中错误的是 （）',
        '冲突次数越多，后退的时间越短', '平均后退次数的多少与负载大小有关', '后退时延的平均值与负载大小有关',
        '重发次数达到一定极限后放弃发送', 'A', NULL, 2, '数据链路层', '3'),
       (10024, '计算机网络', '以下关于交换机获取与其端口连接设备的MAC地址的叙述中，正确的是（）',
        '交换机从路由表中提取设备的MAC地址', '交换机检查端口流入分组的源地址', '交换机之间互相交换地址表',
        '网络管理员手工输入设备的MAC地址', 'B', NULL, 2, '数据链路层', '2'),
       (10025, '计算机网络', '如果G (x）为11010010，以下4个CRC校验比特序列中只有哪个可能是正确的 ？', '1101011001',
        '101011011', '11011011', '1011001', 'B', NULL, 2, '数据链路层', '1'),
       (10026, '计算机网络', '以下关于Ethernet物理地址的描述中，错误的是', 'Ethernet物理地址又叫做MAC地址',
        '48位的Ethernet物理地址允许分配的地址数达到247个', '网卡的物理地址写入主机的EPROM中',
        '每一块网卡的物理地址在全世界是唯一的', 'C', NULL, 2, '数据链路层', '3'),
       (10027, '计算机网络', '下列帧类型中，不属于HDLC帧类型的是（）', '信息帧', '确认帧', '监控帧', '无编号帧', 'B', NULL,
        2, '数据链路层', '1'),
       (10028, '计算机网络', '通过交换机连接的一组站点，关于它们的广播域和冲突域说法正确的是（）',
        '组成一个冲突域，但不是一个广播域', '组成一个广播域，但不是一个冲突域', '组成一个冲突域，也是一个广播域',
        '既不一个冲突域，也不是一个广播域', 'B', NULL, 2, '数据链路层', '3'),
       (10029, '计算机网络', '数据链路层的数据单位是（）', '帧', '字节', '比特', '分组', 'A', NULL, 2, '数据链路层', '1'),
       (10030, '计算机网络', 'LAN参考模型可分为物理层、（ ）', 'MAC，LLC等三层', 'LLC，MHS等三层', 'MAC，FTAM等三层',
        'LLC，VT等三层', 'A', NULL, 2, '数据链路层', '3'),
       (10031, '测试', '测试', 'A', 'B', 'C', 'D', 'B', '解析', 2, '测试', '4'),
       (10032, '计算机网络', 'DNS 服务器和DHCP服务器的作用是（）', 'A', 'B', 'C', 'D', 'B', '哦解析', 2, '网络层', '2'),
       (10034, '计算机网络', '在计算机网络中，下列哪种协议是一种基于令牌环的局域网协议？', 'Ethernet', 'TCP/IP', 'ATM',
        'FDDI', 'D',
        'FDDI（Fiber Distributed Data Interface）是一种基于光纤的局域网协议，它使用令牌环拓扑来控制数据传输。Ethernet（选项A）通常使用星型拓扑，TCP/IP（选项B）是一组协议，而ATM（选项C）是一种异步传输模式，不是局域网协议。因此，FDDI是一种基于令牌环的局域网协议。',
        2, '数据链路层', '3'),
       (10035, '计算机网络', '测试题目', 'a', 'b', 'c', 'd', 'A', '测试题目', 2, '测试', '1');
/*!40000 ALTER TABLE `selection_question`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student`
(
    `studentId`   INT(9) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `studentName` VARCHAR(20) DEFAULT NULL COMMENT '姓名',
    `grade`       VARCHAR(4)  DEFAULT NULL COMMENT '年级',
    `major`       VARCHAR(20) DEFAULT NULL COMMENT '专业',
    `clazz`       VARCHAR(10) DEFAULT NULL COMMENT '班级',
    `institute`   VARCHAR(30) DEFAULT NULL COMMENT '学院',
    `phone`       VARCHAR(11) DEFAULT NULL COMMENT '电话号码',
    `email`       VARCHAR(30) DEFAULT NULL COMMENT '电子邮件',
    `password`    CHAR(65)    DEFAULT NULL COMMENT '密码',
    `cardId`      VARCHAR(18) DEFAULT NULL COMMENT '身份证号',
    `sex`         VARCHAR(2)  DEFAULT NULL COMMENT '性别',
    `role`        VARCHAR(1)  DEFAULT '2' COMMENT '角色(0管理员，1教师，2学生)',
    PRIMARY KEY (`studentId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 20155011
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='学生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student`
    DISABLE KEYS */;
INSERT INTO `student`
VALUES (20154001, '小明', '2015', '计算机科学与技术', '2', '软件工程学院', '13585439532', 'gblw@163.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '3412312', '男', '2'),
       (20154084, '小张', '2015', '计算机科学与技术', '2', '软件工程学院', '13658377857', '13658377857@sina.cn',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '124123124535', '男', '2'),
       (20155003, '张三', '2015', '信息工程', '1', '软件工程学院', '15583829425', '15583829425@163.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '3242342', '男', '2'),
       (20155007, '李四', '2015', '网络工程', '1', '软件工程学院', '18734538457', '18734538457@163.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '2423423', '女', '2'),
       (20155008, '王五', '2015', '信息工程', '2', '软件工程学院', '15523619564', '15523619564@163.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '500234199704022353', '男', '2');
/*!40000 ALTER TABLE `student`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher`
(
    `teacherId`   INT(9) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `teacherName` VARCHAR(20) DEFAULT NULL COMMENT '姓名',
    `institute`   VARCHAR(20) DEFAULT NULL COMMENT '学院',
    `sex`         VARCHAR(2)  DEFAULT NULL COMMENT '性别',
    `phone`       VARCHAR(11) DEFAULT NULL COMMENT '电话号码',
    `email`       VARCHAR(20) DEFAULT NULL COMMENT '邮箱',
    `password`    CHAR(65)    DEFAULT NULL COMMENT '密码',
    `cardId`      VARCHAR(18) DEFAULT NULL COMMENT '身份证号',
    `type`        VARCHAR(20) DEFAULT NULL COMMENT '职称',
    `role`        VARCHAR(1)  DEFAULT NULL COMMENT '角色（0管理员，1教师，2学生）',
    PRIMARY KEY (`teacherId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 30081005
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='教师信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher`
    DISABLE KEYS */;
INSERT INTO `teacher`
VALUES (20081001, '张三', '软件工程学院', '男', '22222222222', '22233@163.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '423423283498', '教授', '1'),
       (20081002, '王五', '软件工程学院', '男', '11122111111', '232121@163.com',
        '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '793423113498', '讲师', '1');
/*!40000 ALTER TABLE `teacher`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2023-09-27 22:35:21
