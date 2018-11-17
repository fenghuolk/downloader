package com.downloader.impl.downloader.browser;

import com.downloader.base.downloader.AbstractDownloader;
import com.downloader.base.model.DownloaderRequest;
import com.downloader.base.model.DownloaderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liukai
 * @time: 2018/11/17
 */
public class BrowserDownloader extends AbstractDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserDownloader.class);

    public BrowserDownloader() {
        super();
    }

    @Override
    public DownloaderResponse downloadAsync(DownloaderRequest downloaderRequest) {

        return null;
    }

    @Override
    public DownloaderResponse downloadSync(DownloaderRequest downloaderRequest) {
        return null;
    }
}
