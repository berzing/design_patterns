package proxy.javaproxy;

public interface PersonBean {

    String getName();
    String getGender();
    String getInterests();
    int getHotOrNotRating();  //1~10

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setHotOrNotRating(int rating);
}
