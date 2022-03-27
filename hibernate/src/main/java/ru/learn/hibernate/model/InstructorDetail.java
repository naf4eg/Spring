package ru.learn.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "youtube_channel")
    private String youtube_channel;

    @Column(name = "hobby")
    private String hobby;

    /**
     * For bi-derectional mode
     */
    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    public InstructorDetail(){}

    public InstructorDetail(String youtube_channel, String hobby) {
        this.youtube_channel = youtube_channel;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutube_channel() {
        return youtube_channel;
    }

    public void setYoutube_channel(String youtube_channel) {
        this.youtube_channel = youtube_channel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtube_channel='" + youtube_channel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
