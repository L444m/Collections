package com.liamma.commons.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liamma.commons.App;

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
    private SharedPreferences sp = null;

    /**
     * Private constructor, prevents from being instantiated outside.
     */
    private SPUtils(final String spName) {
        sp = App.getInstance().getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
    }

    /**
     * Gets SPUtils instance with default SP name.
     */
    public static SPUtils getInstance() {
        return getInstance(null);
    }

    /**
     * Gets SPUtils instance corresponding to the specified SP name.
     *
     * @param spName SharedPreferences name
     */
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
     *
     * @param spName SharedPreferences name
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
     * Gets SharedPreferences.Editor object.
     * <p>
     * For chain use, example :
     * <code>
     * SPUtils.getInstance().getEditor
     * .putString("key1", "value1").putString("key2", "value2").apply();
     * </code>
     */
    public SharedPreferences.Editor getEditor() {
        return sp.edit();
    }

    /**
     * Puts string value in SharedPreferences.
     *
     * @param key   String
     * @param value String
     */
    public void putString(@NonNull String key, @Nullable String value) {
        putString(key, value, false);
    }

    /**
     * Puts string value in SharedPreferences.
     *
     * @param key      String
     * @param value    String
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
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
     *
     * @param key String
     */
    @Nullable
    public String getString(@NonNull String key) {
        return getString(key, DEFAULT_VALUE_STRING);
    }

    /**
     * Gets string value from SharedPreferences.
     *
     * @param key          String
     * @param defaultValue Default string value
     */
    @Nullable
    public String getString(@NonNull String key, @Nullable String defaultValue) {
        return sp.getString(key, defaultValue);
    }

    /**
     * Puts string set in SharedPreferences.
     *
     * @param key    String
     * @param values {@code Set<String>}
     */
    public void putStringSet(@NonNull String key, @Nullable Set<String> values) {
        putStringSet(key, values, false);
    }

    /**
     * Puts string set in SharedPreferences.
     *
     * @param key      String
     * @param values   {@code Set<String>}
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
     */
    public void putStringSet(@NonNull String key, @Nullable Set<String> values, boolean isCommit) {
        if (isCommit) {
            getEditor().putStringSet(key, values).commit();
        } else {
            getEditor().putStringSet(key, values).apply();
        }
    }

    /**
     * Gets string set from SharedPreferences.
     *
     * @param key String
     */
    @Nullable
    public Set<String> getStringSet(@NonNull String key) {
        return getStringSet(key, DEFAULT_VALUE_STRING_SET);
    }

    /**
     * Gets string set from SharedPreferences.
     *
     * @param key          String
     * @param defaultValue Default string set
     */
    @Nullable
    public Set<String> getStringSet(@NonNull String key, @Nullable Set<String> defaultValue) {
        return sp.getStringSet(key, defaultValue);
    }

    /**
     * Puts int value in SharedPreferences.
     *
     * @param key   String
     * @param value Integer
     */
    public void putInt(@NonNull String key, int value) {
        putInt(key, value, false);
    }

    /**
     * Puts int value in SharedPreferences.
     *
     * @param key      String
     * @param value    Integer
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
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
     *
     * @param key String
     */
    public int getInt(@NonNull String key) {
        return getInt(key, DEFAULT_VALUE_INT);
    }

    /**
     * Gets int value from SharedPreferences.
     *
     * @param key          String
     * @param defaultValue Default int value
     */
    public int getInt(@NonNull String key, int defaultValue) {
        return sp.getInt(key, defaultValue);
    }

    /**
     * Puts long value in SharedPreferences.
     *
     * @param key   String
     * @param value Long
     */
    public void putLong(@NonNull String key, long value) {
        putLong(key, value, false);
    }

    /**
     * Puts long value in SharedPreferences.
     *
     * @param key      String
     * @param value    Long
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
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
     *
     * @param key String
     */
    public long getLong(@NonNull String key) {
        return getLong(key, DEFAULT_VALUE_LONG);
    }

    /**
     * Gets long value from SharedPreferences.
     *
     * @param key          String
     * @param defaultValue Default Long value
     */
    public long getLong(@NonNull String key, long defaultValue) {
        return sp.getLong(key, defaultValue);
    }

    /**
     * Puts float value in SharedPreferences.
     *
     * @param key   String
     * @param value Float
     */
    public void putFloat(@NonNull String key, float value) {
        putFloat(key, value, false);
    }

    /**
     * Puts float value in SharedPreferences.
     *
     * @param key      String
     * @param value    Float
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
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
     *
     * @param key String
     */
    public float getFloat(@NonNull String key) {
        return getFloat(key, DEFAULT_VALUE_FLOAT);
    }

    /**
     * Gets float value from SharedPreferences.
     *
     * @param key          String
     * @param defaultValue Default Float value
     */
    public float getFloat(@NonNull String key, float defaultValue) {
        return sp.getFloat(key, defaultValue);
    }

    /**
     * Puts boolean value in SharedPreferences.
     *
     * @param key   String
     * @param value Boolean
     */
    public void putBoolean(@NonNull String key, boolean value) {
        putBoolean(key, value, false);
    }

    /**
     * Puts boolean value in SharedPreferences.
     *
     * @param key      String
     * @param value    Boolean
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
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
     *
     * @param key String
     */
    public boolean getBoolean(@NonNull String key) {
        return getBoolean(key, DEFAULT_VALUE_BOOLEAN);
    }

    /**
     * Gets boolean value from SharedPreferences.
     *
     * @param key          String
     * @param defaultValue Default boolean value
     */
    public boolean getBoolean(@NonNull String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    /**
     * Removes a key-value pair from SharedPreferences according to the specified string key.
     *
     * @param key String
     */
    public void remove(@NonNull String key) {
        remove(key, false);
    }

    /**
     * Removes a key-value pair from SharedPreferences according to the specified string key.
     *
     * @param key      String
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
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
     *
     * @param isCommit {@code true} means {@code commit()};
     *                 {@code false} means {@code apply()}.
     */
    public void clear(boolean isCommit) {
        if (isCommit) {
            getEditor().clear().commit();
        } else {
            getEditor().clear().apply();
        }
    }

}
