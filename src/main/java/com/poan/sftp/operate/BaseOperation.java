package com.poan.sftp.operate;

import com.poan.sftp.config.ChannelConfig;

/**
 * @Author: panbenxing
 * @Date: 2018/7/9
 * @Description:
 */
public interface BaseOperation {

    void upload(ChannelConfig config, String src, String dst);

    void download(ChannelConfig config, String src, String dst);

}
