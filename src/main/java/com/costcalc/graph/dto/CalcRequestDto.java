package com.costcalc.graph.dto;

import java.util.List;

/**
 * コスト計算APIのリクエストをまとめて受け取るDTO。
 * HTTPリクエストボディは1つしか持てないため、CharacterDtoリストとPreferenceDtoをこのDTOでラップする。
 */
public class CalcRequestDto {
    /** オペレーター情報リスト */
    public List<CharacterDto> charaDtoList;
    /** ゲーム環境設定 */
    public PreferenceDto prefDto;
}
