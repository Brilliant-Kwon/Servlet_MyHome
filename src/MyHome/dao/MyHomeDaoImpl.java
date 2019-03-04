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
            String sql = "SELECT no,name,password,email,gender,created_at FROM users ORDER BY no ";
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
        PreparedStatement pstmt = null;
        int insert_count = 0;

        try {
            conn = getConnection();
            String sql = "INSERT INTO users VALUES (seq_users_pk.NEXTVAL,?,?,?,?,sysdate)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getName());
            pstmt.setString(2, vo.getPassword());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getGender().toString());
            insert_count = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("SQL Error!");
                System.err.println("ERROR : " + e.getMessage());
            }
        }
        return insert_count == 1;
    }

    @Override
    public boolean delete(Long no) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int delete_count = 0;

        try {
            conn = getConnection();
            String sql = "DELETE FROM users where no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, no);
            delete_count = pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("SQL Error!");
                System.err.println("ERROR : " + e.getMessage());
            }
        }
        return delete_count == 1;
    }

    @Override
    public boolean update(MyHomeVo vo) {
        return false;
    }
}
