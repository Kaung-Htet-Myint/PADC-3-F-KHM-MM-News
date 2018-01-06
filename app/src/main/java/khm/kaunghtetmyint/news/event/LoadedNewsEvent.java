package khm.kaunghtetmyint.news.event;

import java.util.List;

import khm.kaunghtetmyint.news.data.vo.NewsVO;

/**
 * Created by User on 12/24/2017.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsList;

    public List<NewsVO> getNewsList() {
        return newsList;
    }

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }




}
