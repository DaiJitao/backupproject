package backup.StoragePolicy;


/**
 * Created by daijitao on 2018/10/12.
 */
public interface StoragePolicyBase {

    public String getStoragePolicy();

    public boolean updateStoragePolicy();

    public boolean deleteStoragePolicyByName(String name) throws Exception;

    public String createStoragePolicy(StoragePolicy sp);

}
