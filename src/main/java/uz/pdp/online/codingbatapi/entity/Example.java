package uz.pdp.online.codingbatapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //*incoming parameters
    @Column(nullable = false)

    private String incoming;
    //*outgoing parameters
    @Column(nullable = false)
    private String outgoing;
    @ManyToOne
    private  Task task;
}
