package com.costcalc.graph.controller;

import com.costcalc.graph.dto.CalcRequestDto;
import com.costcalc.graph.service.CostCalcService;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CP・SPグラフ計算のエントリーポイント。
 * 画面から受け取ったDTOをサービス層へ引き渡す。
 */
@RestController
public class CostCalcController {

    private final CostCalcService costCalcService = new CostCalcService();

    /**
     * グラフ計算APIエンドポイント。
     *
     * @param requestDto オペレーター情報とゲーム環境設定をまとめたDTO
     * @return 秒数をキー、CP値をバリューとしたMap
     */
    @PostMapping("/api/graph/calculate")
    public Map<Integer, Integer> calculateGraph(@RequestBody CalcRequestDto requestDto) {
        return costCalcService.costCalculation(requestDto.charaDto, requestDto.prefDto);
    }
}
