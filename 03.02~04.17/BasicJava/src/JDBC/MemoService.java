package JDBC;

import java.util.List;

public class MemoService {

    private MemoDAO dao = new MemoDAO();
    public List<MemoVO> getMemos() throws Exception {
        return dao.getMemos();
    }
    public MemoVO getMemo(int searchId) throws Exception {
        return dao.getMemo(searchId);
    }
    public int insertMemo(MemoVO vo) throws Exception {
        return dao.insertMemo(vo);
    }
    public int updateMemo(MemoVO vo){
        return dao.updateMemo(vo);
    }
    public int deleteMemo(int deleteId){
        return dao.deleteMemo(deleteId);
    }
}
