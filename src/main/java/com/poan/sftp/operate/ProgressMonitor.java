package com.poan.sftp.operate;

import com.jcraft.jsch.SftpProgressMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: panbenxing
 * @Date: 2018/7/9
 * @Description: 由于原生的sftp的put方法没有返回值，只能通过SftpProgressMonitor
 * 的实现类，观察该次上传是否结束。
 */
public class ProgressMonitor implements SftpProgressMonitor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private long transfered;

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean count(long count) {
        transfered = transfered + count;
        logger.info("Currently transferred total size: {} bytes", transfered);
        return true;
    }

    @Override
    public void end() {
        done = true;
        logger.info("Transferring done.");
    }

    @Override
    public void init(int op, String src, String dest, long max) {
        done = false;
        logger.info("Transferring begin.");
    }

}
