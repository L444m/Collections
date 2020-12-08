package com.liamma.commons.image;

import com.liamma.commons.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liam
 * @version 1.0
 * DATE: Created on 2020/12/8 16:20
 * DESCRIPTION:
 */
public abstract class AbstractImageLoader implements IImageLoader {

    private final HashMap<String, IImageProvider> providers;
    private final IImageProvider defaultProvider;
    private IImageProvider currentProvider;
    private String currentProviderName;

    public AbstractImageLoader() {
        providers = new HashMap<>();
        defaultProvider = new GlideImageProvider();
    }

    @Override
    public void addProvider(IImageProvider provider) {
        addProvider("", provider);
    }

    @Override
    public void addProvider(String key, IImageProvider provider) {
        if (provider == null) {
            return;
        }
        String enterKey = StringUtils.isEmpty(key) ? provider.getName() : key;
        providers.put(enterKey, provider);
        currentProvider = provider;
        currentProviderName = enterKey;
    }

    @Override
    public IImageProvider getProvider(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        return providers.get(key);
    }

    @Override
    public void setCurrentProvider(String key) {
        if (StringUtils.isEmpty(key)) {
            return;
        }
        for (Map.Entry<String, IImageProvider> entry : providers.entrySet()) {
            if (key.equals(entry.getKey())) {
                currentProvider = entry.getValue();
                currentProviderName = entry.getKey();

            }
        }
    }

    @Override
    public void setCurrentProvider(IImageProvider provider) {

    }

    @Override
    public IImageProvider getCurrentProvider() {
        return null;
    }

    @Override
    public IImageProvider getDefaultProvider() {
        return null;
    }

    @Override
    public void removeProvider(String key) {

    }

    @Override
    public void removeAll() {

    }
}
