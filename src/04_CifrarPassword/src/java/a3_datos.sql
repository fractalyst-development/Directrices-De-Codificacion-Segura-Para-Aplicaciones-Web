CREATE TABLE `websec19`.`a3_datos` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreusuario` varchar(45) DEFAULT NULL,
  `contrasenha` varchar(500) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido_paterno` varchar(45) DEFAULT NULL,
  `apellido_materno` varchar(45) DEFAULT NULL,
  `pregunta_secreta` varchar(300) DEFAULT NULL,
  `respuesta_secreta` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `websec19`.`a3_datos` (`id_usuario`, `nombreusuario`, `contrasenha`, `nombre`, `apellido_paterno`, `apellido_materno`, `pregunta_secreta`, `respuesta_secreta`) VALUES ('1', '1', '1', '1', '1', '1', '1', '1');

