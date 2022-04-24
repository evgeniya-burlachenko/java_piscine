public interface UsersList {
    void addUser(User user);
    User RetrieveUserById(int id) throws UserNotFoundException;
    User RetrieveUserByIndex(int index) throws UserNotFoundException;
    int RetrieveNumberOfUsers();
}
