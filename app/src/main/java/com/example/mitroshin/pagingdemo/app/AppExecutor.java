package com.example.mitroshin.pagingdemo.app;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutor {

    private static final int NETWORK_POOL_SIZE = 3;

    private static volatile AppExecutor INSTANCE = new AppExecutor();

    public synchronized static AppExecutor get() {
        return INSTANCE;
    }

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    private AppExecutor(Executor diskIO,
                        Executor networkIO,
                        Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    AppExecutor() {
        this(Executors.newSingleThreadExecutor(),
                Executors.newFixedThreadPool(NETWORK_POOL_SIZE),
                new MainThreadExecutor());
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {

        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}