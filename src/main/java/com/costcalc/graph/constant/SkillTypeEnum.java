package com.costcalc.graph.constant;

/**
 * スキル種別を定義するEnum。
 */
public enum SkillTypeEnum {
    /** 手動発動 */
    MANUAL(1),
    /** 自動発動 */
    AUTO(2),
    /** パッシブ */
    PASSIVE(3);

    /** スキル種別コード */
    private final int code;

    /**
     * コンストラクタ。
     *
     * @param code スキル種別コード
     */
    SkillTypeEnum(int code) { this.code = code; }

    /**
     * スキル種別コードを返す。
     * @return code
     */
    public int getCode() { return code; }
}
