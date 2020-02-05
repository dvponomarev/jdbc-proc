#!/usr/bin/env bash

set -euxo pipefail

cd ../../
mvn clean install
cd jdbc-proc-integration-test/docker
