package com.daily;

import com.daily.Dec.CheckTwoChessboards;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class CheckTwoChessboardsTest {
    @Test
    public void test(){
        CheckTwoChessboards nQueen = new CheckTwoChessboards();
        boolean b = nQueen.checkTwoChessboards("a1", "c3");
        log.info(String.valueOf(b));
    }
}
