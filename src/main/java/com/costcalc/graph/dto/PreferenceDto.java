package com.costcalc.graph.dto;

/**
 * 画面で設定されたゲーム環境の条件を受け取るDTO。
 * CP・SPの基本設定と、編成による補正フラグを保持する。
 */
public class PreferenceDto {
    /** 計算時間（秒） */
    public Integer timeLimit;
    /** 初期CP */
    public Integer costInitial;
    /** 初期追加CP（バフ等による加算分） */
    public Integer costBuff;
    /** CP回復速度 */
    public Double costSpeed;
    /** CP上限 */
    public Double costLimit;
    /** SP回復速度 */
    public Double spSpeed;
    /** 初期追加SP（バフ等による加算分） */
    public Integer spBuff;
    /** バグパイプ編成フラグ */
    public boolean bagpipeFlg;
    /** テキサス編成フラグ */
    public boolean texasFlg;
    /** ズィマー編成フラグ */
    public boolean zimaFlg;
    /** シュウ（歳4人）編成フラグ */
    public boolean shuFlg;
    /** ウルピスフォリア編成フラグ */
    public boolean VulpiFlg;
}
