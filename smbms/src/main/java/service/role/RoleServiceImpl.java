package service.role;

import dao.BaseDao;
import dao.role.RoleDao;
import dao.role.RoleDaoImpl;
import org.junit.Test;
import pojo.Role;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    @Override
    public List<Role> getRoleList() {
        Connection connection = null;
        List<Role> roleList = null;
        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection, null, null);
        }
        return roleList;
    }
    @Test
    public void test() {
        RoleServiceImpl rs = new RoleServiceImpl();
        List<Role> rl = rs.getRoleList();
        for (Role role : rl) {
            System.out.println(role.getRoleName());
        }
    }
}
