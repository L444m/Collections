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
 * DESCRIPTION: This class is used to manager all activities and exit app.
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
    public void addActivity(@Nullable Activity activity) {
        if (activity != null) {
            activityStack.add(activity);
        }
    }

    /**
     * Gets current activity instance (the latest activity added).
     */
    @Nullable
    public Activity getCurrentActivity() {
        if (EmptyUtils.isNotEmpty(activityStack)) {
            return activityStack.getLast();
        } else {
            return null;
        }
    }

    /**
     * Finishes current activity instance (the latest activity added).
     */
    public void finishActivity() {
        Activity activity = activityStack.getLast();
        finishActivity(activity);
    }

    /**
     * Finishes the specified activity instance.
     *
     * @param activity Activity
     */
    public void finishActivity(@Nullable Activity activity) {
        if (activity == null) return;
        activityStack.remove(activity);
        activity.finish();
        activity = null;
    }

    /**
     * Finishes the specified activity instance according to Class object.
     */
    public void finishActivity(@Nullable Class<?> clazz) {
        if (clazz == null) return;
        for (Activity activity : activityStack) {
            if (clazz.equals(activity.getClass())) {
                finishActivity(activity);
            }
        }
    }

    /**
     * Finishes all activities.
     */
    public void finishAllActivity() {
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
            finishAllActivity();
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            am.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

    /**
     * @return size of Activity stack.
     */
    public int activitiesStackSize() {
        return activityStack == null ? 0 : activityStack.size();
    }

}
