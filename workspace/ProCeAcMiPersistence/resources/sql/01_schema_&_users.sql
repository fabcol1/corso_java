create database proceacmi_stage;
GRANT ALL PRIVILEGES ON proceacmi_stage.* TO 'proceacmi_stage'@'%' IDENTIFIED BY 'proceacmi_stage123' WITH GRANT OPTION;
FLUSH PRIVILEGES;

create database proceacmi_test;
GRANT ALL PRIVILEGES ON proceacmi_test.* TO 'proceacmi_test'@'%' IDENTIFIED BY 'proceacmi_test' WITH GRANT OPTION;
FLUSH PRIVILEGES;