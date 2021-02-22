package com.liamma.commons.data.db;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2021/2/22 16:54
 * DESCRIPTION:
 */
public final class DatabaseManager {

    private static volatile DatabaseManager instance = null;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseManager.class) {
                if (instance == null) {
                    instance = new DatabaseManager();
                }
            }
        }
        return instance;
    }

}
