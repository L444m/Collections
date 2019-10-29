package com.liamma.commons.http;

import com.liamma.commons.utils.DateTimeUtils;

/**
 * ClassName:   HttpConfigs
 * Description: Configs in this class are used for http client setting.
 * Author:      Liam
 * Date:        2019/10/14 18:05
 * Version:     V1.0
 */
public class HttpConfigs {

    // multiple urls for multiple http client setting.
    public static final String[] baseUrls = new String[]{};
    // optionals
    public static final long connectTimeout = 10 * DateTimeUtils.SECOND;
    public static final long readTimeout = 10 * DateTimeUtils.SECOND;
    public static final long writeTimeout = 10 * DateTimeUtils.SECOND;

    private HttpConfigs() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    public static final String BASE_URL = "";

    public static final String[] BASE_URLS = new String[] {

    };


    public static class Builder {

        // multiple urls for multiple http client setting.
        private String[] baseUrls;
        // optionals
        private long connectTimeout = 10 * DateTimeUtils.SECOND;
        private long readTimeout = 10 * DateTimeUtils.SECOND;
        private long writeTimeout = 10 * DateTimeUtils.SECOND;

        private Builder(String[] baseUrls, long connectTimeout, long readTimeout, long writeTimeout) {
            this.baseUrls = baseUrls;
            this.connectTimeout = connectTimeout;
            this.readTimeout = readTimeout;
            this.writeTimeout = writeTimeout;
        }

        public HttpConfigs.Builder setBaseUrls(String... baseUrls) {
            this.baseUrls = baseUrls;
            return this;
        }

        public HttpConfigs.Builder setConnectTimeout(long connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }

        public HttpConfigs.Builder setReadTimeout(long readTimeout) {
            this.readTimeout = readTimeout;
            return this;
        }

        public HttpConfigs.Builder setWriteTimeout(long writeTimeout) {
            this.writeTimeout = writeTimeout;
            return this;
        }
    }



}
