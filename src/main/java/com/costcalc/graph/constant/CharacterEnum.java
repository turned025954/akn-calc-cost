package com.costcalc.graph.constant;

public enum CharacterEnum {
    TEXAS(1,"テキサス", 1.0, 8, 40, 30);

    private final Integer id;
    private final String characterName;
    private final Double initialCost;
    private final Integer costDeploy;
    private final Integer spRequire;
    private final Integer spInitial;
    
    CharacterEnum(Integer id, String characterName, Double initialCost, Integer costDeploy, Integer spRequire ,Integer spInitial) {
        this.id = id;
        this.characterName = characterName;
        this.initialCost = initialCost;
        this.costDeploy = costDeploy;
        this.spRequire = spRequire;
        this.spInitial = spInitial;
    }


//     (1, "TEXAS", 10.0, 1.0, 8, 40),
//     凛御シルバーアッシュ
// ミュルジス
// フレイムテイル
// バグパイプ
// シージ
// サガ
// サイラッハ
// ウルピスフォリア
// ヴィジェル
// イネス
// エリジウム
// カンタービレ
// キアーベ
// グラニ
// ケストレル
// サーファー
// ズィマー
// チルチャック
// テキサス
// パズル
// ブラックナイト
// ポンシラス
// マツキリ
// ミトム
// リード
// ワイルドメイン
// ワンチィン
// 歴陣鋭槍フェン
// ヴィグナ
// クーリエ
// スカベンジャー
// スネグーラチカ
// テンニンカ
// ビーンストーク
// バニラ
// フェン
// CONFESS-47
//     private final Integer id;
//     private final String characterName;
//     private final Double initialCost;
//     private final Double costSpeed;
//     private final Integer deployCost;
//     private final Integer spRequire;
}