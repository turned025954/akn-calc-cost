// ファイル名: CostCalcController.java
package com.costcalc.graph.controller;

import com.costcalc.graph.dto.CharacterDto;
import com.costcalc.graph.dto.PreferenceDto;
import com.costcalc.graph.service.CostCalcService;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostCalcController {
    private final CostCalcService costCalcService = new CostCalcService();

    @PostMapping("/api/graph/calculate")
    public Map<Integer, Integer> calculateGraph(CharacterDto charaDto, PreferenceDto prefDto) {
        
        // DTOから受け取ったパラメータをサービス層の統括メソッドへ引き渡します。
        return costCalcService.costCalculation(charaDto, optDto);
    }
}