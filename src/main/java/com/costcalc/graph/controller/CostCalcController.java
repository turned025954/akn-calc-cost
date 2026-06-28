package com.costcalc.graph.controller;

import com.costcalc.graph.dto.CalcRequestDto;
import com.costcalc.graph.service.CostCalcService;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * コスト計算のエントリーポイント。
 * 画面から受け取ったDTOをサービス層へ引き渡す。
 */
@RestController
public class CostCalcController {

    private final CostCalcService costCalcService = new CostCalcService();

    /**
     * コスト計算APIエンドポイント。
     *
     * @param requestDto オペレーター情報リストとゲーム環境設定をまとめたDTO
     * @return 秒数をキー、CP値をバリューとしたMap
     */
    @PostMapping("/api/cost/calculate")
    public Map<Integer, Integer> calculate(@RequestBody CalcRequestDto requestDto) {
        return costCalcService.costCalculation(requestDto.charaDtoList, requestDto.prefDto);
    }
}
