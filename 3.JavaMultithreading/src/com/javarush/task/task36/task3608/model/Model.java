package com.javarush.task.task36.task3608.model;

/**
 * Created by Anton on 02.07.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();

    void loadDeletedUsers();
    void loadUserById(long userid);

    void deleteUserById(long id);

    void changeUserData(String name, long id, int level);
}
