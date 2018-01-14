package khm.kaunghtetmyint.news.delegates;

import khm.kaunghtetmyint.news.data.vo.NewsVO;

/**
 * Created by User on 12/17/2017.
 */

public interface NewsActionDelegate {

     void onTapNewsItem(NewsVO newsVO);
     void onTapCommentButton();
     void onTapSendToButton();
     void onTapFavoriteButton();
}
