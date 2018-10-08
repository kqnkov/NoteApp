package com.example.krasimiryankov.roomwordsample.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.krasimiryankov.roomwordsample.AppExecutors;
import com.example.krasimiryankov.roomwordsample.data.database.WordDatabase;
import com.example.krasimiryankov.roomwordsample.data.entities.Word;

import java.util.List;

public class Repository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public Repository(Application application) {
        WordDatabase wordDatabase = WordDatabase.getDatabase(application);
        mWordDao = wordDatabase.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(final Word word) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mWordDao.insertWord(word);
            }
        });
    }
}
