package model;

public abstract class Report {

    private String bodyText;
    private String id;

    private Report right;
    private Report left;



    /**
     * @param bodyText
     * @param id
     */
    public Report(String bodyText, String id) {
        this.bodyText = bodyText;
        this.id = id;
    }

    public abstract void formatMaker();

    /**
     * @return the bodyText
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the bodyText to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the right
     */
    public Report getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Report right) {
        this.right = right;
    }

    /**
     * @return the left
     */
    public Report getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Report left) {
        this.left = left;
    }

}