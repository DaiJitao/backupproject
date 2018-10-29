package backup.utils;

import rest.api.BackupApi;

import java.io.File;

/**
 * Created by daijitao on 2018/10/26.
 */
public class Demo {
    public static void main(String[] args) {
        String path0 = System.getProperty("user.dir");
        File file = new File(path0);
        File parentFile = file.getParentFile();

        System.out.println(path0);
        System.out.println(parentFile.getPath() + "\\conf\\");
        System.out.println(Integer.valueOf("op"));
    }
}
