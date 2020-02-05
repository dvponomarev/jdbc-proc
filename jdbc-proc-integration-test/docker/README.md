# Run mariadb integration tests in Docker

## Build docker image (required only once)
```shell script
cd jdbc-proc-integration-test/docker/image
./build.sh
```

## Build project
```shell script
cd ../
./build-project.sh
```

## Start local maria
```shell script
./start-maria-docker.sh
```

## Run tests
While local maria is running you can run integration tests:
```shell script
./maria-docker-int-tests.sh
```
Edit `_run_tests.sh` to control which tests you will run.

## Stop local maria
```shell script
docker kill mysql-jdbcproc
```
