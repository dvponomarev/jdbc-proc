#!/usr/bin/env bash

set -euo pipefail

docker run --name=mysql-jdbcproc \
    --rm \
    -e TZ="Europe/Moscow" \
    -e MYSQL_ROOT_PASSWORD="root" \
    -v "$(pwd)"/../../:/root/jdbc-proc/ \
    -v ~/.m2/repository/:/root/.m2/repository/:ro \
    --entrypoint="" \
    jdbcproc/mariadb10.1_mvn3_openjdk8 \
    bash -c "/docker-entrypoint.sh mysqld"
