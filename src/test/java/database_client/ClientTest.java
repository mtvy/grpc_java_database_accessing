package database_client;

import api.DatabaseGrpc;
import api.DatabaseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class ClientTest extends TestCase {

    final String DB_HOST = "postgres://postgres:postgres@0.0.0.0:5432/postgres";
    public void testApp()
    {
        Client client = new Client("0.0.0.0:8080");

        System.out.println("INSERTING {url: 'Hello', name: 'World'} into [qrcodes_tb]\n" +
                client.insertDb("qrcodes_tb", "url, name", "'Hello', 'World'", DB_HOST));

        System.out.println("GETTING from [qrcodes_tb] \"WHERE url='Hello'\"\n" +
                client.getDb("*", "qrcodes_tb", "WHERE url='Hello'", DB_HOST));

        System.out.println("GETTING from [qrcodes_tb] \"WHERE url='Hello'\"\n" +
                client.deleteDb("qrcodes_tb", "WHERE url='Hello'", DB_HOST));
    }
}
