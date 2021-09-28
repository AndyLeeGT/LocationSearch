package main;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

public class GDSFactory {
    // GCS will fetch Application Default Credentials from the environment
    static DatastoreOptions dsOptions = DatastoreOptions.getDefaultInstance();

    public static Datastore getGDS() {
        return dsOptions.getService();
    }
}
