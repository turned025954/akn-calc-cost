package com.costcalc.graph.dto;

/**
 * グラフ計算APIのリクエストをまとめて受け取るDTO。
 * HTTPリクエストボディは1つしか持てないため、CharacterDtoとPreferenceDtoをこのDTOでラップする。
 */
public class CalcRequestDto {
    /** オペレーター情報 */
    public CharacterDto charaDto;
    /** ゲーム環境設定 */
    public PreferenceDto prefDto;
}
