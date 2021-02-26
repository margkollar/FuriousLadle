package com.example.myapplication.furiousladle.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {
    @Insert
    void insert(UserEntity entity);

    @Insert
    void insert(UserEntity[] entities);

    @Delete
    void delete(UserEntity entity);

    @Update
    void update(UserEntity entity);


    //query
    @Query("SELECT * FROM userentity WHERE username=(:username) AND password=(:password)")
    UserEntity login(String username,String password);
}