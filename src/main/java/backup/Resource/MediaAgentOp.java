package backup.Resource;

import backup.common.BackUpBase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daijitao on 2018/10/15.
 */
public class MediaAgentOp extends BackUpBase {

    // 获取所有MA
    public String getMA() {
        String result = "";
        String url = CommVault_SERVER_URL + "/SearchSvc/CVWebService.svc/MediaAgent";
        result = httpUtil.doGet(url, headers, null);
        return result;
    }

    // 获取单个库下的MA
    public String getMABylibraryId(String libraryId) {
        String result = "";
        String url = CommVault_SERVER_URL + "/SearchSvc/CVWebService.svc/MediaAgent";
        Map<String, String> params = new HashMap<String, String>();
        params.put("libraryId", libraryId);
        result = httpUtil.doGet(url, headers, params);
        return result;
    }
}
