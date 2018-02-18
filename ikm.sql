-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2018 at 06:13 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.0.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ikm`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `useradmin` varchar(25) NOT NULL,
  `pw` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`useradmin`, `pw`) VALUES
('admin1', 'admin1'),
('admin2', 'admin2'),
('admin3', 'admin3');

-- --------------------------------------------------------

--
-- Table structure for table `answer_all`
--

CREATE TABLE `answer_all` (
  `id_answ_all` int(11) NOT NULL,
  `nores` int(11) DEFAULT NULL,
  `id_qall` varchar(25) DEFAULT NULL,
  `answer_all` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer_all`
--

INSERT INTO `answer_all` (`id_answ_all`, `nores`, `id_qall`, `answer_all`) VALUES
(1, 1, 'Q1', 3),
(2, 1, 'Q2', 3),
(3, 1, 'Q3', 4),
(4, 1, 'Q4', 3),
(5, 1, 'Q5', 4),
(6, 1, 'Q6', 3),
(7, 1, 'Q7', 3),
(8, 1, 'Q8', 3),
(9, 1, 'Q9', 4),
(10, 1, 'Q10', 4),
(11, 1, 'Q11', 3),
(12, 1, 'Q12', 3),
(13, 1, 'Q13', 2),
(14, 1, 'Q14', 4),
(15, 2, 'Q1', 4),
(16, 2, 'Q2', 4),
(17, 2, 'Q3', 2),
(18, 2, 'Q4', 3),
(19, 2, 'Q5', 3),
(20, 2, 'Q6', 4),
(21, 2, 'Q7', 3),
(22, 2, 'Q8', 3),
(23, 2, 'Q9', 3),
(24, 2, 'Q10', 3),
(25, 2, 'Q11', 4),
(26, 2, 'Q12', 4),
(27, 2, 'Q13', 4),
(28, 2, 'Q14', 4);

-- --------------------------------------------------------

--
-- Table structure for table `answer_loket`
--

CREATE TABLE `answer_loket` (
  `id_answ_loket` int(11) NOT NULL,
  `nores` int(15) DEFAULT NULL,
  `idloket` varchar(20) DEFAULT NULL,
  `id_qloket` varchar(20) DEFAULT NULL,
  `answ_loket` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answer_loket`
--

INSERT INTO `answer_loket` (`id_answ_loket`, `nores`, `idloket`, `id_qloket`, `answ_loket`) VALUES
(1, 1, 'lok1', 'qlok1', 3),
(2, 1, 'lok1', 'qlok2', 4),
(3, 1, 'lok1', 'qlok3', 3),
(4, 1, 'lok1', 'qlok4', 4),
(5, 1, 'lok1', 'qlok5', 3),
(6, 1, 'lok1', 'qlok6', 3),
(7, 1, 'lok2', 'qlok1', 4),
(8, 1, 'lok2', 'qlok2', 4),
(9, 1, 'lok2', 'qlok3', 4),
(10, 1, 'lok2', 'qlok4', 4),
(11, 1, 'lok2', 'qlok5', 4),
(25, 1, 'lok2', 'qlok6', 3),
(32, 1, 'lok3', 'qlok1', 2),
(33, 1, 'lok3', 'qlok2', 2),
(34, 1, 'lok3', 'qlok3', 1),
(35, 1, 'lok3', 'qlok4', 2),
(36, 1, 'lok3', 'qlok5', 3),
(37, 1, 'lok3', 'qlok6', 4);

-- --------------------------------------------------------

--
-- Table structure for table `loket`
--

CREATE TABLE `loket` (
  `idloket` varchar(20) NOT NULL,
  `nama` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loket`
--

INSERT INTO `loket` (`idloket`, `nama`) VALUES
('lok1', 'Loket 1'),
('lok2', 'Loket 2'),
('lok3', 'Loket 3');

-- --------------------------------------------------------

--
-- Table structure for table `qall`
--

CREATE TABLE `qall` (
  `id_qall` varchar(25) NOT NULL,
  `question` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qall`
--

INSERT INTO `qall` (`id_qall`, `question`) VALUES
('Q1', 'bklllklhjj'),
('Q10', 'Bagaimana pemahaman Saudara tentang kewajaran biaya untuk mendapatkan pelayanan? '),
('Q11', 'Bagaimana pemahaman Saudara tentang kesesuaian antara biaya yang dibayarkan dengan biaya yang telah ditetapkan? '),
('Q12', 'Bagaimana pemahaman Saudara tentang ketepatan pelaksanaan terhadap jadwal waktu pelayanan? '),
('Q13', 'Bagaimana pemahaman Saudara tentang kenyamanan di lingkungan unit pelayanan? '),
('Q14', 'Bagaimana pemahaman Saudara tentang keamanan pelayanan di unit ini? '),
('Q2', 'Bagaimana pendapat Saudara tentang kesesuaian persyaratan pelayanan dengan jenis pelayanannya?'),
('Q3', 'Bagaimana pemahaman Saudara tentang kejelasan dan kepastian petugas yang melayani?'),
('Q4', 'Bagaimana pemahaman Saudara tentang kedisiplinan petugas dalam memberikan pelayanan? '),
('Q5', 'Bagaimana pemahaman Saudara tentang tanggungjawab petugas dalam memberikan pelayanan? '),
('Q6', 'Bagaimana pemahaman Saudara tentang kemampuan petugas dalam memberikan pelayanan? '),
('Q7', 'Bagaimana pemahaman Saudara tentang kecepatan pelayanan di unit ini? '),
('Q8', 'Bagaimana pemahaman Saudara tentang keadilan untuk mendapatkan pelayanan di unit ini? '),
('Q9', 'Bagaimana pemahaman Saudara tentang kesopanan dan keramahan petugas dalam memberikan pelayanan? ');

-- --------------------------------------------------------

--
-- Table structure for table `qloket`
--

CREATE TABLE `qloket` (
  `id_qloket` varchar(20) NOT NULL,
  `question_loket` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qloket`
--

INSERT INTO `qloket` (`id_qloket`, `question_loket`) VALUES
('qlok1', 'Komunikatif: nyaman untuk diajak berbicara'),
('qlok2', 'Informatif: memberikan informasi secara rinci dan jelas '),
('qlok3', 'Disiplin terhadap waktu'),
('qlok4', 'Bertanggung jawab'),
('qlok5', 'Terampil dan sesuai dengan tugasnya'),
('qlok6', 'Sopan dan Ramah');

-- --------------------------------------------------------

--
-- Table structure for table `responden`
--

CREATE TABLE `responden` (
  `nores` int(15) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `umur` int(5) DEFAULT NULL,
  `jk` varchar(10) DEFAULT NULL,
  `pendidikan` varchar(50) DEFAULT NULL,
  `pekerjaan` varchar(50) DEFAULT NULL,
  `periode` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `responden`
--

INSERT INTO `responden` (`nores`, `tanggal`, `umur`, `jk`, `pendidikan`, `pekerjaan`, `periode`) VALUES
(1, '2018-02-14', 21, 'perempuan', 'S1', 'Mahasiswa Tua', 2017),
(2, '2018-02-12', 22, 'perempuan ', 'S2', 'akuntan', 2018),
(3, '2018-02-12', 26, 'perempuan', 'SMA', 'apoteker', 2017),
(4, '2018-02-12', 24, 'laki-laki', 'D3', 'manajemen', 2017),
(5, '2018-02-14', 30, 'laki-laki', 'S1', 'Pengacara', 2017);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`useradmin`);

--
-- Indexes for table `answer_all`
--
ALTER TABLE `answer_all`
  ADD PRIMARY KEY (`id_answ_all`),
  ADD KEY `nores` (`nores`),
  ADD KEY `id_qall` (`id_qall`);

--
-- Indexes for table `answer_loket`
--
ALTER TABLE `answer_loket`
  ADD PRIMARY KEY (`id_answ_loket`),
  ADD KEY `nores` (`nores`),
  ADD KEY `idloket` (`idloket`),
  ADD KEY `id_qloket` (`id_qloket`);

--
-- Indexes for table `loket`
--
ALTER TABLE `loket`
  ADD PRIMARY KEY (`idloket`);

--
-- Indexes for table `qall`
--
ALTER TABLE `qall`
  ADD PRIMARY KEY (`id_qall`);

--
-- Indexes for table `qloket`
--
ALTER TABLE `qloket`
  ADD PRIMARY KEY (`id_qloket`);

--
-- Indexes for table `responden`
--
ALTER TABLE `responden`
  ADD PRIMARY KEY (`nores`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer_all`
--
ALTER TABLE `answer_all`
  MODIFY `id_answ_all` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `answer_loket`
--
ALTER TABLE `answer_loket`
  MODIFY `id_answ_loket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer_all`
--
ALTER TABLE `answer_all`
  ADD CONSTRAINT `answer_all_ibfk_1` FOREIGN KEY (`nores`) REFERENCES `responden` (`nores`),
  ADD CONSTRAINT `answer_all_ibfk_2` FOREIGN KEY (`id_qall`) REFERENCES `qall` (`id_qall`);

--
-- Constraints for table `answer_loket`
--
ALTER TABLE `answer_loket`
  ADD CONSTRAINT `answer_loket_ibfk_1` FOREIGN KEY (`nores`) REFERENCES `responden` (`nores`),
  ADD CONSTRAINT `answer_loket_ibfk_2` FOREIGN KEY (`idloket`) REFERENCES `loket` (`idloket`),
  ADD CONSTRAINT `answer_loket_ibfk_3` FOREIGN KEY (`id_qloket`) REFERENCES `qloket` (`id_qloket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
