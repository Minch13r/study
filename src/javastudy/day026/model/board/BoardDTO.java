package javastudy.day026.model.board;

import java.util.Date;

public class BoardDTO {
    private int num;
    private String title;
    private String content;
    private String writer; // FK : 상대 테이블의 PK ▶ JOIN으로 데이터 불러오기 가능
    private int cnt;
    private Date regdate;

    private String name; // JOIN으로 받아올 데이터
    private String condition;
    private String searchKeyword;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getSearchKeyword() {
        return searchKeyword;
    }
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "BoardDTO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", cnt="
                + cnt + ", regdate=" + regdate + "]";
    }
}
