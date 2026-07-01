package com.costcalc.graph.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.costcalc.graph.dto.CharacterDto;
import com.costcalc.graph.dto.PreferenceDto;

/**
 * CPの時系列変化を計算するサービスクラス。
 * 1秒ごとのCP値をMapに格納して返却する。
 */
@Service
public class CostCalcService {

    /** 経過秒数 */
    public Integer second;
    /** 計算終了時間（秒） */
    public Integer timeLimit;
    /** 現在のCP（プレイヤー全体で共有） */
    public Double cost;
    /** CP回復速度 */
    public Double costSpeed;
    /** CP上限 */
    public Double costLimit;
    /** 初期追加SP */
    public Integer spBuff;

    /**
     * コスト計算の統括メソッド。
     *
     * @param charaDtoList 選択されたオペレーターの情報リスト
     * @param prefDto      ゲーム環境の設定情報
     * @return 秒数をキー、CP値をバリューとしたMap
     */
    public Map<Integer, Integer> costCalculation(List<CharacterDto> charaDtoList, PreferenceDto prefDto) {
        initialize(prefDto);

        // キャラごとの状態を生成
        List<CharacterState> stateList = new ArrayList<>();
        for (CharacterDto charaDto : charaDtoList) {
            stateList.add(new CharacterState(charaDto, spBuff));
        }

        Map<Integer, Integer> outMap = new LinkedHashMap<>();

        while (second <= timeLimit) {
            // キャラごとにCPの増減を計算
            for (CharacterState state : stateList) {
                calcPerSecond(state);
            }

            // 現在秒のCP値を記録
            outMap.put(second, cost.intValue());

            second++;

            // CP自然回復
            if (costLimit <= cost) {
                cost = costLimit;
            } else {
                cost += costSpeed;
            }
        }

        return outMap;
    }

    /**
     * 環境設定の初期化処理。
     *
     * @param prefDto ゲーム環境の設定情報
     */
    private void initialize(PreferenceDto prefDto) {
        second = 0;
        timeLimit = prefDto.timeLimit;
        cost = prefDto.costInitial.doubleValue();
        costSpeed = prefDto.costSpeed;
        costLimit = prefDto.costLimit;
        spBuff = prefDto.spBuff;
    }

    /**
     * 1キャラ・1秒分のCP増減計算処理。
     * SPと配置・スキル状態は引数のstateを更新し、CPは共有のフィールドを更新する。
     *
     * @param state 対象キャラクターの状態
     */
    private void calcPerSecond(CharacterState state) {

        // 1秒あたりの獲得CPを算出（skillTime=0は即時型）
        double costAddition;
        if (state.skillTime == 0) {
            costAddition = state.skillCost;
        } else {
            costAddition = state.skillCost / state.skillTime;
        }

        // SP満タンかつ配置済みでスキル発動
        if (state.isDeployed && state.spRequire <= state.sp) {
            state.skillFlg = true;
        }

        if (state.skillFlg) {
            // スキル発動中はCPを加算
            cost += costAddition;
            if (state.skillTime <= state.skillCount) {
                // スキル終了：状態リセット
                state.skillFlg = false;
                state.skillCount = 0;
                state.sp = 0;
            } else {
                state.skillCount++;
            }

            if (costLimit <= cost) {
                cost = costLimit;
            }

        } else {
            // 通常時はSPを回復
            state.sp++;
        }

        // CP条件を満たした瞬間に配置
        if (!state.isDeployed && state.deployCost <= cost) {
            state.isDeployed = true;
            cost -= state.deployCost;
        }
    }
}
