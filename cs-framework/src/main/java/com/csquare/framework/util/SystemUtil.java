package com.csquare.framework.util;

public class SystemUtil {

    public static String getDeploymentEnv() {

        String value = getEnv(SystemKey.CODEX_DEPLOYMENT_ENV);
        if (StringUtil.isEmpty(value)) {
            value = "LOCAL_DEV";
        }
        return value;
    }

    public static String getEnv(SystemKey key) {

        String keyString = key.name();
        String value = System.getenv(keyString);
        if (null == value || value.isEmpty()) {
            value = System.getProperty(keyString);
        }
        return value;
    }

    public enum SystemKey {
        CODEX_DEPLOYMENT_ENV, CODEX_STORAGE_BLOB_CONNECTION_STRING, CODEX_APPCONFIG_CONTAINER;

    }

}
