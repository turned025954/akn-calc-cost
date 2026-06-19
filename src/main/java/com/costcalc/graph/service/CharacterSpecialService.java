package com.costcalc.graph.service;

/**
 * キャラクター固有の特殊処理をまとめたクラス。
 * CharacterEnumのspecialFlgがtrueの場合に呼び出される。
 */
public class CharacterSpecialService {

    /**
     * キャラクター固有の特殊処理を適用する。
     *
     * @param opeId   オペレーターID
     * @param service 計算中のサービスインスタンス
     */
    public void applySpecialEffect(Integer opeId, CostCalcService service) {
        switch (opeId) {
            case 1:
                // テキサス固有処理
                break;
            default:
                break;
        }
    }
}
