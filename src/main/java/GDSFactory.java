package main.java;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

import java.rmi.RemoteException;

public class GDSFactory {
    // GCS will fetch Application Default Credentials from the environment
    private static DatastoreOptions dsOptions;

    public static Datastore getGDS() {
        if (dsOptions == null) {
            dsOptions = DatastoreOptions.getDefaultInstance();
        }
        return dsOptions.getService();
    }
}
