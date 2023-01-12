package database_client;

import api.DatabaseGrpc;
import api.DatabaseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;

public class Client {
    String host = "0.0.0.0:8080";

    public Client(String host) {
        this.host = host;
    }

    public ManagedChannel getChan() {
        return ManagedChannelBuilder.forTarget(this.host).usePlaintext().build();
    }

    public DatabaseGrpc.DatabaseBlockingStub getConn(ManagedChannel channel) {
        return DatabaseGrpc.newBlockingStub(channel);
    }

    public DatabaseOuterClass.GetDbResponse getDb(String columns, String table, String condition, String db_host) {
        ManagedChannel channel = getChan();
        DatabaseGrpc.DatabaseBlockingStub stub = getConn(channel);

        DatabaseOuterClass.GetDbRequest request = DatabaseOuterClass.GetDbRequest.newBuilder()
                .setColumns(columns)
                .setTable(table)
                .setCondition(condition)
                .setDbHost(db_host)
                .build();

        DatabaseOuterClass.GetDbResponse response = stub.getDb(request);
        channel.shutdownNow();
        return response;
    }

    public DatabaseOuterClass.InsertDbResponse insertDb(String table, String columns, String values, String db_host) {
        ManagedChannel channel = getChan();
        DatabaseGrpc.DatabaseBlockingStub stub = getConn(channel);

        DatabaseOuterClass.InsertDbRequest request = DatabaseOuterClass.InsertDbRequest.newBuilder()
                .setTable(table)
                .setColumns(columns)
                .setValues(values)
                .setDbHost(db_host)
                .build();

        DatabaseOuterClass.InsertDbResponse response = stub.insertDb(request);
        channel.shutdownNow();
        return response;
    }

    public DatabaseOuterClass.DeleteDbResponse deleteDb(String table, String condition, String db_host) {
        ManagedChannel channel = getChan();
        DatabaseGrpc.DatabaseBlockingStub stub = getConn(channel);

        DatabaseOuterClass.DeleteDbRequest request = DatabaseOuterClass.DeleteDbRequest.newBuilder()
                .setTable(table)
                .setCondition(condition)
                .setDbHost(db_host)
                .build();

        DatabaseOuterClass.DeleteDbResponse response = stub.deleteDb(request);

        channel.shutdownNow();

        return response;
    }
}
