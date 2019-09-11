package proxy.staticProxy;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userId, String userName) {
        System.out.println("UserManagerImpl.addUser");
    }

    @Override
    public void deleteUser(String userId) {
        System.out.println("哥们准备做删除动作了");
    }


}
