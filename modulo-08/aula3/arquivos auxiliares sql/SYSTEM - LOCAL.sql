
Create tablespace AULAJAVADAT 
 datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\aulajavadat.dbf' 
 size 100m 
 autoextend on 
 next 100m 
 maxsize 2048m;

Create user AULAJAVA identified by AULAJAVA default tablespace AULAJAVADAT;
grant connect, resource, create view to AULAJAVA;

