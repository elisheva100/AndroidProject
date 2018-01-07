package com.example.owner.takeandgo.model.backEnd;

import com.example.owner.takeandgo.model.datasource.List_DBManager;
import com.example.owner.takeandgo.model.datasource.MySQL_DBManager;

/**
 * Created by Owner on 14/11/2017.
 */

public class DBManagerFactory {
    static DB_manager manager = null;

    public static DB_manager getManager() {
        if (manager == null)
            manager = new MySQL_DBManager();
            //manager = new List_DBManager(); //MySQL_DBManager();

        return manager;
    }

}
