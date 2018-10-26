package backup.Client;


import backup.common.BackUpBase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by daijitao on 2018/10/15.
 */
public class ClientOp extends BackUpBase {

    public static void main(String[] args) {
        ClientOp op = new ClientOp();
        System.out.println(op.getClients());
        System.out.println(op.getClientsByVSPseudo(true));
        System.out.println(op.getClientsByVSPseudo(false));
    }

    public String getClients() {
        String result = "";
        String url = CommVault_SERVER_URL + "/SearchSvc/CVWebService.svc/Client";
        result = httpUtil.doGet(url, headers, null);
        return result;
    }

    public String getClientsByVSPseudo(boolean isVSPseudo) {
        String result = "";
        String url = CommVault_SERVER_URL + "/SearchSvc/CVWebService.svc/Client";
        Map<String, String> params = new HashMap<String, String>();
        params.put("VSPseudo", isVSPseudo ? "VSPseudo" : "CloudApps");
        result = httpUtil.doGet(url, headers, params);
        return result;
    }
}
