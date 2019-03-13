#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
public class Role {

    @Id
    @SequenceGenerator(name = "role_id_generator", sequenceName = "role_id_seq")
    @GeneratedValue(generator = "role_id_generator")
    Long id;

    @Column(name="name", unique = true)
    String name;

}
