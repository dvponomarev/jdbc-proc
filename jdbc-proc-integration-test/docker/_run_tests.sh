#!/usr/bin/env bash

set -euxo pipefail

mysql -u root -proot </root/jdbc-proc/jdbc-proc-integration-test/src/test/resources/sql_mysql/create_database.sql
mysql -u root -proot </root/jdbc-proc/jdbc-proc-integration-test/src/test/resources/sql_mysql/create_users.sql

cd /root/jdbc-proc/jdbc-proc-integration-test

mvn -Pintegration-test test
#mvn -Pintegration-test -Dtest=ProductDaoTest test
