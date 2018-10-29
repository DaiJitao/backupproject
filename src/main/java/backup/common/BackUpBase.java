package backup.common;


import backup.utils.HTTPUtil;

import java.util.Map;

/**
 * Created by daijitao on 2018/10/12.
 */
public class BackUpBase {
    protected static String CommVault_SERVER_URL;

    static {
        Configuration configuration = Configuration.getInstance();
        configuration.init();
        String IP = configuration.getIP("ip");
        String PORT = configuration.getProperty("port");
        CommVault_SERVER_URL = "http://" + IP + ":" + PORT;

    }

    public HTTPUtil httpUtil = HTTPUtil.getInstance();
    public Map<String, String> headers = Configuration.getInstance().initHeaders();

}
