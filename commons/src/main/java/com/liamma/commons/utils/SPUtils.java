package com.liamma.commons.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.liamma.commons.Commons;
import com.liamma.commons.log.LogUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/1/10 00:00
 * DESCRIPTION: Utility methods for SharedPreferences.
 */
@SuppressWarnings("ApplySharedPref")
public final class SPUtils {

    public static final String DEFAULT_SP_NAME = "default_sp";

    // Default values for retrieving data from SharedPreferences.
    public static final String DEFAULT_VALUE_STRING = "";
    public static final Set<String> DEFAULT_VALUE_STRING_SET = new HashSet<>();
    public static final int DEFAULT_VALUE_INT = -1;
    public static final long DEFAULT_VALUE_LONG = -1L;
    public static final float DEFAULT_VALUE_FLOAT = -1F;
    public static final boolean DEFAULT_VALUE_BOOLEAN = false;

    // Caches all SPUtils instances in a map.
    private static final HashMap<String, SPUtils> spUtilsMap = new HashMap<>();
    private SharedPreferences sp;

    /**
     * Private constructor, prevents from being instantiated outside of this class.
     */
    private SPUtils(final String spName) {
        sp = Commons.getApp().getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    /**
     * Gets SPUtils instance with default SP name.
     */
    @NonNull
    public static SPUtils getInstance() {
        return getInstance(null);
    }

    /**
     * Gets SPUtils instance corresponding to the specified SP name.
     */
    @NonNull
    public static SPUtils getInstance(@Nullable String spName) {
        if (StringUtils.isBlank(spName)) {
            spName = DEFAULT_SP_NAME;
        }
        SPUtils spUtils = spUtilsMap.get(spName);
        if (spUtils == null) {
            spUtils = new SPUtils(spName);
            spUtilsMap.put(spName, spUtils);
        }
        return spUtils;
    }

    /**
     * Removes SPUtils instance corresponding to the specified SP name.
     */
    public static void removeInstance(@Nullable String spName) {
        if (StringUtils.isBlank(spName)) {
            spName = DEFAULT_SP_NAME;
        }
        spUtilsMap.remove(spName);
    }

    /**
     * Removes all SPUtils instances.
     */
    public static void removeAllInstance() {
        spUtilsMap.clear();
    }

    /**
     * Gets SharedPreferences object.
     */
    public SharedPreferences getSp() {
        return sp;
    }

    /**
     * Gets SharedPreferences.Editor instance.
     * <p>
     * For chain use, example :
     * <code>
     * SPUtils.getInstance().getEditor
     * .putString("key1", "value1")
     * .putString("key2", "value2")
     * .apply();
     * </code>
     */
    public SharedPreferences.Editor getEditor() {
        return sp.edit();
    }

    /**
     * Puts string value in SharedPreferences.
     */
    public void putString(@NonNull String key, @Nullable String value) {
        putString(key, value, false);
    }

    /**
     * Puts string value in SharedPreferences.
     */
    public void putString(@NonNull String key, @Nullable String value, boolean isCommit) {
        if (isCommit) {
            getEditor().putString(key, value).commit();
        } else {
            getEditor().putString(key, value).apply();
        }
    }

    /**
     * Gets string value from SharedPreferences.
     */
    @Nullable
    public String getString(@NonNull String key) {
        return getString(key, DEFAULT_VALUE_STRING);
    }

    /**
     * Gets string value from SharedPreferences.
     */
    @Nullable
    public String getString(@NonNull String key, @Nullable String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    /**
     * Puts string set value in SharedPreferences.
     */
    public void putStringSet(@NonNull String key, @Nullable Set<String> values) {
        putStringSet(key, values, false);
    }

    /**
     * Puts string set value in SharedPreferences.
     */
    public void putStringSet(@NonNull String key, @Nullable Set<String> values, boolean isCommit) {
        if (isCommit) {
            getEditor().putStringSet(key, values).commit();
        } else {
            getEditor().putStringSet(key, values).apply();
        }
    }

    /**
     * Gets string set value from SharedPreferences.
     */
    @Nullable
    public Set<String> getStringSet(@NonNull String key) {
        return getStringSet(key, DEFAULT_VALUE_STRING_SET);
    }

    /**
     * Gets string set value from SharedPreferences.
     */
    @Nullable
    public Set<String> getStringSet(@NonNull String key, @Nullable Set<String> defaultValue) {
        return sp.getStringSet(key, defaultValue);
    }

    /**
     * Puts int value in SharedPreferences.
     */
    public void putInt(@NonNull String key, int value) {
        putInt(key, value, false);
    }

    /**
     * Puts int value in SharedPreferences.
     */
    public void putInt(@NonNull String key, int value, boolean isCommit) {
        if (isCommit) {
            getEditor().putInt(key, value).commit();
        } else {
            getEditor().putInt(key, value).apply();
        }
    }

    /**
     * Gets int value from SharedPreferences.
     */
    public int getInt(@NonNull String key) {
        return getInt(key, DEFAULT_VALUE_INT);
    }

    /**
     * Gets int value from SharedPreferences.
     */
    public int getInt(@NonNull String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * Puts long value in SharedPreferences.
     */
    public void putLong(@NonNull String key, long value) {
        putLong(key, value, false);
    }

    /**
     * Puts long value in SharedPreferences.
     */
    public void putLong(@NonNull String key, long value, boolean isCommit) {
        if (isCommit) {
            getEditor().putLong(key, value).commit();
        } else {
            getEditor().putLong(key, value).apply();
        }
    }

    /**
     * Gets long value from SharedPreferences.
     */
    public long getLong(@NonNull String key) {
        return getLong(key, DEFAULT_VALUE_LONG);
    }

    /**
     * Gets long value from SharedPreferences.
     */
    public long getLong(@NonNull String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    /**
     * Puts float value in SharedPreferences.
     */
    public void putFloat(@NonNull String key, float value) {
        putFloat(key, value, false);
    }

    /**
     * Puts float value in SharedPreferences.
     */
    public void putFloat(@NonNull String key, float value, boolean isCommit) {
        if (isCommit) {
            getEditor().putFloat(key, value).commit();
        } else {
            getEditor().putFloat(key, value).apply();
        }
    }

    /**
     * Gets float value from SharedPreferences.
     */
    public float getFloat(@NonNull String key) {
        return getFloat(key, DEFAULT_VALUE_FLOAT);
    }

    /**
     * Gets float value from SharedPreferences.
     */
    public float getFloat(@NonNull String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    /**
     * Puts boolean value in SharedPreferences.
     */
    public void putBoolean(@NonNull String key, boolean value) {
        putBoolean(key, value, false);
    }

    /**
     * Puts boolean value in SharedPreferences.
     */
    public void putBoolean(@NonNull String key, boolean value, boolean isCommit) {
        if (isCommit) {
            getEditor().putBoolean(key, value).commit();
        } else {
            getEditor().putBoolean(key, value).apply();
        }
    }

    /**
     * Gets boolean value from SharedPreferences.
     */
    public boolean getBoolean(@NonNull String key) {
        return getBoolean(key, DEFAULT_VALUE_BOOLEAN);
    }

    /**
     * Gets boolean value from SharedPreferences.
     */
    public boolean getBoolean(@NonNull String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    /**
     * Puts data T in SharedPreferences.
     */
    public <T> void putData(@NonNull String key, @Nullable T t) {
        putData(key, t, false);
    }

    /**
     * Puts data T in SharedPreferences.
     */
    public <T> void putData(@NonNull String key, @Nullable T t, boolean isCommit) {
        String json = new Gson().toJson(t);
        if (isCommit) {
            getEditor().putString(key, json).commit();
        } else {
            getEditor().putString(key, json).apply();
        }
    }

    public <T> T getData(@NonNull String key, @Nullable T defaultValue) {
        String json = getString(key, "");
        if (EmptyUtils.isNotEmpty(json)) {
            try {
                T t = new Gson().fromJson(json, (Type) defaultValue);
                return t;
            } catch (Exception e) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    @SuppressWarnings("unchecked")
    public void put(@NonNull String key, @Nullable Object value, boolean isCommit) {
        SharedPreferences.Editor editor = getEditor();
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Set<?>) {
            // risky of ? type parameter.
            editor.putStringSet(key, (Set<String>) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else {
            LogUtils.e("value = " + value + ", cannot put the type of value in SharePreference.");
            return;
        }
        if (isCommit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(@NonNull String key, @NonNull T defaultValue) {
        try {
            if (defaultValue instanceof String) {
                sp.getString(key, (String) defaultValue);
            } else if (defaultValue instanceof Set<?>) {
                sp.getStringSet(key, (Set<String>) defaultValue);
            } else if (defaultValue instanceof Integer) {
                sp.getInt(key, (Integer) defaultValue);
            } else if (defaultValue instanceof Long) {
                sp.getLong(key, (Long) defaultValue);
            } else if (defaultValue instanceof Float) {
                sp.getFloat(key, (Float) defaultValue);
            } else if (defaultValue instanceof Boolean) {
                sp.getBoolean(key, (Boolean) defaultValue);
            } else {
                LogUtils.e("value = " + defaultValue);
                return defaultValue;
            }
        } catch (Exception e) {
            LogUtils.e("cast exception");
        }
        return defaultValue;
    }

    /**
     * Removes a key-value pair from SharedPreferences according to the specified string key.
     */
    public void remove(@NonNull String key) {
        remove(key, false);
    }

    /**
     * Removes a key-value pair from SharedPreferences according to the specified string key.
     */
    public void remove(@NonNull String key, boolean isCommit) {
        if (isCommit) {
            getEditor().remove(key).commit();
        } else {
            getEditor().remove(key).apply();
        }
    }

    /**
     * Clears all value from SharedPreferences.
     */
    public void clear() {
        clear(false);
    }

    /**
     * Clears all value from SharedPreferences.
     */
    public void clear(boolean isCommit) {
        if (isCommit) {
            getEditor().clear().commit();
        } else {
            getEditor().clear().apply();
        }
    }

}
