	create database ageexamejava;
	use ageexamejava;

  create table paciente(
	idpaciente int IDENTITY(1,1) not null,
	nmpaciente varchar(50) not null UNIQUE,
	CONSTRAINT PK_Paciente PRIMARY KEY (idpaciente)
  );

  create table examepaciente(
	idexamepaciente int IDENTITY(1,1) not null,
	idpaciente int not null,
	nmexame varchar(50) not null,
	dtexame datetime not null,
	observacaoexame varchar(255) null,
	resultadoexame varchar(255) null,
	CONSTRAINT PK_ExamePaciente PRIMARY KEY (idexamepaciente),
	FOREIGN KEY (idpaciente) REFERENCES paciente(idpaciente)
  );