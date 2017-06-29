
Create tablespace REDESOCIALDAT 
 datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\redesocialdat.dbf' 
 size 100m 
 autoextend on 
 next 100m 
 maxsize 2048m;

Create user REDESOCIAL identified by REDESOCIAL default tablespace REDESOCIALDAT;
grant connect, resource, create view to REDESOCIAL;

