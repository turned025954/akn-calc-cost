package com.costcalc.graph.constant;

/**
 * オペレーターのマスタデータを管理するEnum。
 * DBテーブルは使用せず、このEnumで全オペレーターのパラメータを保持する。
 */
public enum CharacterEnum {
    /** テキサス */
    TEXAS(1, "テキサス", 1.0, 8, 40, 30, 1, 0, 12);

    /** オペレーターID */
    private final Integer id;
    /** オペレーター名 */
    private final String characterName;
    /** 初期コスト */
    private final Double initialCost;
    /** 配置コスト */
    private final Integer costDeploy;
    /** 必要SP */
    private final Integer spRequire;
    /** 初期SP */
    private final Integer spInitial;
    /** スキル種別（1:手動、2:自動、3:パッシブ 等） */
    private final Integer skillType;
    /** スキル持続時間（秒）。0の場合は即時発動型 */
    private final Integer skillTime;
    /** スキル発動中の合計獲得CP */
    private final Integer skillCost;

    /**
     * コンストラクタ。
     *
     * @param id            オペレーターID
     * @param characterName オペレーター名
     * @param initialCost   初期コスト
     * @param costDeploy    配置コスト
     * @param spRequire     必要SP
     * @param spInitial     初期SP
     * @param skillType     スキル種別
     * @param skillTime     スキル持続時間（秒）
     * @param skillCost     スキル発動中の合計獲得CP
     */
    CharacterEnum(Integer id, String characterName, Double initialCost, Integer costDeploy, Integer spRequire, Integer spInitial,
                  Integer skillType, Integer skillTime, Integer skillCost) {
        this.id = id;
        this.characterName = characterName;
        this.initialCost = initialCost;
        this.costDeploy = costDeploy;
        this.spRequire = spRequire;
        this.spInitial = spInitial;
        this.skillType = skillType;
        this.skillTime = skillTime;
        this.skillCost = skillCost;
    }

    /**
     * オペレーターIDを返す。
     * @return id
     */
    public Integer getId() { return id; }

    /**
     * オペレーター名を返す。
     * @return characterName
     */
    public String getCharacterName() { return characterName; }

    /**
     * 初期コストを返す。
     * @return initialCost
     */
    public Double getInitialCost() { return initialCost; }

    /**
     * 配置コストを返す。
     * @return costDeploy
     */
    public Integer getCostDeploy() { return costDeploy; }

    /**
     * 必要SPを返す。
     * @return spRequire
     */
    public Integer getSpRequire() { return spRequire; }

    /**
     * 初期SPを返す。
     * @return spInitial
     */
    public Integer getSpInitial() { return spInitial; }

    /**
     * スキル種別を返す。
     * @return skillType
     */
    public Integer getSkillType() { return skillType; }

    /**
     * スキル持続時間（秒）を返す。
     * @return skillTime
     */
    public Integer getSkillTime() { return skillTime; }

    /**
     * スキル発動中の合計獲得CPを返す。
     * @return skillCost
     */
    public Integer getSkillCost() { return skillCost; }
}
