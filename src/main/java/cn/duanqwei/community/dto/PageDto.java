package cn.duanqwei.community.dto;

import cn.duanqwei.community.bean.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDto {

    private List<QuestionDto> questions;
    private boolean hasPre;
    private boolean hasFirst;
    private boolean hasNext;
    private boolean hasEnd;
    private User user;

    private Integer currentPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCount, Integer page, Integer size) {

        Integer toalPage;
        if(totalCount%size == 0){
            toalPage = totalCount/size;
        }else {
            toalPage = totalCount/size + 1;
        }

        pages.add(page);
        for (int i = 0;i<=3;i++){
            if(page - i > 0){
                pages.add(page - i,0);
            }
            if(page+i <= totalCount){
                pages.add(page+i);
            }
        }

        if(page == 1){
            hasPre = false;
        }else {
            hasPre = true;
        }

        if(page == toalPage){
            hasNext = false;
        }else {
            hasNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)){
            hasFirst = false;
        }else {
            hasFirst = true;
        }

        //是否展示最后一页
        if(pages.contains(toalPage)){
            hasEnd = false;
        }else {
            hasEnd = true;
        }
    }
}
