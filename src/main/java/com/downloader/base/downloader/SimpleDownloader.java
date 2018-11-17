package com.downloader.base.downloader;

import com.downloader.base.model.DownloaderRequest;
import com.downloader.base.model.DownloaderResponse;

/**
 * downloader 下载器接口
 * @author: liukai
 * @time: 2018/11/17
 */
public interface SimpleDownloader {

    /**
     * 异步下载
     */
    DownloaderResponse downloadAsync(DownloaderRequest downloaderRequest);

    /**
     * 同步下载
     * @param downloaderRequest
     * @return
     */
    DownloaderResponse downloadSync(DownloaderRequest downloaderRequest);

}
