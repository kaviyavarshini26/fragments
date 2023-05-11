package com.example.fragment1;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
@Dao
public interface UserDao {
    @Insert
    void insertUser(UserTable userTable);
     @Query("SELECT EXISTS(SELECT * from UserTable where userName=:userName)")
     boolean is_taken(String userName);
    @Query("SELECT EXISTS(SELECT * from UserTable where userName=:userName AND password=:password)")
    boolean login(String userName,String password);

}
