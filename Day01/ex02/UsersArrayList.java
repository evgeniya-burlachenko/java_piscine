public class UsersArrayList implements UsersList {
    private final int arraySize = 10;
    private int capacity = 10;
    private int size = 0;

    private User[] usersArray = new User[arraySize];

    @Override
    public void addUser(User user) {
        if (capacity == size) {
            User[] newArray = new User[size * 2];
            int i = 0;
            for (; i < size; ++i)
                newArray[i] = usersArray[i];
            newArray[i] = user;
            capacity *= 2;
            usersArray = newArray;
        } else {
            usersArray[size] = user;
            size++;
        }
    }
    @Override
    public User RetrieveUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (usersArray[i].getIdentifier() == id)
                return usersArray[i];
        }
        throw new UserNotFoundException();
    }
    @Override
    public User RetrieveUserByIndex(int index) throws UserNotFoundException  {
        if (index < 0 || index > size)
            throw new UserNotFoundException();
        else {
            return usersArray[index];
        }
    }
    @Override
    public int RetrieveNumberOfUsers() {
        return size;
    }
    public  int getArraySize(){
        return  usersArray.length;
    }
}