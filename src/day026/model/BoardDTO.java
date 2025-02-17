package day026.model;

import java.util.Date;

public class BoardDTO {
    private int num;
    private String title;
    private String content;
    private String writer; // FK(외래키)
    // FK는 반드시 상대 Primary Key 값을 넣어야 함 ▶ JOIN으로 데이터 불러오기 가능
    private int cnt;
    private Date regdate;

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
        return "BoardDTO{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", cnt=" + cnt +
                ", regdate=" + regdate +
                '}';
    }
}
