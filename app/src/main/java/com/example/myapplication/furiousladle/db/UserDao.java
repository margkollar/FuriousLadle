package com.example.myapplication.furiousladle.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

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



    //get the list of  all users
    @Query("SELECT * FROM userentity")
    List<UserEntity> getEntity();

    //get user by id
    @Query("SELECT * FROM userentity WHERE user_id=:id")
    UserEntity getUserEntity(int id);

    //query
    @Query("SELECT * FROM userentity WHERE username LIKE :username AND password LIKE :password")
    UserEntity login(String username,String password);

    @Query("SELECT * FROM userentity LIMIT 1")
    UserEntity getFirstEntity();
}