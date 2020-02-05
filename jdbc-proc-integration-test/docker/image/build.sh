#!/usr/bin/env bash

set -euxo pipefail

docker build -t jdbcproc/mariadb10.1_mvn3_openjdk8 .
