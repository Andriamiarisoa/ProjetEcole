create database ecole;
alter database ecole owner to postgres;


create table Eleve(
	id serial primary key,
	nom varchar(255),
	prenom varchar(255),
	dateNaissance date
);

create table Classe(
	id serial primary key,
	niveau varchar(255)
);

create table EleveClasse(
	id serial primary key,
	idEleve int,
	idClasse int,
	anneeScolaireDebut int,
	anneeScolaireFin int,
	FOREIGN KEY(idEleve) REFERENCES Eleve(id),
	FOREIGN KEY(idClasse) REFERENCES Classe(id)
);

create table Matiere(
	id serial primary key,
	nom varchar(255)
);

create table Prof(
	id serial primary key,
	nom varchar(255),
	prenom varchar(255)
);

create table LoginProf(
	idProf serial,
	idMatiere int,
	mdp varchar(255),
	FOREIGN KEY(idProf) REFERENCES Prof(id),
	FOREIGN KEY(idMatiere) REFERENCES Matiere(id)
);

create table Note(
	id serial primary key,
	nom varchar(255),
	coef int,
	note double precision,
	daty date,
	idMatiere int,
	idEleve int,
	FOREIGN KEY(idMatiere) REFERENCES Matiere(id),
	FOREIGN KEY(idEleve) REFERENCES Eleve(id)
);


insert into Eleve values(default,'Rakoto','manana','2001-01-07'),
						(default,'Lorne','Landyn','2001-03-17'),
						(default,'Darren','Sylvia','2001-06-14'),
						(default,'Geneva','Avaline','2001-06-14'),
						(default,'Sefton','jaydon','2001-06-14'),
						(default,'jaylee','Charissa','2001-06-14');

insert into Classe values(default,'6eme'),
						 (default,'7eme');

insert into EleveClasse values(default,'1','1','2021','2022'),
							  (default,'2','1','2021','2022'),
							  (default,'3','1','2021','2022'),
							  (default,'4','2','2021','2022'),
							  (default,'5','2','2021','2022'),
							  (default,'6','2','2021','2022');

insert into Matiere values(default,'MT'),
							(default,'FRS');

insert into Prof values(default,'Alphonso','Oaklyn'),
						(default,'Valary','Imogen');

insert into LoginProf values('1','1','prmt'),
						('2','2','prfrs');

insert into Note values(default,'Exam','6','14','2021-11-14','1','1'),
					   (default,'Exam','4','12','2021-11-14','2','1'),
					   (default,'Exam','6','17','2021-11-14','1','2'),
					   (default,'Exam','4','8','2021-11-14','2','2'),
					   (default,'Exam','6','10','2021-11-14','1','3'),
					   (default,'Exam','4','12','2021-11-14','2','3'),
					   (default,'Exam','6','14','2021-11-14','1','4'),
					   (default,'Exam','4','12','2021-11-14','2','4'),
					   (default,'Exam','6','17','2021-11-14','1','5'),
					   (default,'Exam','4','8','2021-11-14','2','5'),
					   (default,'Exam','6','10','2021-11-14','1','6'),
					   (default,'Exam','4','12','2021-11-14','2','6');