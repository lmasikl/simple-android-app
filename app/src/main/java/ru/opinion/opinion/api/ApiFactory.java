package ru.opinion.opinion.api;

import android.support.annotation.Nullable;

/**
 * Project CCS
 * Created by Aleksandr Sobol on 21/02/17.
 * email: asobol@ccsteam.ru
 */

public final class ApiFactory {

    private static ApiProvider apiProvider;

    private ApiFactory() {}

    public static void setProvider(@Nullable ApiProvider provider) {
        apiProvider = provider;
    }

    public static void resetProvider() {
        apiProvider = null;
    }

    public static ApiProvider getProvider() {
        ApiProvider provider = apiProvider;

        // singleton pattern
        if (provider == null) {
            synchronized (ApiFactory.class) {
                provider = apiProvider;
                if (provider == null) {
                    provider = apiProvider = new DefaultApiProvider();
                }
            }
        }

        return provider;
    }

}
