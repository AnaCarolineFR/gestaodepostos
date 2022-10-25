-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.5.4-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.6094
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para sgpc
CREATE DATABASE IF NOT EXISTS `sgpc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sgpc`;

-- Copiando estrutura para tabela sgpc.almoxarifados
CREATE TABLE IF NOT EXISTS `almoxarifados` (
  `idAlmoxarifado` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoAlmoxarifado` varchar(30) NOT NULL,
  `abrevAlmoxarifado` varchar(12) NOT NULL,
  PRIMARY KEY (`idAlmoxarifado`),
  UNIQUE KEY `descricaoAlmoxarifado` (`descricaoAlmoxarifado`),
  UNIQUE KEY `abrevAlmoxarifado` (`abrevAlmoxarifado`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COMMENT='Define a descrição e suas abreviações dos almoxarifados utilizados na empresa.';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.cargos
CREATE TABLE IF NOT EXISTS `cargos` (
  `idCargo` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoCargo` varchar(50) NOT NULL,
  `tipoCargo` varchar(13) NOT NULL,
  PRIMARY KEY (`idCargo`),
  UNIQUE KEY `descricaoCargo` (`descricaoCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Define a descrição e o tipo dos cargos dos colaboradores da empresa.';

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `codigoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCliente` varchar(2) NOT NULL,
  `nomeCliente` varchar(50) NOT NULL,
  `cnpjCliente` varchar(14) NOT NULL,
  `sexoCliente` varchar(1) DEFAULT NULL,
  `dtNascCliente` date DEFAULT NULL,
  `dtCadastroCliente` date NOT NULL,
  `dtAlteracaoCliente` date NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`codigoCliente`),
  UNIQUE KEY `cnpjCliente` (`cnpjCliente`),
  KEY `EMPRESAS_CODIGOEMPRESA_C_FK` (`codigoEmpresa`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_C_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.clientes_contatos
CREATE TABLE IF NOT EXISTS `clientes_contatos` (
  `idClienteContato` int(11) NOT NULL AUTO_INCREMENT,
  `tipoClienteContato` int(2) NOT NULL,
  `cctoClienteContato` varchar(20) DEFAULT NULL,
  `refClienteContato` varchar(11) NOT NULL,
  `contatoClienteContato` varchar(50) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  PRIMARY KEY (`idClienteContato`),
  KEY `CLIENTES_CODIGOCLIENTE_CC_FK` (`codigoCliente`),
  CONSTRAINT `CLIENTES_CODIGOCLIENTE_CC_FK` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigoCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.clientes_enderecos
CREATE TABLE IF NOT EXISTS `clientes_enderecos` (
  `idClienteEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `tipoClienteEndereco` varchar(2) NOT NULL,
  `logClienteEndereco` varchar(50) NOT NULL,
  `numClienteEndereco` varchar(8) NOT NULL,
  `complClienteEndereco` varchar(60) DEFAULT NULL,
  `bairroClienteEndereco` varchar(30) NOT NULL,
  `munClienteEndereco` varchar(30) NOT NULL,
  `ufClienteEndereco` varchar(2) NOT NULL,
  `cepClienteEndereco` varchar(9) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  PRIMARY KEY (`idClienteEndereco`),
  KEY `CLIENTES_CODIGOCLIENTE_CE_FK` (`codigoCliente`),
  CONSTRAINT `CLIENTES_CODIGOCLIENTE_CE_FK` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigoCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.combustivel_livros
CREATE TABLE IF NOT EXISTS `combustivel_livros` (
  `idCombustivelLivro` int(11) NOT NULL AUTO_INCREMENT,
  `tipoMovCombustivelLivro` varchar(2) NOT NULL,
  `docMovCombustivelLivro` int(11) NOT NULL,
  `dtMovCombustivelLivro` date NOT NULL,
  `qtdMovCombustivelLivro` float(8,6) NOT NULL,
  `codigoProduto` int(11) NOT NULL,
  `idCombustivelTanque` int(11) NOT NULL,
  PRIMARY KEY (`idCombustivelLivro`),
  KEY `PRODUTOS_CODIGOPRODUTO_CL_FK` (`codigoProduto`),
  KEY `COMBUSTIVEL_TANQUES_IDCOMBUSTIVELTANQUE_CL_FK` (`idCombustivelTanque`),
  CONSTRAINT `COMBUSTIVEL_TANQUES_IDCOMBUSTIVELTANQUE_CL_FK` FOREIGN KEY (`idCombustivelTanque`) REFERENCES `combustivel_tanques` (`idCombustivelTanque`),
  CONSTRAINT `PRODUTOS_CODIGOPRODUTO_CL_FK` FOREIGN KEY (`codigoProduto`) REFERENCES `produtos` (`codigoProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.combustivel_tanques
CREATE TABLE IF NOT EXISTS `combustivel_tanques` (
  `idCombustivelTanque` int(11) NOT NULL AUTO_INCREMENT,
  `dtCadCombustivelTanque` date NOT NULL,
  `dtValCombustivelTanque` date NOT NULL,
  `capMaxCombustivelTanque` float(8,6) DEFAULT NULL,
  `saldoCombustivelTanque` float(8,6) DEFAULT NULL,
  `codigoProduto` int(11) NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idCombustivelTanque`),
  KEY `PRODUTOS_CODIGOPRODUTO_CT_FK` (`codigoProduto`),
  KEY `EMPRESAS_CODIGOEMPRESA_CT_FK` (`codigoEmpresa`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_CT_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`),
  CONSTRAINT `PRODUTOS_CODIGOPRODUTO_CT_FK` FOREIGN KEY (`codigoProduto`) REFERENCES `produtos` (`codigoProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.condicoes
CREATE TABLE IF NOT EXISTS `condicoes` (
  `idCondicao` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoCondicao` varchar(50) NOT NULL,
  `qtdParcelasCondicao` int(11) NOT NULL,
  `tipoCondicao` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idCondicao`),
  UNIQUE KEY `descricaoCondicao` (`descricaoCondicao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.empresas
CREATE TABLE IF NOT EXISTS `empresas` (
  `codigoEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `razaoSocialEmpresa` varchar(80) NOT NULL,
  `nomeFantasiaEmpresa` varchar(50) NOT NULL,
  `cnpjEmpresa` varchar(14) NOT NULL,
  `ieEmpresa` varchar(12) NOT NULL,
  `imEmpresa` varchar(10) NOT NULL,
  `cnaeEmpresa` int(8) NOT NULL,
  `anpEmpresa` int(11) NOT NULL,
  `conamaEmpresa` int(11) NOT NULL,
  `avcbEmpresa` int(8) DEFAULT NULL,
  `ufAvcbEmpresa` varchar(2) DEFAULT NULL,
  `logradouroEmpresa` varchar(50) DEFAULT NULL,
  `numLogradouroEmpresa` char(8) DEFAULT NULL,
  `complLogradouroEmpresa` varchar(50) DEFAULT NULL,
  `bairroLogradouroEmpresa` varchar(30) DEFAULT NULL,
  `municipioLogradouroEmpresa` varchar(30) DEFAULT NULL,
  `ufLogradouroEmpresa` varchar(2) DEFAULT NULL,
  `cepLogradouroEmpresa` varchar(9) DEFAULT NULL,
  `dtValAvcbEmpresa` date DEFAULT NULL,
  `dtCadEmpresa` date NOT NULL,
  `dtAlteracaoEmpresa` date NOT NULL,
  PRIMARY KEY (`codigoEmpresa`),
  UNIQUE KEY `cnpjEmpresa` (`cnpjEmpresa`),
  UNIQUE KEY `anpEmpresa` (`anpEmpresa`),
  UNIQUE KEY `conamaEmpresa` (`conamaEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.estoques
CREATE TABLE IF NOT EXISTS `estoques` (
  `idEstoque` int(11) NOT NULL AUTO_INCREMENT,
  `saldoEstoque` float(8,6) NOT NULL,
  `dtCadEstoque` date NOT NULL,
  `dtAlteracaoEstoque` date NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  `codigoProduto` int(11) NOT NULL,
  `idAlmoxarifado` int(11) NOT NULL,
  PRIMARY KEY (`idEstoque`),
  KEY `ALMOXARIFADOS_IDALMOXARIFADO_E_FK` (`idAlmoxarifado`),
  KEY `PRODUTOS_CODIGOPRODUTO_E_FK` (`codigoProduto`),
  KEY `EMPRESAS_CODIGOEMPRESA_E_FK` (`codigoEmpresa`),
  CONSTRAINT `ALMOXARIFADOS_IDALMOXARIFADO_E_FK` FOREIGN KEY (`idAlmoxarifado`) REFERENCES `almoxarifados` (`idAlmoxarifado`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_E_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`),
  CONSTRAINT `PRODUTOS_CODIGOPRODUTO_E_FK` FOREIGN KEY (`codigoProduto`) REFERENCES `produtos` (`codigoProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.estoques_movimento
CREATE TABLE IF NOT EXISTS `estoques_movimento` (
  `idEstoqueMovimentacao` int(11) NOT NULL AUTO_INCREMENT,
  `tipoMovEstoqueMovimentacao` int(2) NOT NULL,
  `tipoDocEstoqueMovimentacao` varchar(11) NOT NULL,
  `numDocEstoqueMovimentacao` int(11) NOT NULL,
  `serieDocEstoqueMovimentacao` varchar(3) NOT NULL,
  `dtMovEstoqueMovimentacao` date NOT NULL,
  `obsEstoqueMovimentacao` varchar(30) DEFAULT NULL,
  `qtdEstoqueMovimentacao` float(8,3) NOT NULL,
  `codigoProduto` int(11) NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  `idEstoque` int(11) NOT NULL,
  PRIMARY KEY (`idEstoqueMovimentacao`),
  KEY `PRODUTOS_CODIGOPRODUTOS_EM_FK` (`codigoProduto`),
  KEY `EMPRESAS_CODIGOEMPRESA_EM_FK` (`codigoEmpresa`),
  KEY `ESTOQUES_IDESTOQUE_EM_FK` (`idEstoque`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_EM_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`),
  CONSTRAINT `ESTOQUES_IDESTOQUE_EM_FK` FOREIGN KEY (`idEstoque`) REFERENCES `estoques` (`idEstoque`),
  CONSTRAINT `PRODUTOS_CODIGOPRODUTOS_EM_FK` FOREIGN KEY (`codigoProduto`) REFERENCES `produtos` (`codigoProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.fornecedores
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `codigoFonecedor` int(11) NOT NULL AUTO_INCREMENT,
  `cnpjFornecedor` varchar(14) NOT NULL,
  `ieFornecedor` varchar(12) DEFAULT NULL,
  `imFornecedor` varchar(10) DEFAULT NULL,
  `razaoSocialFornecedor` varchar(80) NOT NULL,
  `nomeFantasiaFornecedor` varchar(50) NOT NULL,
  `obsFornecedor` varchar(100) DEFAULT NULL,
  `idFornecedorTipo` int(11) NOT NULL,
  PRIMARY KEY (`codigoFonecedor`),
  UNIQUE KEY `cnpjFornecedor` (`cnpjFornecedor`),
  UNIQUE KEY `razaoSocialFornecedor` (`razaoSocialFornecedor`),
  KEY `FORNECEDORES_TIPOS_IDFORNECEDORTIPO_F_FK` (`idFornecedorTipo`),
  CONSTRAINT `FORNECEDORES_TIPOS_IDFORNECEDORTIPO_F_FK` FOREIGN KEY (`idFornecedorTipo`) REFERENCES `fornecedores_tipos` (`idFornecedorTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.fornecedores_contatos
CREATE TABLE IF NOT EXISTS `fornecedores_contatos` (
  `idFornecedorContato` int(11) NOT NULL AUTO_INCREMENT,
  `tipoFornecedorContato` varchar(2) NOT NULL,
  `cctoFornecedorContato` varchar(20) DEFAULT NULL,
  `refFornecedorContato` varchar(11) NOT NULL,
  `contatoFornecedorContato` varchar(50) NOT NULL,
  `codigoFonecedor` int(11) NOT NULL,
  PRIMARY KEY (`idFornecedorContato`),
  KEY `FORNECEDORES_CODIGOFORNECEDOR_FC_FK` (`codigoFonecedor`),
  CONSTRAINT `FORNECEDORES_CODIGOFORNECEDOR_FC_FK` FOREIGN KEY (`codigoFonecedor`) REFERENCES `fornecedores` (`codigoFonecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.fornecedores_enderecos
CREATE TABLE IF NOT EXISTS `fornecedores_enderecos` (
  `idFornecedorEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `tipoFornecedorEndereco` varchar(2) NOT NULL,
  `logFornecedorEndereco` varchar(50) NOT NULL,
  `numFornecedorEndereco` varchar(8) NOT NULL,
  `complFornecedorEndereco` varchar(60) DEFAULT NULL,
  `bairroFornecedorEndereco` varchar(30) NOT NULL,
  `munFornecedorEndereco` varchar(30) NOT NULL,
  `ufFornecedorEndereco` varchar(2) NOT NULL,
  `cepFornecedorEndereco` varchar(9) NOT NULL,
  `codigoFonecedor` int(11) NOT NULL,
  PRIMARY KEY (`idFornecedorEndereco`),
  KEY `FORNECEDOR_CODIGOFORNECEDOR_FE_FK` (`codigoFonecedor`),
  CONSTRAINT `FORNECEDOR_CODIGOFORNECEDOR_FE_FK` FOREIGN KEY (`codigoFonecedor`) REFERENCES `fornecedores` (`codigoFonecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.fornecedores_tipos
CREATE TABLE IF NOT EXISTS `fornecedores_tipos` (
  `idFornecedorTipo` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoFornecedorTipo` varchar(50) NOT NULL,
  `abrevFornecedorTipo` varchar(5) NOT NULL,
  PRIMARY KEY (`idFornecedorTipo`),
  UNIQUE KEY `descricaoFornecedorTipo` (`descricaoFornecedorTipo`),
  UNIQUE KEY `abrevFornecedorTipo` (`abrevFornecedorTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.naturezaoperacao
CREATE TABLE IF NOT EXISTS `naturezaoperacao` (
  `idNaturezaOperacao` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoNaturezaOperacao` varchar(50) NOT NULL,
  PRIMARY KEY (`idNaturezaOperacao`),
  UNIQUE KEY `descricaoNaturezaOperacao` (`descricaoNaturezaOperacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.notaentrada
CREATE TABLE IF NOT EXISTS `notaentrada` (
  `idNotaEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `numNotaEntrada` int(11) NOT NULL,
  `serieNotaEntrada` varchar(3) NOT NULL,
  `dtCadNotaEntrada` date NOT NULL,
  `dtAlteracaoNotaEntrada` date NOT NULL,
  `dtEmissaoNotaEntrada` date NOT NULL,
  `dtRecebimentoNotaEntrada` date NOT NULL,
  `bcICMSNotaEntrada` float(4,2) DEFAULT NULL,
  `vlrICMSNotaEntrada` float(8,2) DEFAULT NULL,
  `bcICMSSTNotaEntrada` float(4,2) DEFAULT NULL,
  `vlrICMSSTNotaEntrada` float(8,2) DEFAULT NULL,
  `bcIPINotaEntrada` float(4,2) DEFAULT NULL,
  `vlrIPINotaEntrada` float(8,2) DEFAULT NULL,
  `vlrINSSNotaEntrada` float(8,2) DEFAULT NULL,
  `vlrIRRFNotaEntrada` float(8,2) DEFAULT NULL,
  `vlrISSNotaEntrada` float(8,2) DEFAULT NULL,
  `vlrPISNotaEntrada` float(8,2) DEFAULT NULL,
  `vlrCOFINSNotaEntrada` float(8,2) DEFAULT NULL,
  `odaNotaEntrada` float(8,2) DEFAULT NULL,
  `chaveNotaEntrada` varchar(42) DEFAULT NULL,
  `idNaturezaOperacao` int(11) NOT NULL,
  `codigoFonecedor` int(11) NOT NULL,
  PRIMARY KEY (`idNotaEntrada`),
  UNIQUE KEY `chaveNotaEntrada` (`chaveNotaEntrada`),
  KEY `NATUREZAOPERACAO_IDNATUREZAOPERACAO_NE_FK` (`idNaturezaOperacao`),
  KEY `FORNECEDORES_CODIGOFORNECEDOR_NE_FK` (`codigoFonecedor`),
  CONSTRAINT `FORNECEDORES_CODIGOFORNECEDOR_NE_FK` FOREIGN KEY (`codigoFonecedor`) REFERENCES `fornecedores` (`codigoFonecedor`),
  CONSTRAINT `NATUREZAOPERACAO_IDNATUREZAOPERACAO_NE_FK` FOREIGN KEY (`idNaturezaOperacao`) REFERENCES `naturezaoperacao` (`idNaturezaOperacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.notaentrada_itens
CREATE TABLE IF NOT EXISTS `notaentrada_itens` (
  `idNotaEntradaItem` int(11) NOT NULL AUTO_INCREMENT,
  `codigoProduto` int(11) NOT NULL,
  `ncmNotaEntradaItem` int(8) DEFAULT NULL,
  `cstNotaEntradaItem` int(3) DEFAULT NULL,
  `cfopNotaEntradaItem` int(6) DEFAULT NULL,
  `qtdNotaEntradaItem` float(8,6) NOT NULL,
  `vlrUnitNotaEntradaItem` float(8,2) NOT NULL,
  `vlrTotalNotaEntradaItem` float(8,2) NOT NULL,
  `bcICMSNotaEntradaItem` float(4,2) NOT NULL,
  `vlrICMSNotaEntradaItem` float(8,2) NOT NULL,
  `vlrIPINotaEntradaItem` float(8,2) NOT NULL,
  `aliqIPINotaEntradaItem` float(4,2) DEFAULT NULL,
  `aliqICMSNotaEntradaItem` float(4,2) DEFAULT NULL,
  `idNotaEntrada` int(11) NOT NULL,
  `idUnidade` int(11) NOT NULL,
  PRIMARY KEY (`idNotaEntradaItem`),
  KEY `NOTAENTRADA_IDNOTAENTRADA_NEI_FK` (`idNotaEntrada`),
  KEY `UNIDADES_IDUNIDADE_NEI_FK` (`idUnidade`),
  CONSTRAINT `NOTAENTRADA_IDNOTAENTRADA_NEI_FK` FOREIGN KEY (`idNotaEntrada`) REFERENCES `notaentrada` (`idNotaEntrada`),
  CONSTRAINT `UNIDADES_IDUNIDADE_NEI_FK` FOREIGN KEY (`idUnidade`) REFERENCES `unidades` (`idUnidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.notasaida
CREATE TABLE IF NOT EXISTS `notasaida` (
  `idNotaSaida` int(11) NOT NULL AUTO_INCREMENT,
  `numNotaSaida` int(11) NOT NULL,
  `serieNotaSaida` varchar(2) NOT NULL,
  `dtEmissaoNotaSaida` date NOT NULL,
  `pesoLiqNotaSaida` float(4,3) DEFAULT NULL,
  `pesoBruNotaSaida` float(4,3) DEFAULT NULL,
  `bcICMSNotaSaida` float(4,2) DEFAULT NULL,
  `vlrICMSNotaSaida` float(4,2) DEFAULT NULL,
  `bcICMSSTNotaSida` float(4,2) DEFAULT NULL,
  `vlrICMSSubNotaSaida` float(8,2) DEFAULT NULL,
  `vlrTotalProdNotaSaida` float(8,2) DEFAULT NULL,
  `vlrFreteNotaSaida` float(8,2) DEFAULT NULL,
  `vlrSeguroNotaSaida` float(8,2) DEFAULT NULL,
  `vlrDescNotaSaida` float(8,2) DEFAULT NULL,
  `vlrODANotaSaida` float(8,2) DEFAULT NULL,
  `vlrTotalIPINotaSaida` float(8,2) DEFAULT NULL,
  `vlrTotalNotaSaida` float(8,2) DEFAULT NULL,
  `tipoFrete` int(11) NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  `codigoCliente` int(11) NOT NULL,
  `codigoFornecedor` int(11) NOT NULL,
  `idNaturezaOperacao` int(11) NOT NULL,
  PRIMARY KEY (`idNotaSaida`),
  UNIQUE KEY `numNotaSaida` (`numNotaSaida`),
  KEY `EMPRESAS_CODIGOEMPRESA_NS_FK` (`codigoEmpresa`),
  KEY `CLIENTES_CODIGOCLIENTE_NS_FK` (`codigoCliente`),
  KEY `FORNECEDORES_CODIGOFORNECEDOR_NS_FK` (`codigoFornecedor`),
  KEY `NATUREZAOPERACAO_IDNATUREZAOPERACAO_NS_FK` (`idNaturezaOperacao`),
  CONSTRAINT `CLIENTES_CODIGOCLIENTE_NS_FK` FOREIGN KEY (`codigoCliente`) REFERENCES `clientes` (`codigoCliente`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_NS_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`),
  CONSTRAINT `FORNECEDORES_CODIGOFORNECEDOR_NS_FK` FOREIGN KEY (`codigoFornecedor`) REFERENCES `fornecedores` (`codigoFonecedor`),
  CONSTRAINT `NATUREZAOPERACAO_IDNATUREZAOPERACAO_NS_FK` FOREIGN KEY (`idNaturezaOperacao`) REFERENCES `naturezaoperacao` (`idNaturezaOperacao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.notasaida_itens
CREATE TABLE IF NOT EXISTS `notasaida_itens` (
  `idNotaSaidaItem` int(11) NOT NULL AUTO_INCREMENT,
  `qtdNotaSaidaItem` float(8,6) DEFAULT NULL,
  `vlrUnitNotaSaidaItem` float(8,4) DEFAULT NULL,
  `vlrTotalNotaSaidaItem` float(8,4) DEFAULT NULL,
  `dtCadNotaSaidaItem` date NOT NULL,
  `codigoProduto` int(11) NOT NULL,
  `idNotaSaida` int(11) NOT NULL,
  PRIMARY KEY (`idNotaSaidaItem`),
  KEY `NOTASAIDA_IDNOTASAIDA_NSI_FK` (`idNotaSaida`),
  KEY `PRODUTOS_CODIGOPRODUTO_NSI_FK` (`codigoProduto`),
  CONSTRAINT `NOTASAIDA_IDNOTASAIDA_NSI_FK` FOREIGN KEY (`idNotaSaida`) REFERENCES `notasaida` (`idNotaSaida`),
  CONSTRAINT `PRODUTOS_CODIGOPRODUTO_NSI_FK` FOREIGN KEY (`codigoProduto`) REFERENCES `produtos` (`codigoProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.produtos
CREATE TABLE IF NOT EXISTS `produtos` (
  `codigoProduto` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoProduto` varchar(80) NOT NULL,
  `gtinProduto` bigint(20) DEFAULT NULL,
  `ncmProduto` int(13) DEFAULT NULL,
  `pesoLiqProduto` float(4,3) DEFAULT NULL,
  `pesoBruProduto` float(4,3) DEFAULT NULL,
  `qtdMinProduto` float(8,6) DEFAULT NULL,
  `qtdMaxProduto` float(8,6) DEFAULT NULL,
  `idUnidade` int(11) NOT NULL,
  PRIMARY KEY (`codigoProduto`),
  UNIQUE KEY `descricaoProduto` (`descricaoProduto`),
  KEY `UNIDADES_IDUNIDADES_P_FK` (`idUnidade`),
  CONSTRAINT `UNIDADES_IDUNIDADES_P_FK` FOREIGN KEY (`idUnidade`) REFERENCES `unidades` (`idUnidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.tipocobranca
CREATE TABLE IF NOT EXISTS `tipocobranca` (
  `idTipoCobranca` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoTipoCobranca` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idTipoCobranca`),
  UNIQUE KEY `descricaoTipoCobranca` (`descricaoTipoCobranca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.titulopagar_parcelas
CREATE TABLE IF NOT EXISTS `titulopagar_parcelas` (
  `idTituloPagarParcela` int(11) NOT NULL AUTO_INCREMENT,
  `sitTituloPagarParcela` varchar(1) NOT NULL,
  `numTituloPagarParcela` int(11) NOT NULL,
  `vlrTituloPagarParcela` float(8,2) NOT NULL,
  `dtVencTituloPagarParcela` date NOT NULL,
  `dtPagTituloPagarParcela` date NOT NULL,
  `vlrPagTituloPagarParcela` float(8,2) NOT NULL,
  `idTituloPagar` int(11) NOT NULL,
  PRIMARY KEY (`idTituloPagarParcela`),
  KEY `TITULOPAGAR_IDTITULOPAGAR_TPP_FK` (`idTituloPagar`),
  CONSTRAINT `TITULOPAGAR_IDTITULOPAGAR_TPP_FK` FOREIGN KEY (`idTituloPagar`) REFERENCES `titulospagar` (`idTituloPagar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.tituloreceber_parcelas
CREATE TABLE IF NOT EXISTS `tituloreceber_parcelas` (
  `idTituloReceberParcela` int(11) NOT NULL AUTO_INCREMENT,
  `sitTiTUloReceberParcela` varchar(1) NOT NULL,
  `numTituloReceberParcela` int(11) NOT NULL,
  `vlrTituloReceberParcela` float(8,2) NOT NULL,
  `dtVencTituloReceberParcela` date NOT NULL,
  `dtPagTituloReceberParcela` date NOT NULL,
  `vlrPagTituloReceberParcela` float(8,2) NOT NULL,
  `idTituloReceber` int(11) NOT NULL,
  PRIMARY KEY (`idTituloReceberParcela`),
  KEY `TITULORECEBER_IDTITULORECEBER_TRP_FK` (`idTituloReceber`),
  CONSTRAINT `TITULORECEBER_IDTITULORECEBER_TRP_FK` FOREIGN KEY (`idTituloReceber`) REFERENCES `titulosreceber` (`idTituloReceber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.titulospagar
CREATE TABLE IF NOT EXISTS `titulospagar` (
  `idTituloPagar` int(11) NOT NULL AUTO_INCREMENT,
  `sitTituloPagar` varchar(1) NOT NULL,
  `vlrTotalTituloPagar` float(8,2) NOT NULL,
  `dtCadTituloPagar` date NOT NULL,
  `dtAlteracaoTituloPagar` date NOT NULL,
  `dtEmissaoTituloPagar` date NOT NULL,
  `saldoTituloPagar` float(8,2) NOT NULL,
  `idNotaEntrada` int(11) NOT NULL,
  `idTituloTipo` int(11) NOT NULL,
  `idCondicao` int(11) NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idTituloPagar`),
  KEY `CONDICOES_IDCONDICAO_TP_FK` (`idCondicao`),
  KEY `NOTAENTRADA_IDNOTAENTRADA_TP_FK` (`idNotaEntrada`),
  KEY `TITULOS_TIPOS_IDTITULOTIPO_TP_FK` (`idTituloTipo`),
  KEY `EMPRESA_CODIGOEMPRESA_TP_FK` (`codigoEmpresa`),
  CONSTRAINT `CONDICOES_IDCONDICAO_TP_FK` FOREIGN KEY (`idCondicao`) REFERENCES `condicoes` (`idCondicao`),
  CONSTRAINT `EMPRESA_CODIGOEMPRESA_TP_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`),
  CONSTRAINT `NOTAENTRADA_IDNOTAENTRADA_TP_FK` FOREIGN KEY (`idNotaEntrada`) REFERENCES `notaentrada` (`idNotaEntrada`),
  CONSTRAINT `TITULOS_TIPOS_IDTITULOTIPO_TP_FK` FOREIGN KEY (`idTituloTipo`) REFERENCES `titulos_tipos` (`idTituloTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.titulosreceber
CREATE TABLE IF NOT EXISTS `titulosreceber` (
  `idTituloReceber` int(11) NOT NULL AUTO_INCREMENT,
  `sitTituloReceber` varchar(1) NOT NULL,
  `dtEmissaoTituloReceber` date NOT NULL,
  `vlrTotalTituloReceber` float(8,2) NOT NULL,
  `saldoTituloReceber` float(8,2) NOT NULL,
  `idNotaSaida` int(11) NOT NULL,
  `idTipoCobranca` int(11) NOT NULL,
  `idCondicao` int(11) NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idTituloReceber`),
  KEY `CONDICOES_IDCONDICAO_TR_FK` (`idCondicao`),
  KEY `NOTASAIDA_IDNOTASAIDA_TR_FK` (`idNotaSaida`),
  KEY `TIPOCOBRANCA_IDTIPOCOBRANCA_TR_FK` (`idTipoCobranca`),
  KEY `EMPRESAS_CODIGOEMPRESA_TR_FK` (`codigoEmpresa`),
  CONSTRAINT `CONDICOES_IDCONDICAO_TR_FK` FOREIGN KEY (`idCondicao`) REFERENCES `condicoes` (`idCondicao`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_TR_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`),
  CONSTRAINT `NOTASAIDA_IDNOTASAIDA_TR_FK` FOREIGN KEY (`idNotaSaida`) REFERENCES `notasaida` (`idNotaSaida`),
  CONSTRAINT `TIPOCOBRANCA_IDTIPOCOBRANCA_TR_FK` FOREIGN KEY (`idTipoCobranca`) REFERENCES `tipocobranca` (`idTipoCobranca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.titulos_tipos
CREATE TABLE IF NOT EXISTS `titulos_tipos` (
  `idTituloTipo` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoTituloPagarTipo` varchar(30) NOT NULL,
  `tipoTitulo` varchar(1) NOT NULL,
  PRIMARY KEY (`idTituloTipo`),
  UNIQUE KEY `descricaoTituloPagarTipo` (`descricaoTituloPagarTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.turnos
CREATE TABLE IF NOT EXISTS `turnos` (
  `idTurno` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoTurno` varchar(20) NOT NULL,
  `inicioTurno` time NOT NULL,
  `finalTurno` time NOT NULL,
  `dtCadTurno` date NOT NULL,
  `dtAlteracaoTurno` date NOT NULL,
  PRIMARY KEY (`idTurno`),
  UNIQUE KEY `descricaoTurno` (`descricaoTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.unidades
CREATE TABLE IF NOT EXISTS `unidades` (
  `idUnidade` int(11) NOT NULL AUTO_INCREMENT,
  `descricaoUnidade` varchar(10) NOT NULL,
  `abrevUnidade` varchar(3) NOT NULL,
  PRIMARY KEY (`idUnidade`),
  UNIQUE KEY `descricaoUnidade` (`descricaoUnidade`),
  UNIQUE KEY `abrevUnidade` (`abrevUnidade`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `codigoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUsuario` varchar(50) NOT NULL,
  `rgUsuario` varchar(13) NOT NULL,
  `cpfUsuario` varchar(14) NOT NULL,
  `apelidoUsuario` varchar(14) NOT NULL,
  `senhaUsuario` varchar(14) NOT NULL,
  `codigoEmpresa` int(11) NOT NULL,
  `idCargo` int(11) NOT NULL,
  PRIMARY KEY (`codigoUsuario`),
  UNIQUE KEY `rgUsuario` (`rgUsuario`),
  UNIQUE KEY `cpfUsuario` (`cpfUsuario`),
  UNIQUE KEY `apelidoUsuario` (`apelidoUsuario`),
  KEY `CARGOS_IDCARGO_USU_FK` (`idCargo`),
  KEY `EMPRESAS_CODIGOEMPRESA_USU_FK` (`codigoEmpresa`),
  CONSTRAINT `CARGOS_IDCARGO_USU_FK` FOREIGN KEY (`idCargo`) REFERENCES `cargos` (`idCargo`),
  CONSTRAINT `EMPRESAS_CODIGOEMPRESA_USU_FK` FOREIGN KEY (`codigoEmpresa`) REFERENCES `empresas` (`codigoEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela sgpc.usuarios_turnos
CREATE TABLE IF NOT EXISTS `usuarios_turnos` (
  `idUsuarioTurno` int(11) NOT NULL AUTO_INCREMENT,
  `codigoUsuario` int(11) NOT NULL,
  `idTurno` int(11) NOT NULL,
  PRIMARY KEY (`idUsuarioTurno`),
  KEY `TURNOS_IDTURNO_UT_FK` (`idTurno`),
  KEY `USUARIOS_CODIGOUSUARIO_UT_FK` (`codigoUsuario`),
  CONSTRAINT `TURNOS_IDTURNO_UT_FK` FOREIGN KEY (`idTurno`) REFERENCES `turnos` (`idTurno`),
  CONSTRAINT `USUARIOS_CODIGOUSUARIO_UT_FK` FOREIGN KEY (`codigoUsuario`) REFERENCES `usuarios` (`codigoUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
