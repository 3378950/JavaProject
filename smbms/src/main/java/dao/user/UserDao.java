package dao.user;

import pojo.Role;
import pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    public User getLoginUser(Connection connection, String userCode) throws Exception;

    public int updatePwd(Connection connection, int id, String password) throws Exception;

    public int getUserCount(Connection connection, String username, int userRole) throws Exception;

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

}
