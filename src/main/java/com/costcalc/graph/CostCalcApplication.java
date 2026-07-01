package com.costcalc.graph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * アプリケーションの起動クラス。
 */
@SpringBootApplication
public class CostCalcApplication {

    /**
     * エントリーポイント。
     *
     * @param args 起動引数
     */
    public static void main(String[] args) {
        SpringApplication.run(CostCalcApplication.class, args);
    }
}
