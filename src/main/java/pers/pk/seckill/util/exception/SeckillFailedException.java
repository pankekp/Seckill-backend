package pers.pk.seckill.util.exception;

import pers.pk.seckill.util.pojo.Error;

/**
 * @author panke
 * @date created in 8/3/18 4:31 PM
 */
public class SeckillFailedException extends RuntimeException {

    private Error error;

    public SeckillFailedException(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
