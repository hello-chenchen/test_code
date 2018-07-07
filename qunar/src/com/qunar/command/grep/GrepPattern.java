package com.qunar.command.grep;

public class GrepPattern {
    private String filterParam = null;
    public GrepPattern(String filterParam) {
        this.filterParam = filterParam;
    }

    public String getFilterParam() {
        return filterParam;
    }

    public void setFilterParam(String filterParam) {
        this.filterParam = filterParam;
    }
}
