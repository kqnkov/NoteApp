package com.example.krasimiryankov.roomwordsample.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.krasimiryankov.roomwordsample.data.WordDao;
import com.example.krasimiryankov.roomwordsample.data.entities.Word;

@Database(entities = {Word.class}, version = 1)
public abstract class WordDatabase extends RoomDatabase {

    private static volatile WordDatabase INSTANCE;

    public static WordDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordDatabase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract WordDao wordDao();
}
