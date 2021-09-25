package main;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

public class GDSFactory {
    static Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    public static Datastore getGDS() {
        return datastore;
    }
}
