# gRPC Java Database Client Accessing

## Build
- Use IntelliJ IDEA CE
- build maven (proto and other pkgs)
- run package at maven

## Usage
- <a href="https://github.com/mtvy/grpc_database_accessorzz"> Run backend accessor </a> (run manually or in a docker container)
- Add this module into your project
  ```bash
  git submodule add https://github.com/mtvy/grpc_java_database_accessing.git
  ```
- Import module like:
  ```java
  import java_client.src.main.java.database_client.Client
  ```

## Test Case

https://github.com/mtvy/grpc_java_database_accessing/blob/180c13f92e27e0ad5dc8acf64817ba2c522514ff/src/test/java/database_client/ClientTest.java#L18-L34

```bash
INSERTING {url: 'Hello', name: 'World'} into [qrcodes_tb]
status: "ok"

GETTING from [qrcodes_tb] "WHERE url='Hello'"
status: "ok"
data: "[[23437,\"Hello\",null,null,\"World\",null,null,null,null],[23438,\"Hello\",null,null,\"World\",null,null,null,null]]"

GETTING from [qrcodes_tb] "WHERE url='Hello'"
status: "ok"
```
