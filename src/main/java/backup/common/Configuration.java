package backup.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by daijitao on 2018/10/25.
 * 和配置文件交互
 */
public class Configuration {
    private static Configuration instance = new Configuration();
    private Properties properties = new Properties();

    private Configuration() {

    }

    public static Configuration getInstance() {
        return instance;
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(Main.class.getResource("test.properties"));// 加载类所在的目录文件
        //properties.load(Main.class.getResourceAsStream("1conf.properties"));// 加载类所在的目录文件
        //System.out.println(Main.class.getResourceAsStream("1conf.properties"));
        //System.out.println(Main.class.getClassLoader().getResource("")); // 加载根项目下的文件myTestDemo/name.filetype
    }

    public void init()  {
        String settingFile = "conf.properties";
        init(settingFile);
    }

    /**
     * 初始化配置文件
     */
    public void init(String fileName)  {
        String name = fileName;
        try {
            if (null == fileName || fileName.trim().length() == 0) {
                throw new Exception("文件名[" + fileName + "]不可为空");
            }
            fileName = getPath() + fileName;
            // InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
            InputStream in = new FileInputStream(new File(fileName));
            if (in == null) {
                // String path = this.getClass().getClassLoader().getResource("").getPath();
                throw new Exception("在目录[" + fileName + "]下找不到[" + name + "]文件");
            }
            this.properties.load(in);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String prop = this.properties.getProperty(key);
        if (prop == null) {
            prop = "";
        }
        return prop;
    }

    public String getIP(String ip) {
        String prop = this.properties.getProperty(ip);
        try {
            if (null == prop || prop.trim().length() == 0) {
                throw new Exception(ip + "不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * 从配置文件 获取用户名密码
     *
     * @return
     */
    public Map<String, String> initUser() {
        Map<String, String> params = new HashMap<String, String>();
        String username = this.getProperty("username");
        String pwd = this.getProperty("password");
        params.put("username", username);
        params.put("password", pwd); // UEBzc3cwcmQ=
        return params;
    }

    public Map<String, String> initHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");
        String token = Token.getToken(initUser());
        headers.put("Authtoken", token);
        return headers;
    }

    private String getPath(){
        String path = System.getProperty("user.dir");
        File file = new File(path);
        File parent = file.getParentFile();
        String result = parent.getPath() + "\\conf\\";
        return result;
    }
}
