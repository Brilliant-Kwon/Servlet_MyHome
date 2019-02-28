package MyHome.dao;

import MyHome.vo.MyHomeVo;

import java.util.List;

public interface MyHomeDao {

    public List<MyHomeVo> getList();

    public boolean insert(MyHomeVo vo);

    public boolean delete(Long no);

    public boolean update(MyHomeVo vo);
}
