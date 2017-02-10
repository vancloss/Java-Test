-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 10 Février 2017 à 19:48
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `prueba`
--

-- --------------------------------------------------------

--
-- Structure de la table `mert_bitacora`
--

CREATE TABLE `mert_bitacora` (
  `id_documento` varchar(20) NOT NULL,
  `tipdocumento` varchar(1) NOT NULL,
  `fecentrada` date NOT NULL,
  `fecsalida` date DEFAULT NULL,
  `estdodocumento` varchar(1) NOT NULL,
  `id_ubicacion` varchar(20) NOT NULL,
  `descomentario` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `mert_bitacora`
--

INSERT INTO `mert_bitacora` (`id_documento`, `tipdocumento`, `fecentrada`, `fecsalida`, `estdodocumento`, `id_ubicacion`, `descomentario`) VALUES
('DOC001', 'F', '2017-02-06', NULL, 'P', 'A056D', 'Documento Increible'),
('DOC002', 'M', '2017-02-06', '2017-02-09', 'E', 'A056D', 'Documento perdido');

-- --------------------------------------------------------

--
-- Structure de la table `sst_usrios_sstma`
--

CREATE TABLE `sst_usrios_sstma` (
  `id_usrio` varchar(20) NOT NULL,
  `nmbre_usrio` varchar(50) NOT NULL,
  `cntrsnna` varchar(20) NOT NULL,
  `codemail` varchar(50) DEFAULT NULL,
  `codeidentification` varchar(20) DEFAULT NULL,
  `indactivo` varchar(1) NOT NULL,
  `fec_caducidad_usrio` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sst_usrios_sstma`
--

INSERT INTO `sst_usrios_sstma` (`id_usrio`, `nmbre_usrio`, `cntrsnna`, `codemail`, `codeidentification`, `indactivo`, `fec_caducidad_usrio`) VALUES
('A056D', 'Billy Smith', 'password1', 'billy.smith@gmail.com', 'A0001', 'S', '2017-02-14'),
('A057D', 'Arturo Ospina', 'password2', 'arturo.ospina@gmail.com', 'A0002', 'N', '2017-02-08'),
('A058D', 'Patrick Dupont', 'password3', 'patrick.dupont@gmail.com', 'A0003', 'S', '2017-02-14'),
('A059D', 'Chong Lee', 'Password 4', 'chong.lee@gmail.com', 'A0004', 'S', '2017-02-18'),
('A060D', 'Roberto Spaghetti', 'password5', 'roberto.spaghetti@gmail.com', 'A0005', 'S', '2017-02-25'),
('A061D', 'Pyotr Tchikoudinov', 'password6', 'pyotr@gmail.com', 'A0005', 'N', '2017-02-08');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `mert_bitacora`
--
ALTER TABLE `mert_bitacora`
  ADD PRIMARY KEY (`id_documento`),
  ADD KEY `fk_id_ubicacion` (`id_ubicacion`);

--
-- Index pour la table `sst_usrios_sstma`
--
ALTER TABLE `sst_usrios_sstma`
  ADD PRIMARY KEY (`id_usrio`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
