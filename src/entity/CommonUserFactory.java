package entity;

public class CommonUserFactory implements UserFactory{
    /**
     * Requires: password is valid.
     * @param username
     * @param password
     * @return
     */


    @Override
    public User createUser(String username, String password){
        return new CommonUser(username, password);
    }

    @Override
    public User create(String username, String password) {
        return null;
    }
}
