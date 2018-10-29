package backup.utils;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * Created by daijitao on 2018/10/29.
 */
public class BackupResponse extends Response {
    public Object getEntity() {
        return null;
    }

    public int getStatus() {
        return 0;
    }

    public MultivaluedMap<String, Object> getMetadata() {
        return null;
    }
}
