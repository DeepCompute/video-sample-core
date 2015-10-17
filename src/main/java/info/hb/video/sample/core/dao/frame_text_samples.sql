-- phpMyAdmin SQL Dump
-- version 4.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2015-10-17 08:01:52
-- 服务器版本： 5.5.37-MariaDB-log
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `video`
--

-- --------------------------------------------------------

--
-- 表的结构 `frame_text_samples`
--

CREATE TABLE IF NOT EXISTS `frame_text_samples` (
`fid` int(11) NOT NULL COMMENT '自增id',
  `id` char(32) DEFAULT NULL COMMENT '视频帧的唯一ID',
  `frame_content` text NOT NULL COMMENT '视频帧对应的文本描述内容',
  `frame_index` int(11) NOT NULL COMMENT '视频帧所在视频的索引',
  `frame_url` char(100) NOT NULL COMMENT '视频帧的存储地址',
  `video_id` int(11) NOT NULL COMMENT '视频ID',
  `video_name` char(100) NOT NULL COMMENT '视频完整名称',
  `edit_count` tinyint(4) NOT NULL COMMENT '编辑次数',
  `edit_users` char(150) NOT NULL COMMENT '所有编辑用户',
  `edit_user_last` char(100) NOT NULL COMMENT '最后一次编辑用户',
  `lasttime` datetime NOT NULL COMMENT '最后更新时间'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='视频帧文本化样本数据表' AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `frame_text_samples`
--

INSERT INTO `frame_text_samples` (`fid`, `id`, `frame_content`, `frame_index`, `frame_url`, `video_id`, `video_name`, `edit_count`, `edit_users`, `edit_user_last`, `lasttime`) VALUES
(1, '9506655ecf0da878a149093db7160fef', '', 1, 'http://192.168.31.11:1888/riak/frames/9506655ecf0da878a149093db7160fef.png', 134943298, 'D011交通路-金鄂商都入口-1-20140502155420-20140502155424-134943298.ts', 0, '', '', '2015-10-17 15:51:15'),
(2, 'ad03b77ed99fea99c211546097356136', '', 101, 'http://192.168.31.11:1888/riak/frames/ad03b77ed99fea99c211546097356136.png', 134943298, 'D011交通路-金鄂商都入口-1-20140502155420-20140502155424-134943298.ts', 0, '', '', '2015-10-17 15:51:15'),
(3, '20bb88d02282d8903303df364beb93b1', '', 201, 'http://192.168.31.11:1888/riak/frames/20bb88d02282d8903303df364beb93b1.png', 134943298, 'D011交通路-金鄂商都入口-1-20140502155420-20140502155424-134943298.ts', 0, '', '', '2015-10-17 15:51:15'),
(4, 'eb8ba40fe408bc7227abf8c1eddfb28b', '', 1, 'http://192.168.31.11:1888/riak/frames/eb8ba40fe408bc7227abf8c1eddfb28b.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.ts', 0, '', '', '2015-10-17 15:51:18'),
(5, '11e0b4314ef9dc630d70383a363b09b0', '', 101, 'http://192.168.31.11:1888/riak/frames/11e0b4314ef9dc630d70383a363b09b0.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.ts', 0, '', '', '2015-10-17 15:51:18'),
(6, '0be3c3d35877c54778dbcb3ac95df91a', '', 201, 'http://192.168.31.11:1888/riak/frames/0be3c3d35877c54778dbcb3ac95df91a.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.ts', 0, '', '', '2015-10-17 15:51:18'),
(7, 'b650f7ee307711e61a11992bc0614543', '', 1, 'http://192.168.31.11:1888/riak/frames/b650f7ee307711e61a11992bc0614543.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.avi', 0, '', '', '2015-10-17 15:51:21'),
(8, '6b3251c170d7af6c7d34f16ded7908a2', '', 101, 'http://192.168.31.11:1888/riak/frames/6b3251c170d7af6c7d34f16ded7908a2.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.avi', 0, '', '', '2015-10-17 15:51:21'),
(9, '8583db1b778e7fec3656b4b47c20face', '', 201, 'http://192.168.31.11:1888/riak/frames/8583db1b778e7fec3656b4b47c20face.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.avi', 0, '', '', '2015-10-17 15:51:21'),
(10, '25a7afc4c7f8ed0be17613b7dcc165ff', '', 301, 'http://192.168.31.11:1888/riak/frames/25a7afc4c7f8ed0be17613b7dcc165ff.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.avi', 0, '', '', '2015-10-17 15:51:21'),
(11, '5abfe2733744bdb799fd4e81e456f9fb', '', 401, 'http://192.168.31.11:1888/riak/frames/5abfe2733744bdb799fd4e81e456f9fb.png', 134176693, 'D004南市路-宛溪河畔小区出入口-1-20140502160005-20140502160006-134176693.avi', 0, '', '', '2015-10-17 15:51:21');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `frame_text_samples`
--
ALTER TABLE `frame_text_samples`
 ADD PRIMARY KEY (`fid`), ADD UNIQUE KEY `id` (`id`), ADD KEY `video_id` (`video_id`,`edit_count`,`edit_users`,`edit_user_last`), ADD KEY `lasttime` (`lasttime`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `frame_text_samples`
--
ALTER TABLE `frame_text_samples`
MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
