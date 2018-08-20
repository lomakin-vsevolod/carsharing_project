-- USER SQL
CREATE USER carsharing IDENTIFIED BY "qwerty"  ;

-- QUOTAS

-- ROLES
GRANT "DBA" TO carsharing ;
GRANT "CONNECT" TO carsharing ;
GRANT "RESOURCE" TO carsharing ;

-- SYSTEM PRIVILEGES