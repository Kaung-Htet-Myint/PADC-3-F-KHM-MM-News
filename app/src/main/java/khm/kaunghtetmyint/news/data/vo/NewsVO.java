package khm.kaunghtetmyint.news.data.vo;

import org.w3c.dom.Comment;

import java.util.List;

/**
 * Created by User on 12/17/2017.
 */

public class NewsVO {

    private String newsID;
    private String brief;
    private String details;
    private List<String> images;
    private String postedDate;
    private PublicationVO publication;
    private FavoriteVO[] favorties;
    private List<CommentVO> comments;
    private List<SendToVO> sendTo;

    public List<String> getImages() {
        return images;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SendToVO> getSendTo() {
        return sendTo;
    }


    public String getNewsID() {
        return newsID;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }



    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public FavoriteVO[] getFavorties() {
        return favorties;
    }


}
