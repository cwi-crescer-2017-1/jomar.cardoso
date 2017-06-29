CREATE TABLE Usuario (
  Id                INTEGER NOT NULL,
  Email             VARCHAR2(100) NOT NULL,
  Nome              VARCHAR2(100),
  Sexo              CHAR(1),
  DatadeNascimento  DATE,
  Senha             VARCHAR2(255) NOT NULL,
  CONSTRAINT PK_Usuario PRIMARY KEY (Id)  
);

CREATE TABLE Post (
  Id                INTEGER NOT NULL,
  IdUsuario         INTEGER NOT NULL,
  Mensagem          VARCHAR2(1000),
  DataPublicacao    DATE,
  CONSTRAINT PK_Post PRIMARY KEY (Id),
  CONSTRAINT FK_Post_Usuario FOREIGN KEY (IdUsuario) REFERENCES Usuario(Id)  
);

CREATE TABLE Comentario (
  Id                INTEGER NOT NULL,
  IdPost            INTEGER NOT NULL,
  IdUsuario         INTEGER NOT NULL,
  Mensagem          VARCHAR2(1000),
  DataComentario    DATE,
  CONSTRAINT PK_Comentario PRIMARY KEY (Id),
  CONSTRAINT FK_Comentario_Usuario FOREIGN KEY (IdUsuario) REFERENCES Usuario(Id),
  CONSTRAINT FK_Comentario_Post FOREIGN KEY (IdPost) REFERENCES Post(Id)  
);

CREATE TABLE Gostei (
  Id                INTEGER NOT NULL, 
  IdPost            INTEGER NOT NULL,
  IdUsuario         INTEGER NOT NULL,
  CONSTRAINT PK_Gostei PRIMARY KEY (Id),
  CONSTRAINT FK_Goste_Usuario FOREIGN KEY (IdUsuario) REFERENCES Usuario(Id),
  CONSTRAINT FK_Gostei_Post FOREIGN KEY (IdPost) REFERENCES Post(Id) 
);

CREATE TABLE Amizade (
  Id                INTEGER NOT NULL, 
  IdUsuario         INTEGER NOT NULL,
  IdAmigo           INTEGER NOT NULL,
  CONSTRAINT PK_Amizade PRIMARY KEY (Id),
  CONSTRAINT FK_Amizade_Usuario FOREIGN KEY (IdUsuario) REFERENCES Usuario(Id),
  CONSTRAINT FK_Amizade_Amigo FOREIGN KEY (IdAmigo) REFERENCES Usuario(Id) 
);

CREATE TABLE SolicitacaoAmizade (
  Id                INTEGER NOT NULL, 
  IdSolicitante     INTEGER NOT NULL,
  IdSolicitado      INTEGER NOT NULL,
  CONSTRAINT PK_Solicitacao PRIMARY KEY (Id),
  CONSTRAINT FK_Solicitacao_Solicitante FOREIGN KEY (IdSolicitante) REFERENCES Usuario(Id),
  CONSTRAINT FK_Solicitacao_Solicitado FOREIGN KEY (IdSolicitado) REFERENCES Usuario(Id) 
);

CREATE SEQUENCE sq_Amizade;
CREATE SEQUENCE sq_Comentario;
CREATE SEQUENCE sq_Gostei;
CREATE SEQUENCE sq_Post;
CREATE SEQUENCE sq_SolicitacaoAmizade;
CREATE SEQUENCE sq_Usuario;

create or replace trigger TR_SQ_Amizade 
    before insert on Amizade 
    for each row
    when (new.Id is null)
Begin 
    Select     sq_Amizade.nextval
    into       :new.Id
    from       Dual;    
End TR_SQ_Amizade; 

create or replace trigger TR_SQ_Comentario 
    before insert on Comentario 
    for each row
    when (new.Id is null)
Begin 
    Select     sq_Comentario.nextval
    into       :new.Id
    from       Dual;    
End TR_SQ_Comentario;

create or replace trigger TR_SQ_Gostei 
    before insert on Gostei 
    for each row
    when (new.Id is null)
Begin 
    Select     sq_Gostei.nextval
    into       :new.Id
    from       Dual;    
End TR_SQ_Gostei; 

create or replace trigger TR_SQ_Post 
    before insert on Post 
    for each row
    when (new.Id is null)
Begin 
    Select     sq_Post.nextval
    into       :new.Id
    from       Dual;    
End TR_SQ_Post; 

create or replace trigger TR_SQ_SolicitacaoAmizade 
    before insert on SolicitacaoAmizade 
    for each row
    when (new.Id is null)
Begin 
    Select     sq_SolicitacaoAmizade.nextval
    into       :new.Id
    from       Dual;    
End TR_SQ_SolicitacaoAmizade; 

create or replace trigger TR_SQ_Usuario
    before insert on Usuario 
    for each row
    when (new.Id is null)
Begin 
    Select     sq_Usuario.nextval
    into       :new.Id
    from       Dual;    
End TR_SQ_Usuario; 

DROP TABLE AMIZADE;
DROP TABLE COMENTARIO;
DROP TABLE GOSTEI;
DROP TABLE POST;
DROP TABLE SOLICITACAOAMIZADE;
DROP TABLE USUARIO;
