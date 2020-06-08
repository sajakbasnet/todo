package com.example.todouser.database;

public class UserRepository {
    UserDao dao;
    public UserRepository(UserDatabase userDatabase){   dao = userDatabase.UserDao();
    }


    public User getUsers(){
        return dao.loadAllUsers();
    }

     public User loadUserBy(int id) {
        return dao.loadUserBy(id);
    }

    public void update(final User user){
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(user);
            }
        });
    }

    public void delete(final User user){
        UserDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.delete(user);
            }
        });
    }



}