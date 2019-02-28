package MyHome.dao;

import MyHome.vo.MyHomeVo;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyHomeDaoImpl extends BaseDao implements MyHomeDao {

    public MyHomeDaoImpl(String dbUser, String dbPass) {
        super(dbUser, dbPass);
    }

    @Override
    public List<MyHomeVo> getList() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<MyHomeVo> list = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT no,name,password,email,gender,created_at FROM users";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Long no = rs.getLong(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);
                Character gender = rs.getString(5).charAt(0);
                Date created_at = rs.getDate(6);

                MyHomeVo vo = new MyHomeVo(no, name, password, email, gender, created_at);
                list.add(vo);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error!");
            System.err.println("ERROR : " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("SQL Error!");
                System.err.println("ERROR : " + e.getMessage());
            }
        }

        return list;
    }

    @Override
    public boolean insert(MyHomeVo vo) {

        Connection conn = null;
        return false;
    }

    @Override
    public boolean delete(Long no) {
        return false;
    }

    @Override
    public boolean update(MyHomeVo vo) {
        return false;
    }
}
