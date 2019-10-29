package com.liamma.commons.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;

import com.liamma.commons.App;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


/**
 * Network utils.
 * Created by Liam on 2018/7/17.
 */
public final class NetworkUtils {

    // Defines network type name.
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_MOBILE = "mobile";
    public static final String NET_TYPE_WIFI = "wifi";
    public static final String NET_TYPE_UNKNOWN = "unknown";

    private NetworkUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Return NetworkInfo.
     * Need permission {@code "android.permission.ACCESS_NETWORK_STATE"}
     *
     * @return NetworkInfo, or null if no default network is active current now.
     */
    @Nullable
    @CheckResult
    private static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm =
                (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm == null ? null : cm.getActiveNetworkInfo();
    }

    /**
     * Indicates whether it's network connected.
     */
    public static boolean isConnected() {
        NetworkInfo networkInfo = getNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * Indicates whether it's wifi connected.
     */
    public static boolean isWifiConnect() {
        NetworkInfo networkInfo = getNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * Indicates whether it's mobile connected.
     */
    public static boolean isMobileConnect() {
        NetworkInfo networkInfo = getNetworkInfo();
        return networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
    }

    /**
     * Returns the MAC address, or an empty string if WifiManager is null.
     * Need permission {@code "android.permission.ACCESS_WIFI_STATE"}
     */
    public static String getMacAddress() {
        WifiManager wm = (WifiManager) App.getInstance()
                .getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        String macAddress = "";
        if (wm == null) return macAddress;

        WifiInfo wifiInfo = wm.getConnectionInfo();
        return wifiInfo == null ? macAddress : wifiInfo.getMacAddress();
    }

    /**
     * Returns the IP address, or an empty string if any exception occurred.
     */
    public static String getIPAddress() {
        String ip = "";
        String strNetworkType = getNetworkType();

        if (NET_TYPE_MOBILE.equals(strNetworkType)) {
            try {
                for (Enumeration<NetworkInterface> enumInterfaces = NetworkInterface.getNetworkInterfaces();
                     enumInterfaces.hasMoreElements(); ) {
                    NetworkInterface networkInterface = enumInterfaces.nextElement();

                    for (Enumeration<InetAddress> enumAddresses = networkInterface.getInetAddresses();
                         enumAddresses.hasMoreElements(); ) {
                        InetAddress inetAddress = enumAddresses.nextElement();

                        if (!inetAddress.isLoopbackAddress()) {
                            ip = inetAddress.getHostAddress();
                            if (!StringUtils.isBlank(ip)) return ip;
                        }
                    }
                }
            } catch (SocketException e) {
                LogUtils.d(e.toString());
            }

        } else if (NET_TYPE_WIFI.equals(strNetworkType)) {
            WifiManager wm = (WifiManager) App.getInstance()
                    .getApplicationContext().getSystemService(Context.WIFI_SERVICE);

            if (wm == null) return ip;
            WifiInfo wifiInfo = wm.getConnectionInfo();

            int ipAddress = wifiInfo.getIpAddress();
            // converts int ip address to string.
            ip = (ipAddress & 0xff) + "." + (ipAddress >> 8 & 0xff) + "." +
                    (ipAddress >> 16 & 0xff) + "." + (ipAddress >> 24 & 0xff);

            return ip;
        }

        return ip;
    }

    /**
     * Returns the network type.
     */
    public static String getNetworkType() {
        NetworkInfo networkInfo = getNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected()) {
            return NET_TYPE_UNKNOWN;
        }

        int type = networkInfo.getType();
        switch (type) {
            case ConnectivityManager.TYPE_WIFI:
                return NET_TYPE_WIFI;
            case ConnectivityManager.TYPE_MOBILE:
                return NET_TYPE_MOBILE;
            default:
                return NET_TYPE_UNKNOWN;
        }
    }

    /**
     * Returns detail network type.
     */
    public static String getDetailNetworkType() {
        NetworkInfo networkInfo = getNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected()) {
            return NET_TYPE_UNKNOWN;
        }

        int type = networkInfo.getType();
        switch (type) {
            case ConnectivityManager.TYPE_WIFI:
                return NET_TYPE_WIFI;
            case ConnectivityManager.TYPE_MOBILE:
                return getDetailMobileNetworkType();
            default:
                return NET_TYPE_UNKNOWN;
        }
    }

    /**
     * Returns detail mobile network type.
     *
     * @return Detail mobile network type.(2G/3G/4G/Unknown)
     */
    public static String getDetailMobileNetworkType() {
        TelephonyManager tm =
                (TelephonyManager) App.getInstance().getSystemService(Context.TELEPHONY_SERVICE);

        if (tm == null) return NET_TYPE_UNKNOWN;

        int type = tm.getNetworkType();
        switch (type) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return NET_TYPE_2G;
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return NET_TYPE_3G;
            case TelephonyManager.NETWORK_TYPE_LTE:
                return NET_TYPE_4G;
            default:
                return NET_TYPE_UNKNOWN;
        }
    }

}
