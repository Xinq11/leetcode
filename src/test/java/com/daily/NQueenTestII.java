package com.daily;

import com.daily.Dec.NQueenII;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j

public class NQueenTestII {
    @Test
    public void test() {
        NQueenII nQueenII = new NQueenII();
        int i = nQueenII.totalNQueens(4);
        log.info(String.valueOf(i));
    }
}
