#!/usr/bin/env bash

set -euo pipefail

docker exec -it mysql-jdbcproc \
    bash -c "/root/jdbc-proc/jdbc-proc-integration-test/docker/_run_tests.sh"
