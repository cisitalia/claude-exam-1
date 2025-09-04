package co.kr.example.sb2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sido")
public class Sido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    
    @Column(name = "sido", nullable = false, columnDefinition = "varchar(255) default ''")
    private String sido;
    
    @Column(name = "gugun", nullable = false, columnDefinition = "varchar(255) default ''")
    private String gugun;
    
    public Sido() {}
    
    public Sido(String sido, String gugun) {
        this.sido = sido;
        this.gugun = gugun;
    }
    
    public Integer getSeq() {
        return seq;
    }
    
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    
    public String getSido() {
        return sido;
    }
    
    public void setSido(String sido) {
        this.sido = sido;
    }
    
    public String getGugun() {
        return gugun;
    }
    
    public void setGugun(String gugun) {
        this.gugun = gugun;
    }
}