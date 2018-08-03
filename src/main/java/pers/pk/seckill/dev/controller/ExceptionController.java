package pers.pk.seckill.dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.pk.seckill.util.exception.LoginException;
import pers.pk.seckill.util.exception.SeckillFailedException;
import pers.pk.seckill.util.pojo.Error;
import pers.pk.seckill.util.pojo.Result;

/**
 * @author panke
 * @date created in 18-8-1 下午2:48
 */

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> loginFailed() {
        return Result.error(Error.LOGIN_ERROR);
    }

    @ExceptionHandler(SeckillFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> seckillFailed(SeckillFailedException e) {
        return Result.error(e.getError());
    }
}
