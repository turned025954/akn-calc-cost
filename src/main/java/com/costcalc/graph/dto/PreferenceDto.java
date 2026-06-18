package com.costcalc.graph.dto;


public class PreferenceDto {
    /**
     * 計算時間
     */
    public Integer timeLimit;
    /**
     * 初期cost
     */
    public Integer costInitial;
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
     * SP回復速度
     */
    public Double spSpeed;
    /**
     * 初期追加SP
     */
    public Integer spBuff;
    /**
     * バグパイプ編成
     */
    public boolean bagpipeFlg;
    /**
     * テキサス編成
     */
    public boolean texasFlg;
    /**
     * ズィマー編成
     */
    public boolean zimaFlg;
    /**
     * シュウ（歳4人）編成
     */
    public boolean shuFlg;
    /**
     * ウルピスフォリア編成
     */
    public boolean VulpiFlg;
}
