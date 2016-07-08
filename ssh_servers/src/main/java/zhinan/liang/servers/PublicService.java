package zhinan.liang.servers;

import java.io.Serializable;

/**
 * Created by liang on 2016/6/2.
 */
public interface PublicService<T extends Serializable, PK extends Serializable>{
    boolean saveOrUpdateModel(T model);
    boolean deleteModel(PK id);
    boolean saveModel(T model);
    boolean updateModel(T model);
    T findModel(PK id);
}
