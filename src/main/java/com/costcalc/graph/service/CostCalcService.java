package com.costcalc.graph.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CostCalcService {
    /**
     * 秒数
     */
    public Integer second;
    /**
     * 終了時間
     */
    public Integer timeLimit;
    /**
     * CP
     */
    public Double cost;
    /**
     * 初期追加cost
     */
    public Integer costBuff;
    /**
     * CP回復速度
     */
    public Double costSpeed;
    /**
     * CP上限
     */
    public Double costLimit;
    /**
     * 配置コスト軽減など、実質的な追加cost
     */
    public Double costSub;
    /**
     * 配置コスト
     */
    public Integer deployCost;
    /**
     * 必要SP
     */
    public Integer spRequire;
    /**
     * SP
     */
    public Integer sp;
    /**
     * SP回復速度
     */
    public Double spSpeed;
    /**
     * 初期追加SP
     */
    public Integer spBuff;
    /**
     * スキル発動時間
     */
    public Integer skillTime;
    /**
     * スキル経過時間
     */
    public Integer skillCount = 0;
    /**
     * スキル合計獲得CP
     */
    public Double costFinal;
    /**
     * 秒単位の獲得CP
     */
    public Double costAddition;
    /**
     * 配置状態
     */
    public boolean isDeployed = false;
    /**
     * スキル発動状態
     */
    public boolean skillFlg = false;

    public static void main(String[] args) {
        CostCalcService service = new CostCalcService();
        Map<Integer, Integer> graphPram = service.costCalculation();

        for (Map.Entry<Integer, Integer> record : graphPram.entrySet()) {
            System.out.println(record.getKey() +  ", " +record.getValue());
        }
    }

    /**
     * 
     */
    public Map<Integer, Integer> costCalculation() {
        second = 0;
        timeLimit = 180;
        cost = 10.0;
        costSpeed = 1.0;
        costLimit = 99.0;

        deployCost = 8;
        spRequire = 40;
        spSpeed = 1.0;
        spBuff = 0;
        sp = 30 + spBuff;
        costFinal = 12.0;
        skillTime = 0;

        if (skillTime == 0) {
            costAddition = costFinal;
        } else {
            costAddition = costFinal / skillTime;
        }

        Map<Integer, Integer> outMap = new LinkedHashMap<>();

        while (second <= timeLimit) {
            if (isDeployed && spRequire <= sp) {
                skillFlg = true;
            }

            if (skillFlg) {
                cost += costAddition;
                if (skillTime <= skillCount) {
                    skillFlg = false;
                    skillCount = 0;
                    sp = 0;
                } else {
                    skillCount++;
                }

                if (costLimit <= cost) {
                    cost = costLimit;
                }

            } else {
                sp++;
            }

            // 配置中
            if (!isDeployed && deployCost <= cost) {
                isDeployed = true;
                cost -= deployCost;
            }

            outMap.put(second, cost.intValue());

            second++;

            if (costLimit <= cost) {
                cost = costLimit;
            } else {
                cost += costSpeed;
            }

        }
        return outMap;
    }
}