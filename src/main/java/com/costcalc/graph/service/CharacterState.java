package com.costcalc.graph.service;

import com.costcalc.graph.dto.CharacterDto;

/**
 * 1キャラクターの計算中の状態を保持するクラス。
 * SP・配置状態・スキル状態はキャラごとに独立するため、キャラ単位で持つ。
 */
public class CharacterState {

    /** 配置コスト */
    public final Integer deployCost;
    /** 必要SP */
    public final Integer spRequire;
    /** スキル持続時間（秒） */
    public final Integer skillTime;
    /** スキル発動中の合計獲得CP */
    public final Double skillCost;

    /** 現在のSP */
    public Integer sp;
    /** スキル経過時間 */
    public Integer skillCount = 0;
    /** 配置済みフラグ */
    public boolean isDeployed = false;
    /** スキル発動中フラグ */
    public boolean skillFlg = false;

    /**
     * コンストラクタ。
     * Enum/DTO由来の固定値をセットし、初期SPを反映する。
     *
     * @param charaDto 対象オペレーターの情報
     * @param spBuff   初期追加SP
     */
    public CharacterState(CharacterDto charaDto, Integer spBuff) {
        this.deployCost = charaDto.deployCost;
        this.spRequire = charaDto.spRequire;
        this.skillTime = charaDto.skillTime;
        this.skillCost = charaDto.skillCost.doubleValue();
        this.sp = charaDto.spInitial + spBuff;
    }
}
