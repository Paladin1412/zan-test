package com.hu.zan;

import java.util.List;

/**
 * 调账元数据check结果
 *
 * @version 1.0
 * @author: hupeng.hp240298@alibaba-inc.com
 * @since: 2020/05/12 16/58
 */
public class CfFinanceMetaDataCheckVO {

    private static final long serialVersionUID = -2998378221233695413L;
    /**
     * 被校验的code
     */
    String code;
    /**
     * 被校验的name
     */
    String name;
    /**
     * 匹配结果
     */
    List<MatchingResults> matchingResults;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MatchingResults> getMatchingResults() {
        return matchingResults;
    }

    public void setMatchingResults(
        List<MatchingResults> matchingResults) {
        this.matchingResults = matchingResults;
    }

    public static class MatchingResults {
        /**
         * 匹配结果code
         */
        String code;
        /**
         * 匹配结果name
         */
        String name;
        /**
         * 匹配结果type
         */
        String type;
        /**
         * 匹配方式
         */
        Integer matchingType = 4;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getMatchingType() {
            return matchingType;
        }

        public void setMatchingType(Integer matchingType) {
            this.matchingType = matchingType;
        }
    }
}
