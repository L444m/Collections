package com.liamma.commons.http;

import com.liamma.commons.utils.DateTimeUtils;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2019/10/14 18:05
 * DESCRIPTION: All configurations that would be used when initiates a Http client.
 */
public final class HttpConfigs {

    public static final long DEFAULT_CONNECT_TIME = 10 * DateTimeUtils.SECOND;
    public static final long DEFAULT_READ_TIME = 10 * DateTimeUtils.SECOND;
    public static final long DEFAULT_WRITE_TIME = 10 * DateTimeUtils.SECOND;

    private HttpConfigs() {
    }

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
