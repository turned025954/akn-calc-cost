package com.costcalc.graph.dto;

/**
 * 画面で選択されたオペレーターの情報を受け取るDTO。
 * パラメータの実値はCharacterEnumから取得し、このDTOはIDと選択内容の受け渡しに使用する。
 */
public class CharacterDto {
    /** オペレーターID */
    public String opeId;
    /** オペレーター名 */
    public String opeName;
    /** 配置コスト */
    public Integer deployCost;
    /** 必要SP */
    public Integer spRequire;
    /** 初期SP */
    public Integer spInitial;
    /** スキル持続時間（秒）。0の場合は即時発動型 */
    public Integer skillTime;
    /** スキル発動中の合計獲得CP */
    public Integer skillCost;
    /** CP回復タイプ */
    public String cpType;
    /** SP回復タイプ */
    public String spType;
}
