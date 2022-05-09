package com.journal.journal.entry;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table
public class Entry {
    @Id
    @SequenceGenerator(
            name = "journal_sequence",
            sequenceName = "journal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "journal_sequence"
    )
    private Long id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String content;
    private LocalDate date;

    public Entry() {
    }

    public Entry(Long id, String content, String title, LocalDate date) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public Entry(String content, String title, LocalDate date) {
        this.content = content;
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
