package com.liamma.commons;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.utils.EmptyUtils;

import java.util.LinkedList;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/1/10 14:01
 * DESCRIPTION: This class is used to manager all activities.
 */
public final class ActivitiesManager {

    private static volatile ActivitiesManager instance = null;
    private LinkedList<Activity> activityStack;

    /**
     * Constructs a new ActivitiesManager instance.
     */
    private ActivitiesManager() {
        if (activityStack == null) {
            activityStack = new LinkedList<>();
        } else {
            activityStack.clear();
        }
    }

    // singleton
    @NonNull
    public static ActivitiesManager getInstance() {
        if (instance == null) {
            synchronized (ActivitiesManager.class) {
                if (instance == null) {
                    instance = new ActivitiesManager();
                }
            }
        }
        return instance;
    }

    /**
     * Adds a activity instance to the activities stack.
     */
    public void add(@Nullable Activity activity) {
        if (activity != null) {
            activityStack.add(activity);
        }
    }

    /**
     * Returns current activity instance (the latest added activity).
     */
    @Nullable
    public Activity getCurrent() {
        if (EmptyUtils.isEmpty(activityStack)) {
            return null;
        }
        return activityStack.getLast();
    }

    /**
     * Finishes current activity instance.
     */
    public void finish() {
        Activity activity = getCurrent();
        finish(activity);
    }

    /**
     * Finishes the specified activity instance according to Class object.
     */
    public void finish(@Nullable Class<?> clazz) {
        if (clazz == null) {
            return;
        }
        for (Activity activity : activityStack) {
            if (clazz.equals(activity.getClass())) {
                finish(activity);
            }
        }
    }

    /**
     * Finishes the specified activity instance.
     */
    public void finish(@Nullable Activity activity) {
        if (activity == null) {
            return;
        }
        activityStack.remove(activity);
        activity.finish();
        activity = null;
    }

    /**
     * Finishes all activity instances.
     */
    public void finishAll() {
        int size = activityStack.size();
        for (int i = 0; i < size; i++) {
            if (activityStack.get(i) != null) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * Exits this application.
     *
     * @param context Context
     */
    public void exitApp(@NonNull Context context) {
        try {
            finishAll();
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            am.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            // swallow
        }
    }

    /**
     * Return the size of Activity stack.
     */
    public int getStackSize() {
        return activityStack != null ? activityStack.size() : 0;
    }

}
