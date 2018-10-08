package com.example.krasimiryankov.roomwordsample.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.krasimiryankov.roomwordsample.data.entities.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private Repository mRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
        mAllWords = mRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insertWord(Word word){
        mRepository.insert(word);
    }
}
