package com.costcalc.graph.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.costcalc.graph.dto.CharacterDto;
import com.costcalc.graph.dto.PreferenceDto;

/**
 * CP・SPの時系列変化を計算するサービスクラス。
 * 1秒ごとのCP値をMapに格納して返却する。
 */
@Service
public class CostCalcService {

    /** 経過秒数 */
    public Integer second;
    /** 計算終了時間（秒） */
    public Integer timeLimit;
    /** 現在のCP */
    public Double cost;
    /** 初期追加CP */
    public Integer costBuff;
    /** CP回復速度 */
    public Double costSpeed;
    /** CP上限 */
    public Double costLimit;
    /** 配置コスト軽減など実質的な追加CP */
    public Double costSub;
    /** 配置コスト */
    public Integer deployCost;
    /** 必要SP */
    public Integer spRequire;
    /** 現在のSP */
    public Integer sp;
    /** SP回復速度 */
    public Double spSpeed;
    /** 初期追加SP */
    public Integer spBuff;
    /** スキル持続時間（秒） */
    public Integer skillTime;
    /** スキル経過時間 */
    public Integer skillCount = 0;
    /** スキル発動中の合計獲得CP */
    public Double costFinal;
    /** 1秒あたりの獲得CP */
    public Double costAddition;
    /** 配置済みフラグ */
    public boolean isDeployed = false;
    /** スキル発動中フラグ */
    public boolean skillFlg = false;

    /**
     * CP・SPの時系列計算を実行するメソッド。
     *
     * @param charaDto 選択されたオペレーターの情報
     * @param prefDto  ゲーム環境の設定情報
     * @return 秒数をキー、CP値をバリューとしたMap
     */
    public Map<Integer, Integer> costCalculation(CharacterDto charaDto, PreferenceDto prefDto) {

        // DTOから各パラメータを初期化
        second = 0;
        timeLimit = prefDto.timeLimit;
        cost = prefDto.costInitial.doubleValue();
        costBuff = prefDto.costBuff;
        costSpeed = prefDto.costSpeed;
        costLimit = prefDto.costLimit;
        spSpeed = prefDto.spSpeed;
        spBuff = prefDto.spBuff;

        deployCost = charaDto.deployCost;
        spRequire = charaDto.spRequire;
        sp = charaDto.spInitial + spBuff;
        skillTime = charaDto.skillTime;
        costFinal = 12.0;

        // skillTimeが0（即時型）の場合は全量を1秒で加算
        if (skillTime == 0) {
            costAddition = costFinal;
        } else {
            costAddition = costFinal / skillTime;
        }

        Map<Integer, Integer> outMap = new LinkedHashMap<>();

        while (second <= timeLimit) {

            // SP満タンかつ配置済みでスキル発動
            if (isDeployed && spRequire <= sp) {
                skillFlg = true;
            }

            if (skillFlg) {
                // スキル発動中はCPを加算
                cost += costAddition;
                if (skillTime <= skillCount) {
                    // スキル終了：フラグリセット
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
                // 通常時はSPを回復
                sp++;
            }

            // CP条件を満たした瞬間に配置
            if (!isDeployed && deployCost <= cost) {
                isDeployed = true;
                cost -= deployCost;
            }

            // 現在秒のCP値を記録
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
